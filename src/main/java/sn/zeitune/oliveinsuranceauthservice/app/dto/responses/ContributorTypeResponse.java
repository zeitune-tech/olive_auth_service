package sn.zeitune.oliveinsuranceauthservice.app.dto.responses;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ContributorTypeResponse(
        UUID managementEntity,
        UUID id,
        String label
) {
}
