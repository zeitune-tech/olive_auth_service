package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeUpdate (
        @NotNull(message = "Employee firstname cannot be null")
        @NotBlank(message = "Employee firstname cannot be blank")
        String firstname,
        @NotNull(message = "Employee lastname cannot be null")
        @NotBlank(message = "Employee lastname cannot be blank")
        String lastname,

        @NotNull(message = "Employee phone number cannot be null")
        @NotBlank(message = "Employee phone number cannot be blank")
        String phoneNumber,

        @NotNull(message = "Employee email cannot be null")
        @NotBlank(message = "Employee email cannot be blank")
        @Email(message = "Email should be valid")
        String email
){
}
