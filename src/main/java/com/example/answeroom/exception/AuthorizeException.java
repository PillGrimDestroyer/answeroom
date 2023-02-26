package com.example.answeroom.exception;

public class AuthorizeException extends RestError {

    public AuthorizeException() {
        super(401, "Не верен пользователь и/или пароль");
    }
}
