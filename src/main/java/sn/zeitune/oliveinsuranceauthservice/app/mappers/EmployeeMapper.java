package sn.zeitune.oliveinsuranceauthservice.app.mappers;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.EmployeeRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.InterServiceUserRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.EmployeeResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;

import java.util.stream.Collectors;

public class EmployeeMapper {

    public static Employee map(EmployeeRequest request, Employee employee) {
        if (request == null) {
            return employee;
        }

        if (employee == null) {
            employee = new Employee();
        }

        employee.setFirstname(request.firstname());
        employee.setLastname(request.lastname());
        employee.setEmail(request.email());
        employee.setRole(UserRole.USER);
        employee.setAccessLevel(request.accessLevel());
        employee.setManagementEntity(request.managementEntity());

        return employee;
    }

    public static Employee map(InterServiceUserRequest request) {
        Employee employee = new Employee();

        employee.setFirstname("ADMIN");
        employee.setLastname(request.name());
        employee.setEmail(request.email());
        employee.setRole(UserRole.USER);
        employee.setAccessLevel(request.accessLevel());
        employee.setManagementEntity(request.managementEntity());

        return employee;
    }

    public static EmployeeResponse map(Employee employee) {
        if (employee == null) {
            return null;
        }

        return EmployeeResponse.builder()
                .id(employee.getUuid())
                .firstName(employee.getFirstname())
                .lastName(employee.getLastname())
                .email(employee.getEmail())
                .managementEntity(employee.getManagementEntity())
                .profiles(
                        employee.getProfiles() != null ?
                        employee.getProfiles().stream().map(ProfileMapper::map).collect(Collectors.toSet())
                                : null
                )
                .build();
    }
}
