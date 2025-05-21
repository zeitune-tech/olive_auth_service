package sn.zeitune.oliveinsuranceauthservice.app.specifications;

import org.springframework.data.jpa.domain.Specification;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Restriction;
import sn.zeitune.oliveinsuranceauthservice.app.enums.RestrictionType;

import java.util.UUID;

public class RestrictionSpecifications {

    public static Specification<Restriction> hasUuid(UUID uuid) {
        return (root, query, cb) -> cb.equal(root.get("uuid"), uuid);
    }

    public static Specification<Restriction> hasRestrictionType(RestrictionType type) {
        return (root, query, cb) -> cb.equal(root.get("restrictionType"), type);
    }

    public static Specification<Restriction> hasManagementEntity(UUID managementEntity) {
        return (root, query, cb) -> cb.equal(root.get("managementEntity"), managementEntity);
    }

    public static Specification<Restriction> hasEmployeeUuid(UUID employeeUuid) {
        return (root, query, cb) -> cb.equal(root.get("employee").get("uuid"), employeeUuid);
    }
}
