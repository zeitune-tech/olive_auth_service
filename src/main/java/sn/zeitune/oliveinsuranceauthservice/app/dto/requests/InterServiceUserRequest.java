package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sn.zeitune.oliveinsuranceauthservice.app.enums.ManagementEntityType;

import java.util.UUID;

public record InterServiceUserRequest(
        @Email(message = "Invalid email format")
        @NotNull(message = "Email cannot be null")
        @NotBlank(message = "Email cannot be blank")
        String email,
        @NotNull(message = "name cannot be null")
        @NotBlank(message = "name cannot be blank")
        String name,
        @NotNull(message = "Management entity cannot be null")
        UUID managementEntity,
        @NotNull(message = "Management entity type cannot be null")
        ManagementEntityType type,
        @NotNull(message = "Access level cannot be null")
        ManagementEntityType accessLevel
) {
}
