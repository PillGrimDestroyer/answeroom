package com.example.answeroom.register;

import com.example.answeroom.model.request.AuthorizationRequest;
import com.example.answeroom.model.request.RegistrationRequest;
import com.example.answeroom.model.response.AuthorizeResponse;

public interface AuthorizeRegister {
    AuthorizeResponse authorize(AuthorizationRequest request);

    AuthorizeResponse register(RegistrationRequest request);
}
