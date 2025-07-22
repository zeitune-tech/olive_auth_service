package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ContributorLevel;

public record ContributorRequest(
        @NotBlank(message = "Le prénom ne doit pas être vide")
        String firstname,

        @NotBlank(message = "Le nom ne doit pas être vide")
        String lastname,

        String email,

        @NotBlank(message = "Niveau de apporteur ne doit pas être vide")
        ContributorLevel level
) {}
