package sn.zeitune.oliveinsuranceauthservice.app.mappers;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.RestrictionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.RestrictionResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Restriction;

public class RestrictionMapper {

    public static Restriction map(RestrictionRequest request, Restriction restriction) {
        if (request == null) return restriction;
        if (restriction == null) restriction = new Restriction();

        restriction.setRestrictionType(request.restrictionType());
        restriction.setManagementEntity(request.managementEntity());

        return restriction;
    }

    public static RestrictionResponse map(Restriction restriction) {
        return RestrictionResponse.builder()
                .id(restriction.getUuid())
                .restrictionType(restriction.getRestrictionType())
                .managementEntity(restriction.getManagementEntity())
                .build();
    }
}
