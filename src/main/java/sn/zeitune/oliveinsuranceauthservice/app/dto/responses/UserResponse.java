package sn.zeitune.oliveinsuranceauthservice.app.dto.responses;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record UserResponse(
        UUID id,
        String firstname,
        String lastname,
        String email,
        String role,
        Set<ProfileResponse> profiles,
        Set<RestrictionResponse> restrictions,
        boolean enabled,
        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired
) {}
