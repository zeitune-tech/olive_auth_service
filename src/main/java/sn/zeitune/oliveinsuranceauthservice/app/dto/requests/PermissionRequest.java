package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;
import sn.zeitune.oliveinsuranceauthservice.app.enums.Module;

import java.util.UUID;

@Builder
public record PermissionRequest(
        @NotBlank(message = "Le nom ne doit pas être vide")
        String name,

        String description,

        @NotNull(message = "Le type ne doit pas être nul")
        ManagementEntityType level,

        @NotNull(message = "Le type d'entité de gestion ne doit pas être nul")
        ManagementEntityType type,

        @NotNull(message = "Module not null")
        Module module
) {}
