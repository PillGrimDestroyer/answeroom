package com.example.answeroom.model.response;

import lombok.Data;

@Data
public class AuthorizeResponse {
    private String email;
    private String company;
    private String subdivision;

}
