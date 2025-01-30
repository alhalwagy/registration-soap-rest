package com.fawry.crud.exception.customExceptions;

public class ConnectionNotFoundException extends RuntimeException {

    public ConnectionNotFoundException() {
    }

    public ConnectionNotFoundException(String message) {
        super(message);
    }

    public ConnectionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
