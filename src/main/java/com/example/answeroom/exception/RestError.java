package com.example.answeroom.exception;

public class RestError extends RuntimeException {

    public final int statusCode;
    public final String error_type;

    public RestError(int statusCode, String message) {
        super(message);
        this.error_type = this.getClass().getSimpleName();
        this.statusCode = statusCode;
    }

    public RestError(int statusCode, String message, Throwable cause) {
        super(message, cause);
        this.error_type = this.getClass().getSimpleName();
        this.statusCode = statusCode;
    }

    public RestError(String message) {
        this(500, message);
    }

}
