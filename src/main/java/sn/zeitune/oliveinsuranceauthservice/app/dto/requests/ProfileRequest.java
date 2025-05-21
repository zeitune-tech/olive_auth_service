package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;

import java.util.Set;
import java.util.UUID;

@Builder
public record ProfileRequest(
        @NotBlank(message = "Le nom ne doit pas être vide")
        String name,
        String description,

        @NotNull(message = "Le niveau ne doit pas être nul")
        ManagementEntityType level,

        @NotNull(message = "La liste des identifiants de permissions ne doit pas être nulle")
        Set<UUID> permissions
) {}
