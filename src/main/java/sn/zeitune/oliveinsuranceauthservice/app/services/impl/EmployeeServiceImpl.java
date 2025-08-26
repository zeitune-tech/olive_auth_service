package sn.zeitune.oliveinsuranceauthservice.app.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeProfilesRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeUpdate;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.InterServiceUserRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.EmployeeResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Permission;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Profile;
import sn.zeitune.oliveinsuranceauthservice.app.entities.User;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.exceptions.NotFoundException;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.EmployeeMapper;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.EmployeeRepository;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.PermissionRepository;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.ProfileRepository;
import sn.zeitune.oliveinsuranceauthservice.app.repositories.UserRepository;
import sn.zeitune.oliveinsuranceauthservice.app.services.EmployeeService;
import sn.zeitune.oliveinsuranceauthservice.app.specifications.EmployeeSpecifications;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

    private final WebClient.Builder webClientBuilder;
    @Value("${services.olive-insurance-administration-service.base-url}")
    private String adminBaseUrl;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Employee employee = EmployeeMapper.map(request, null);

        employee.setPassword(passwordEncoder.encode(request.password()));

        if (request.profiles() != null && !request.profiles().isEmpty()) {
            Set<Profile> profiles = new HashSet<>(profileRepository.findAllByUuidIn(request.profiles()));
            employee.setProfiles(profiles);
        }

        return EmployeeMapper.map(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponse updateEmployee(UUID uuid, EmployeeRequest request) {
        Employee existing = employeeRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Employé non trouvé avec UUID: " + uuid));

        Employee updated = EmployeeMapper.map(request, existing);

        return EmployeeMapper.map(employeeRepository.save(updated));
    }

    @Override
    public void updatePassword(UUID uuid, String newPassword) {
        if (newPassword == null || newPassword.isBlank()) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide.");
        }

        Employee employee = employeeRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Employé non trouvé avec UUID: " + uuid));

        employee.setPassword(passwordEncoder.encode(newPassword));
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeResponse updateProfiles(UUID uuid, EmployeeProfilesRequest request) {
        Employee employee = employeeRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Employé non trouvé avec UUID: " + uuid));

        if (request.profileIds() == null || request.profileIds().isEmpty()) {
            employee.setProfiles(Collections.emptySet());
        } else {
            Set<Profile> profiles = new HashSet<>(profileRepository.findAllByUuidIn(request.profileIds()));
            employee.setProfiles(profiles);
        }

        return EmployeeMapper.map(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponse activateEmployee(UUID uuid) {
        return employeeRepository.findByUuid(uuid)
                .map(employee -> {
                    employee.setAccountNonLocked(true);
                    return EmployeeMapper.map(employeeRepository.save(employee));
                })
                .orElseThrow(() -> new NotFoundException("Employé non trouvé avec UUID: " + uuid));
    }

    @Override
    public EmployeeResponse deactivateEmployee(UUID uuid) {
        return employeeRepository.findByUuid(uuid)
                .map(employee -> {
                    employee.setAccountNonLocked(false);
                    return EmployeeMapper.map(employeeRepository.save(employee));
                })
                .orElseThrow(() -> new NotFoundException("Employé non trouvé avec UUID: " + uuid));
    }


    @Override
    public EmployeeResponse createAdminUserForEntity(InterServiceUserRequest employee) {
        // 1. Check if the employee already exists
        Optional<User> existingEmployee = userRepository.findByEmail(employee.email());
        if (existingEmployee.isPresent()) {
            throw new IllegalArgumentException("L'utilisateur existe déjà avec cet email: " + employee.email());
        }
        // 2. Create a new employee
        Employee newEmployee = EmployeeMapper.map(employee);

        // 3. Set the password
        newEmployee.setPassword(passwordEncoder.encode("P@ssw0rd"));

        // 4. Create admin profile
        // 4.1 Get permissions for the profile
        List<Permission> permissions = permissionRepository.findAllByLevelAndType(
                employee.accessLevel(),
                employee.type()
        );
        // 4.2 Create the profile
        Profile adminProfile = Profile.builder()
                .name("ADMIN_" + employee.accessLevel())
                .description("profiles.descriptions." + employee.type() + "." + employee.accessLevel())
                .permissions(new HashSet<>(permissions))
                .level(employee.accessLevel())
                .managementEntity(employee.managementEntity())
                .build();
        // 4.3 Save the profile
        adminProfile = profileRepository.save(adminProfile);
        // 4.4 if type id Company
        if (employee.accessLevel() == ManagementEntityType.COMPANY) {
            // create a PointOfSale profile
            List<Permission> pointOfSalePermissions = permissionRepository.findAllByLevelAndType(
                    ManagementEntityType.POINT_OF_SALE,
                    ManagementEntityType.COMPANY
            );
            Profile pointOfSaleProfile = Profile.builder()
                    .name("ADMIN_" + ManagementEntityType.POINT_OF_SALE)
                    .description("profiles.descriptions." + ManagementEntityType.POINT_OF_SALE)
                    .permissions(new HashSet<>(pointOfSalePermissions))
                    .level(ManagementEntityType.POINT_OF_SALE)
                    .managementEntity(employee.managementEntity())
                    .build();
            profileRepository.save(pointOfSaleProfile);
        }
        // Create simple User Permission
        Permission view_management_entity = permissionRepository.findOneByNameAndTypeAndLevel(
                "VIEW_MANAGEMENT_ENTITY",
                employee.type(),
                employee.accessLevel()
        );

        // 5. Set the profile to the employee
        newEmployee.setProfiles(Set.of(adminProfile));

        // 6. Save the employee
        Employee savedEmployee = employeeRepository.save(newEmployee);
        return EmployeeMapper.map(savedEmployee);
    }

    @Override
    public Optional<UUID> findManagementEntityByName(String name) {
        if (name == null || name.isBlank()) {
            return Optional.empty();
        }
        try {
            String base = adminBaseUrl;
            if (base != null && !base.startsWith("http")) {
                base = "http://" + base;
            }
            Map<String, Object> responseBody = webClientBuilder
                    .baseUrl(base)
                    .build()
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/interservices/management-entities/search/{name}")
                            .build(name))
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .onStatus(HttpStatusCode::isError, this::handleAdminServiceError)
                    .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                    .block();

            if (responseBody == null) {
                return Optional.empty();
            }
            Object idValue = responseBody.get("id");
            if (idValue == null) {
                return Optional.empty();
            }
            String idStr = String.valueOf(idValue);
            try {
                return Optional.of(UUID.fromString(idStr));
            } catch (IllegalArgumentException e) {
                log.error("Invalid UUID received from admin-service for management entity '{}': {}", name, idStr);
                return Optional.empty();
            }
        } catch (Exception e) {
            log.error("Error while calling admin-service to find management entity by name '{}': {}", name, e.getMessage());
            return Optional.empty();
        }
    }

    private Mono<Throwable> handleAdminServiceError(ClientResponse response) {
        return response.bodyToMono(String.class).flatMap(errorBody -> {
            log.error("Error response from admin-service: status={} body={}", response.statusCode(), errorBody);
            return Mono.error(new RuntimeException("Admin service call failed: " + errorBody));
        });
    }

    @Override
    public void deleteEmployee(UUID uuid) {
        Employee employee = employeeRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Employé non trouvé avec UUID: " + uuid));

        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeResponse getEmployeeByUuid(UUID uuid) {
        Employee employee = employeeRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("Employé non trouvé avec UUID: " + uuid));

        return EmployeeMapper.map(employee);
    }

    @Override
    public Page<EmployeeResponse> searchEmployees(Specification<Employee> spec, Pageable pageable) {
        return employeeRepository.findAll(spec, pageable)
                .map(EmployeeMapper::map);
    }

    @Override
    public List<EmployeeResponse> getAllByManagementEntity(UUID managementEntity) {
        return employeeRepository.findAllByManagementEntity(managementEntity)
                .stream()
                .map(EmployeeMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Page<EmployeeResponse> getAllByManagementEntity(UUID managementEntity, Specification<Employee> spec, Pageable pageable) {
        Specification<Employee> fullSpec = Specification
                .where(EmployeeSpecifications.hasManagementEntity(managementEntity))
                .and(spec);

        return employeeRepository.findAll(fullSpec, pageable)
                .map(EmployeeMapper::map);
    }
}
