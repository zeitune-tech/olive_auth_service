package sn.zeitune.oliveinsuranceauthservice.dto.responses;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record EmployeeResponse(
        UUID uuid,
        String firstName,
        String lastName,
        String email,
        Set<ProfileResponse> profiles,
        UUID managementEntity
) {}
