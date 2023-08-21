package com.accenture.challenge.utils.errorHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistsExceptionHandler {

    private static final String ERROR_MESSAGE = "Error duplicate document";


}