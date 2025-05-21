package sn.zeitune.oliveinsuranceauthservice.app.mappers;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.PermissionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.PermissionResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Permission;

public class PermissionMapper {

    public static Permission map(PermissionRequest request, Permission permission) {
        if (request == null) return permission;
        if (permission == null) permission = new Permission();

        permission.setName(request.name());
        permission.setDescription(request.description());
        permission.setType(request.type());

        return permission;
    }

    public static PermissionResponse map(Permission permission) {
        if (permission == null) return null;

        return PermissionResponse.builder()
                .id(permission.getUuid())
                .name(permission.getName())
                .description(permission.getDescription())
                .type(permission.getType())
                .level(permission.getLevel())
                .module(permission.getModule())
                .build();
    }
}
