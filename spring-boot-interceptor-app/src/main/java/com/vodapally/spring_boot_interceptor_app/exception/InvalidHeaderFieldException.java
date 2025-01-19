package com.vodapally.spring_boot_interceptor_app.exception;

public class InvalidHeaderFieldException extends RuntimeException{
    String message;

    public InvalidHeaderFieldException(String message) {
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
