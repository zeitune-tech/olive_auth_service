package sn.zeitune.oliveinsuranceauthservice.app.services;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.PermissionRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.PermissionResponse;

import java.util.List;
import java.util.UUID;

public interface PermissionService {

    PermissionResponse createPermission(PermissionRequest request);

    PermissionResponse updatePermission(UUID uuid, PermissionRequest request);

    void deletePermission(UUID uuid);

    PermissionResponse getPermissionByUuid(UUID uuid);

    List<PermissionResponse> getAllPermissions();

    void init();
}
