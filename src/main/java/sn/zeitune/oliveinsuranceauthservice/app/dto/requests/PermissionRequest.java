package sn.zeitune.oliveinsuranceauthservice.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.enums.ManagementEntityType;

@Builder
public record PermissionRequest(
        @NotBlank(message = "Le nom ne doit pas être vide")
        String name,

        String description,

        @NotNull(message = "Le type ne doit pas être nul")
        ManagementEntityType type
) {}
