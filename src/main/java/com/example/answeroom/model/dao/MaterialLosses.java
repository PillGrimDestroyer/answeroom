package com.example.answeroom.model.dao;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class MaterialLosses {

    private String id;
    private Document document;

}
