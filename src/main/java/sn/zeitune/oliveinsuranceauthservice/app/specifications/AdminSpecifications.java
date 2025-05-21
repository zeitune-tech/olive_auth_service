package sn.zeitune.oliveinsuranceauthservice.app.specifications;

import org.springframework.data.jpa.domain.Specification;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Admin;

public class AdminSpecifications {

    public static Specification<Admin> hasFirstname(String firstname) {
        return (root, query, cb) ->
                firstname == null ? null :
                        cb.like(cb.lower(root.get("firstname")), "%" + firstname.toLowerCase() + "%");
    }

    public static Specification<Admin> hasLastname(String lastname) {
        return (root, query, cb) ->
                lastname == null ? null :
                        cb.like(cb.lower(root.get("lastname")), "%" + lastname.toLowerCase() + "%");
    }

    public static Specification<Admin> hasEmail(String email) {
        return (root, query, cb) ->
                email == null ? null :
                        cb.equal(cb.lower(root.get("email")), email.toLowerCase());
    }

    public static Specification<Admin> globalSearch(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.trim().isEmpty()) {
                return null;
            }
            String pattern = "%" + keyword.toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("firstname")), pattern),
                    cb.like(cb.lower(root.get("lastname")), pattern),
                    cb.like(cb.lower(root.get("email")), pattern)
            );
        };
    }
}
