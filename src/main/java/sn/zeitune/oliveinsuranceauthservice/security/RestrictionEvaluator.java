package sn.zeitune.oliveinsuranceauthservice.app.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Employee;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Restriction;
import sn.zeitune.oliveinsuranceauthservice.app.enums.RestrictionType;

import java.util.UUID;

@Component("restrictionEvaluator")
@RequiredArgsConstructor
public class RestrictionEvaluator {

    public boolean hasAccessTo(UUID managementEntityId, String requiredTypeName) {
        RestrictionType requiredType;

        try {
            requiredType = RestrictionType.valueOf(requiredTypeName.toUpperCase());
        } catch (IllegalArgumentException e) {
            return false;
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Employee employee) {
            return employee.getRestrictions().stream().anyMatch(r ->
                    r.getManagementEntity().equals(managementEntityId)
                            && r.getRestrictionType().equals(requiredType)
            );
        }

        return false;
    }
}
