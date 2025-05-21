package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Set;

@Builder
public record UserRequest(
        @NotBlank(message = "Le prénom ne doit pas être vide")
        String firstname,

        @NotBlank(message = "Le nom ne doit pas être vide")
        String lastname,

        @NotBlank(message = "L'email ne doit pas être vide")
        @Email(message = "L'email doit être valide")
        String email,

        @NotBlank(message = "Le mot de passe ne doit pas être vide")
        String password,

        @NotNull(message = "Le rôle ne doit pas être nul")
        String role,

        @NotNull(message = "La liste des identifiants de profils ne doit pas être nulle")
        Set<Long> profileIds
) {}
