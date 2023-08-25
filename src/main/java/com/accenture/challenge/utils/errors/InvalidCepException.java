package com.accenture.challenge.utils.errors;

public class InvalidCepException extends RuntimeException{
    public InvalidCepException(){
        super("Invalid Cep");
    }
    public InvalidCepException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidCepException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
