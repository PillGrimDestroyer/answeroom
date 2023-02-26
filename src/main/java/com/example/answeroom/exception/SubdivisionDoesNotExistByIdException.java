package com.example.answeroom.exception;

public class SubdivisionDoesNotExistByIdException extends RestError {

    public SubdivisionDoesNotExistByIdException() {
        super(403, "Подразделение с таким id не существует");
    }
}
