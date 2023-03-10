package com.example.answeroom.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@Accessors(fluent = true)
public class RegistrationRequest {
    @NotEmpty(message = "'email' is required")
    private String email;

    @NotEmpty(message = "'password' is required")
    private String password;

    @NotEmpty(message = "'subdivisionId' is required")
    private String subdivisionId;

    @NotEmpty(message = "'firstName' is required")
    private String firstName;

    @NotEmpty(message = "'lastName' is required")
    private String lastName;
}
