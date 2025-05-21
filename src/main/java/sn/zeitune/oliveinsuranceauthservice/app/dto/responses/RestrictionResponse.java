package sn.zeitune.oliveinsuranceauthservice.dto.responses;

import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.enums.RestrictionType;

import java.util.UUID;

@Builder
public record RestrictionResponse(
        UUID uuid,
        RestrictionType restrictionType,
        UUID managementEntity
) {}
