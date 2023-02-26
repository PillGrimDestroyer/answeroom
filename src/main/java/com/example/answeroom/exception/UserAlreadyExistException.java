package com.example.answeroom.exception;

public class UserAlreadyExistException extends RestError {

    public UserAlreadyExistException() {
        super(403, "Пользователь с таким email уже существует");
    }
}
