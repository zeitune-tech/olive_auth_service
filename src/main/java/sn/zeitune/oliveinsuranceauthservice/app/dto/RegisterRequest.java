package sn.zeitune.oliveinsuranceauthservice.app.dto;


public record RegisterRequest(
    String firstname,
    String lastname,
    String email,
    String password
) {}
