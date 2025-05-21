package sn.zeitune.oliveinsuranceauthservice.specifications;

import org.springframework.data.jpa.domain.Specification;
import sn.zeitune.oliveinsuranceauthservice.entities.Employee;

import java.util.UUID;

public class EmployeeSpecifications {

    public static Specification<Employee> hasUuid(UUID uuid) {
        return (root, query, cb) -> cb.equal(root.get("uuid"), uuid);
    }

    public static Specification<Employee> hasManagementEntity(UUID managementEntity) {
        return (root, query, cb) -> cb.equal(root.get("managementEntity"), managementEntity);
    }

    public static Specification<Employee> hasEmail(String email) {
        return (root, query, cb) -> cb.equal(cb.lower(root.get("email")), email.toLowerCase());
    }
}
