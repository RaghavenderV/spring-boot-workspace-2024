package com.vodapally.spring_boot_interceptor_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {

    //handler for InvalidFieldException
    @ExceptionHandler
    public String handleInvalidFieldException(InvalidFieldException exception){
        return exception.getMessage();
    }

    //handler for InvalidHeaderFieldException
    @ExceptionHandler
    public ResponseEntity<String> handleInvalidHeaderFieldException(InvalidHeaderFieldException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.PRECONDITION_FAILED);
    }
}
