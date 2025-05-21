package sn.zeitune.oliveinsuranceauthservice.app.mappers;

import sn.zeitune.oliveinsuranceauthservice.app.dto.requests.ProfileRequest;
import sn.zeitune.oliveinsuranceauthservice.app.dto.responses.ProfileResponse;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Profile;

import java.util.stream.Collectors;

public class ProfileMapper {

    public static Profile map(ProfileRequest request, Profile profile) {
        if (request == null) {
            return profile;
        }
        if (profile == null) {
            profile = new Profile();
        }
        profile.setName(request.name());
        profile.setDescription(request.description());
        profile.setLevel(request.level());
        return profile;
    }

    public static ProfileResponse map(Profile profile) {
        if (profile == null) {
            return null;
        }
        return ProfileResponse.builder()
                .id(profile.getUuid())
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
