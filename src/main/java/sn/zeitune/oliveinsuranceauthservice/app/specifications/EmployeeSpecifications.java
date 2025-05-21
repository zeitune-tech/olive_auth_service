package sn.zeitune.oliveinsuranceauthservice.app.specifications;

import org.springframework.data.jpa.domain.Specification;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.enums.UserRole;

import jakarta.persistence.criteria.Predicate;
import java.util.UUID;

public class EmployeeSpecifications {

    public static Specification<Employee> hasFirstname(String firstname) {
        return (root, query, criteriaBuilder) ->
                firstname == null ? null :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("firstname")), "%" + firstname.toLowerCase() + "%");
    }

    public static Specification<Employee> hasLastname(String lastname) {
        return (root, query, criteriaBuilder) ->
                lastname == null ? null :
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("lastname")), "%" + lastname.toLowerCase() + "%");
    }

    public static Specification<Employee> hasEmail(String email) {
        return (root, query, criteriaBuilder) ->
                email == null ? null :
                        criteriaBuilder.equal(criteriaBuilder.lower(root.get("email")), email.toLowerCase());
    }

    public static Specification<Employee> hasRole(UserRole role) {
        return (root, query, criteriaBuilder) ->
                role == null ? null :
                        criteriaBuilder.equal(root.get("role"), role);
    }

    public static Specification<Employee> hasManagementEntity(UUID managementEntityId) {
        return (root, query, criteriaBuilder) ->
                managementEntityId == null ? null :
                        criteriaBuilder.equal(root.get("managementEntity"), managementEntityId);
    }

    public static Specification<Employee> globalSearch(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.trim().isEmpty()) {
                return null;
            }
            String kw = "%" + keyword.toLowerCase() + "%";
            Predicate firstnamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("firstname")), kw);
            Predicate lastnamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("lastname")), kw);
            Predicate emailPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), kw);
            return criteriaBuilder.or(firstnamePredicate, lastnamePredicate, emailPredicate);
        };
    }
}
