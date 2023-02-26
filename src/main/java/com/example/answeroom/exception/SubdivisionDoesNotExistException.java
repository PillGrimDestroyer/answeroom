package com.example.answeroom.exception;

public class SubdivisionDoesNotExistException extends RestError {

    public SubdivisionDoesNotExistException() {
        super(403, "Подразделение не найдено в системе");
    }
}
