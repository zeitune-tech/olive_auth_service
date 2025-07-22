package sn.zeitune.oliveinsuranceauthservice.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeProfilesRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeUpdate;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.PasswordUpdateRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.EmployeeResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.mappers.EmployeeMapper;
import sn.zeitune.oliveinsuranceauthservice.app.services.EmployeeService;
import sn.zeitune.oliveinsuranceauthservice.app.specifications.EmployeeSpecifications;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/app/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/me")
    public ResponseEntity<EmployeeResponse> getMe(
            Authentication authentication
    ) {
        if (authentication == null) {
            return ResponseEntity.badRequest().build();
        }
        Employee employee = (Employee) authentication.getPrincipal();
        return ResponseEntity.ok(EmployeeMapper.map(employee));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(
            @RequestBody EmployeeRequest request
    ) {
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<EmployeeResponse> update(
            @PathVariable UUID uuid,
            @RequestBody EmployeeRequest request
    ) {
        return ResponseEntity.ok(employeeService.updateEmployee(uuid, request));
    }

    @PutMapping("/{uuid}/activate")
    public ResponseEntity<EmployeeResponse> activate(
            @PathVariable UUID uuid
    ) {
        return ResponseEntity.ok(employeeService.activateEmployee(uuid));
    }

    @PutMapping("/{uuid}/deactivate")
    public ResponseEntity<EmployeeResponse> deactivate(
            @PathVariable UUID uuid
    ) {
        return ResponseEntity.ok(employeeService.deactivateEmployee(uuid));
    }

    @PutMapping("/{uuid}/profiles")
    public ResponseEntity<EmployeeResponse> updateProfiles(
            @PathVariable UUID uuid,
            @RequestBody EmployeeProfilesRequest request
    ) {
        return ResponseEntity.ok(employeeService.updateProfiles(uuid, request));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        employeeService.deleteEmployee(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<EmployeeResponse> getByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(employeeService.getEmployeeByUuid(uuid));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<EmployeeResponse>> searchEmployees(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String email,
            Pageable pageable
    ) {
        var spec = EmployeeSpecifications.hasFirstname(firstname)
                .and(EmployeeSpecifications.hasLastname(lastname))
                .and(EmployeeSpecifications.hasEmail(email));

        return ResponseEntity.ok(employeeService.searchEmployees(spec, pageable));
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeResponse>> search(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String email,
            Pageable pageable,
            Authentication authentication
    ) {
        Employee employee = (Employee) authentication.getPrincipal();
        UUID managementEntity = employee.getManagementEntity();
        var spec = EmployeeSpecifications.hasFirstname(firstname)
                .and(EmployeeSpecifications.hasLastname(lastname))
                .and(EmployeeSpecifications.hasEmail(email));

        return ResponseEntity.ok(employeeService.getAllByManagementEntity(managementEntity, spec, pageable));
    }

    @GetMapping("/management-entity/{managementEntity}")
    public ResponseEntity<Page<EmployeeResponse>> searchByManagementEntity(
            @PathVariable UUID managementEntity,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String email,
            Pageable pageable
    ) {
        var spec = EmployeeSpecifications.hasFirstname(firstname)
                .and(EmployeeSpecifications.hasLastname(lastname))
                .and(EmployeeSpecifications.hasEmail(email));

        return ResponseEntity.ok(employeeService.getAllByManagementEntity(managementEntity, spec, pageable));
    }

    @PutMapping("/{uuid}/password")
    public ResponseEntity<Void> updatePassword(
            @PathVariable UUID uuid,
            @RequestBody PasswordUpdateRequest request
    ) {
        employeeService.updatePassword(uuid, request.newPassword());
        return ResponseEntity.ok().build();
    }
}
