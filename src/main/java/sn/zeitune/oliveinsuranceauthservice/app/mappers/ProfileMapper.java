package sn.zeitune.oliveinsuranceauthservice.mappers;

import sn.zeitune.oliveinsuranceauthservice.dto.requests.ProfileRequest;
import sn.zeitune.oliveinsuranceauthservice.dto.responses.ProfileResponse;
import sn.zeitune.oliveinsuranceauthservice.entities.Profile;

import java.util.Set;
import java.util.stream.Collectors;

public class ProfileMapper {

    public static Profile map(ProfileRequest request) {
        if (request == null) {
            return null;
        }
        Profile profile = new Profile();
        profile.setName(request.name());
        profile.setDescription(request.description());
        profile.setLevel(request.level());
        profile.setManagementEntity(request.managementEntity());
        return profile;
    }

    public static ProfileResponse map(Profile profile) {
        if (profile == null) {
            return null;
        }
        return ProfileResponse.builder()
                .id(profile.getId())
                .uuid(profile.getUuid())
                .name(profile.getName())
                .description(profile.getDescription())
                .level(profile.getLevel())
                .managementEntity(profile.getManagementEntity())
                .permissions(profile.getPermissions() != null ?
                        profile.getPermissionsList().stream().map(PermissionMapper::map).collect(Collectors.toSet())
                        : null)
                .build();
    }
}
