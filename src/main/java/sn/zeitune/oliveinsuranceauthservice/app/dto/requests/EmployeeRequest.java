package sn.zeitune.oliveinsuranceauthservice.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record EmployeeRequest(
        @NotBlank(message = "Le prénom ne doit pas être vide")
        String firstName,

        @NotBlank(message = "Le nom ne doit pas être vide")
        String lastName,

        @NotBlank(message = "L'email ne doit pas être vide")
        @Email(message = "L'email doit être valide")
        String email,

        @NotBlank(message = "Le mot de passe ne doit pas être vide")
        String password,

        @NotNull(message = "La liste des identifiants de profils ne doit pas être nulle")
        Set<Long> profileIds,

        @NotNull(message = "L'entité de gestion ne doit pas être nulle")
        UUID managementEntity
) {}
