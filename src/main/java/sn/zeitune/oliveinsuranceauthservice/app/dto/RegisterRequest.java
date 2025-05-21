package sn.zeitune.oliveinsuranceauthservice.dto;


public record RegisterRequest(
    String firstname,
    String lastname,
    String email,
    String password
) {}
