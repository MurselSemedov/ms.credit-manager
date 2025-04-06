package com.mursalsamad.exception;

public class NotFoundException extends RuntimeException {

    private String message;

    public NotFoundException(String message,Object... arguments) {
        super(message.formatted(arguments));
    }
}
