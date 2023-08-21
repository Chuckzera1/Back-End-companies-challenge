package com.accenture.challenge.utils.errors;


public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(){
        super("Duplicate Key");
    }
    public AlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }

    public AlreadyExistsException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
