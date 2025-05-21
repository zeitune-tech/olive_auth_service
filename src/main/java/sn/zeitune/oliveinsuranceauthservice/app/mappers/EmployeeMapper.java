package sn.zeitune.oliveinsuranceauthservice.mappers;

import sn.zeitune.oliveinsuranceauthservice.dto.requests.EmployeeRequest;
import sn.zeitune.oliveinsuranceauthservice.dto.responses.EmployeeResponse;
import sn.zeitune.oliveinsuranceauthservice.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.entities.Profile;

import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static Employee map(EmployeeRequest request) {
        if (request == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setFirstname(request.firstName());
        employee.setLastname(request.lastName());
        employee.setEmail(request.email());
        employee.setPassword(request.password());
        employee.setManagementEntity(request.managementEntity());
        if (request.profileIds() != null) {
            Set<Profile> profiles = request.profileIds().stream().map(id -> {
                Profile profile = new Profile();
                profile.setId(id);
                return profile;
            }).collect(Collectors.toSet());
            employee.setProfiles(profiles);
        }
        return employee;
    }

    public static EmployeeResponse map(Employee employee) {
        if (employee == null) {
            return null;
        }
        return EmployeeResponse.builder()
                .id(employee.getId())
                .uuid(employee.getUuid())
                .firstName(employee.getFirstname())
                .lastName(employee.getLastname())
                .email(employee.getEmail())
                .profiles(employee.getProfiles() != null ?
                        employee.getProfiles().stream().map(ProfileMapper::map).collect(Collectors.toSet())
                        : null)
                .managementEntity(employee.getManagementEntity())
                .build();
    }
}
