package com.api.exceptions;

public class UniqueConstraintViolation extends RuntimeException {
    private String origin;

    public UniqueConstraintViolation(String message, Class origin) {
        super(message);
        this.origin = origin.getSimpleName();
    }

    public String getOrigin() {
        return origin;
    }
}
