package sn.zeitune.oliveinsuranceauthservice.dto.responses;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record AdminResponse(
        UUID uuid,
        String firstName,
        String lastName,
        String email,
        Set<ProfileResponse> profiles
) {}
