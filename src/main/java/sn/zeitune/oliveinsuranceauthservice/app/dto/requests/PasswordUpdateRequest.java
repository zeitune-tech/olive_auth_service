package sn.zeitune.oliveinsuranceauthservice.app.dto.requests;

public record PasswordUpdateRequest (
        String oldPassword,
        String newPassword,
        String confirmNewPassword
) {
}
