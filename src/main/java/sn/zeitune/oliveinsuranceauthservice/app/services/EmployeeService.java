package sn.zeitune.oliveinsuranceauthservice.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeProfilesRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeUpdate;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.InterServiceUserRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.EmployeeResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest request);
    EmployeeResponse updateEmployee(UUID uuid, EmployeeRequest request);
    void deleteEmployee(UUID uuid);
    EmployeeResponse getEmployeeByUuid(UUID uuid);
    Page<EmployeeResponse> searchEmployees(Specification<Employee> spec, Pageable pageable);
    List<EmployeeResponse> getAllByManagementEntity(UUID managementEntity);
    Page<EmployeeResponse> getAllByManagementEntity(UUID managementEntity, Specification<Employee> spec, Pageable pageable);
    void updatePassword(UUID uuid, String newPassword);
    EmployeeResponse updateProfiles(UUID uuid, EmployeeProfilesRequest request);

    EmployeeResponse activateEmployee(UUID uuid);
    EmployeeResponse deactivateEmployee(UUID uuid);

    EmployeeResponse createAdminUserForEntity(InterServiceUserRequest employee);
    Optional<UUID> findManagementEntityByName(String name);
}
