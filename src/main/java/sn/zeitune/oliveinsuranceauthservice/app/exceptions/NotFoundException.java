package sn.zeitune.oliveinsuranceauthservice.app.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
