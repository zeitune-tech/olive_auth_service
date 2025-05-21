package sn.zeitune.oliveinsuranceauthservice.dto;


public record AuthenticationResponse(
    String accessToken,
    String refreshToken
) {}
