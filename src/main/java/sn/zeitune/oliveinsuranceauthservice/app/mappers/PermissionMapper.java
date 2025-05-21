package sn.zeitune.oliveinsuranceauthservice.mappers;

import sn.zeitune.oliveinsuranceauthservice.dto.requests.PermissionRequest;
import sn.zeitune.oliveinsuranceauthservice.dto.responses.PermissionResponse;
import sn.zeitune.oliveinsuranceauthservice.entities.Permission;

public class PermissionMapper {

    public static Permission map(PermissionRequest request) {
        if (request == null) {
            return null;
        }
        Permission permission = new Permission();
        permission.setName(request.name());
        permission.setDescription(request.description());
        permission.setType(request.type());
        return permission;
    }

    public static PermissionResponse map(Permission permission) {
        if (permission == null) {
            return null;
        }
        return PermissionResponse.builder()
                .id(permission.getId())
                .uuid(permission.getUuid())
                .name(permission.getName())
                .description(permission.getDescription())
                .type(permission.getType())
                .build();
    }
}
