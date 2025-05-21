package sn.zeitune.oliveinsuranceauthservice.dto.responses;

import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.enums.ManagementEntityType;

import java.util.UUID;

@Builder
public record PermissionResponse(
        UUID uuid,
        String name,
        String description,
        ManagementEntityType type
) {}
