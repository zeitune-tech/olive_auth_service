package sn.zeitune.oliveinsuranceauthservice.app.dto.responses;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record AdminResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        Set<ProfileResponse> profiles
) {}
