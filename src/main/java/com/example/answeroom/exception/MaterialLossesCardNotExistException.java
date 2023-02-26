package com.example.answeroom.exception;

public class MaterialLossesCardNotExistException extends RestError {

    public MaterialLossesCardNotExistException() {
        super(403, "Карточка материальных убытков не найдена в системе");
    }
}
