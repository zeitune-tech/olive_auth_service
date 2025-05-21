package sn.zeitune.oliveinsuranceauthservice.dto.responses;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record UserResponse(
        UUID uuid,
        String firstName,
        String lastName,
        String email,
        String role,
        Set<ProfileResponse> profiles,
        Set<RestrictionResponse> restrictions,
        boolean enabled,
        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired
) {}
