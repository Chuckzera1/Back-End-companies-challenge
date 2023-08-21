package com.accenture.challenge.utils.errors;

public class NoRecordFoundException extends RuntimeException{
    public NoRecordFoundException(){
        super("Record Not Found");
    }
    public NoRecordFoundException(String errorMessage) {
        super(errorMessage);
    }

    public NoRecordFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
