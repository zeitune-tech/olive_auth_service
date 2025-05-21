package sn.zeitune.oliveinsuranceauthservice.dto.responses;

import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.enums.ManagementEntityType;

import java.util.Set;
import java.util.UUID;

@Builder
public record ProfileResponse(
        UUID uuid,
        String name,
        String description,
        ManagementEntityType level,
        UUID managementEntity,
        Set<PermissionResponse> permissions
) {}
