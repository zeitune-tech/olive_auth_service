package sn.zeitune.oliveinsuranceauthservice.app.dto.responses;

import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.enums.Module;

import java.util.UUID;

@Builder
public record PermissionResponse(
        UUID id,
        String name,
        String description,
        ManagementEntityType type,
        ManagementEntityType level,
        Module module
) {}
