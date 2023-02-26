package com.example.answeroom.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class Page {

    private int limit;
    private int offset;

}
