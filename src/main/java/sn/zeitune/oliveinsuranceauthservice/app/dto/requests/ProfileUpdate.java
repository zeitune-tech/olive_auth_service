package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import jakarta.validation.constraints.NotBlank;

public record ProfileUpdate(
        @NotBlank(message = "Le nom ne doit pas être vide")
        String name,
        String description
) {
}
