package sn.zeitune.oliveinsuranceauthservice.app.dto.responses;

import sn.zeitune.oliveinsuranceauthservice.app.entities.ContributorType;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ContributorLevel;

import java.util.UUID;

public record ContributorResponse(
        UUID id,
        String firstname,
        String lastname,
        String email,
        ContributorLevel level,
        UUID managementEntity,
        ContributorTypeResponse contributorType
) {
}
