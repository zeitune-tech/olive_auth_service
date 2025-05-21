package sn.zeitune.oliveinsuranceauthservice.app.dto.responses;

import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;

import java.util.Set;
import java.util.UUID;

@Builder
public record ProfileResponse(
        UUID id,
        String name,
        String description,
        ManagementEntityType level,
        UUID managementEntity,
        Set<PermissionResponse> permissions
) {}
