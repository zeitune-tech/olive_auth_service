package sn.zeitune.oliveinsuranceauthservice.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ProfileUpdate;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ProfileUpdatePermissionsRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ProfileRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.PermissionResponse;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ProfileResponse;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;

import java.util.List;
import java.util.UUID;

public interface ProfileService {

    ProfileResponse create(ProfileRequest request, UUID managementEntity);
    ProfileResponse update(UUID uuid, ProfileUpdate request);
    ProfileResponse updatePermissions(UUID uuid, ProfileUpdatePermissionsRequest request);

    void delete(UUID uuid);
    ProfileResponse getByUuid(UUID uuid);
    List<ProfileResponse> getAll(UUID managementEntity);
    Page<ProfileResponse> getAll(Pageable pageable);
    List<ProfileResponse> getAllByManagementEntity(UUID managementEntity);
    Page<ProfileResponse> getAllByManagementEntity(UUID managementEntity, Pageable pageable);

    List<PermissionResponse> getPermissions(ManagementEntityType level, ManagementEntityType type);
    List<PermissionResponse> getPermissions(ManagementEntityType type);

}
