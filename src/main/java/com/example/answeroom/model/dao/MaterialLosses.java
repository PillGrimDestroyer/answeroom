package com.example.answeroom.model.dao;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(fluent = true)
public class MaterialLosses {

    private String id;
    private Document document;
    private Date expiredAt;
    private Date registeredAt;

}
