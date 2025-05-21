package sn.zeitune.oliveinsuranceauthservice.app.dto;

public record AuthenticationRequest(
    String email,
    String password
) {}
