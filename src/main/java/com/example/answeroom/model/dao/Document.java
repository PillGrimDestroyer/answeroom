package com.example.answeroom.model.dao;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(fluent = true)
public class Document {

    private String id;
    private String name;
    private Date registeredAt;

}
