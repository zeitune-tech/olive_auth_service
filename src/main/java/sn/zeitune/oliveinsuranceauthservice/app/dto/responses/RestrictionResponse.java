package sn.zeitune.oliveinsuranceauthservice.app.dto.responses;

import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.app.enums.RestrictionType;

import java.util.UUID;

@Builder
public record RestrictionResponse(
        UUID id,
        RestrictionType restrictionType,
        UUID managementEntity
) {}
