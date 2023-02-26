package com.example.answeroom.model.dao;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(fluent = true)
public class User {

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Subdivision subdivision;
    private Date registeredAt;

}
