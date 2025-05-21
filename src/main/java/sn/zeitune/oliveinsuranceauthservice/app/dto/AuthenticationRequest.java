package sn.zeitune.oliveinsuranceauthservice.dto;

public record AuthenticationRequest(
    String email,
    String password
) {}
