package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContributorTypeRequest(
        @NotNull(message = "Label is required")
        @NotBlank(message = "Label cannot be blank")
        String label
) {
}
