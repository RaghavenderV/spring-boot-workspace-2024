package com.vodapally.spring_boot_interceptor_app.exception;

public class InvalidFieldException extends RuntimeException{
    String message;

    public InvalidFieldException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
