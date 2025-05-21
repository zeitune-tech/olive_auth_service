package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import sn.zeitune.oliveinsuranceauthservice.app.enums.RestrictionType;

import java.util.UUID;

@Builder
public record RestrictionRequest(
        @NotNull(message = "Le type de restriction ne doit pas être nul")
        RestrictionType restrictionType,

        @NotNull(message = "L'identifiant de l'employé ne doit pas être nul")
        Long employeeId,

        @NotNull(message = "L'entité de gestion ne doit pas être nulle")
        UUID managementEntity
) {}
