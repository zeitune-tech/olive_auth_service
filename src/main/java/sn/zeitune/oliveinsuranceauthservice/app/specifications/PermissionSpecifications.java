package sn.zeitune.oliveinsuranceauthservice.app.specifications;

import org.springframework.data.jpa.domain.Specification;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Permission;

import java.util.UUID;

public class PermissionSpecifications {

    public static Specification<Permission> hasUuid(UUID uuid) {
        return (root, query, cb) -> cb.equal(root.get("uuid"), uuid);
    }

    public static Specification<Permission> hasName(String name) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }
}
