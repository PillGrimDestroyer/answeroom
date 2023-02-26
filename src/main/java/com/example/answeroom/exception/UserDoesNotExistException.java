package com.example.answeroom.exception;

public class UserDoesNotExistException extends RestError {

    public UserDoesNotExistException() {
        super(403, "Пользователь не найден в системе");
    }
}
