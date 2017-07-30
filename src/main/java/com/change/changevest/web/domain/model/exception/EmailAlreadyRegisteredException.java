package com.change.changevest.web.domain.model.exception;

public class EmailAlreadyRegisteredException extends RuntimeException {
    public EmailAlreadyRegisteredException() {
        super("That email address has already been registered. Please try logging in.");
    }
}
