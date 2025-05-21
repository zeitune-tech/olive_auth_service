package sn.zeitune.oliveinsuranceauthservice.app.dto;


public record AuthenticationResponse(
    String accessToken,
    String refreshToken
) {}
