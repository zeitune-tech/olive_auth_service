package sn.zeitune.oliveinsuranceauthservice.mappers;

import sn.zeitune.oliveinsuranceauthservice.dto.requests.RestrictionRequest;
import sn.zeitune.oliveinsuranceauthservice.dto.responses.RestrictionResponse;
import sn.zeitune.oliveinsuranceauthservice.entities.Restriction;

public class RestrictionMapper {

    public static Restriction map(RestrictionRequest request) {
        if (request == null) {
            return null;
        }
        Restriction restriction = new Restriction();
        restriction.setRestrictionType(request.restrictionType());
        restriction.setManagementEntity(request.managementEntity());
        return restriction;
    }

    public static RestrictionResponse map(Restriction restriction) {
        if (restriction == null) {
            return null;
        }
        return RestrictionResponse.builder()
                .uuid(restriction.getUuid())
                .restrictionType(restriction.getRestrictionType())
                .managementEntity(restriction.getManagementEntity())
                .build();
    }
}
