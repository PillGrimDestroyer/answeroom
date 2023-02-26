package com.example.answeroom.impl;

import com.example.answeroom.model.request.AuthorizationRequest;
import com.example.answeroom.model.response.AuthorizeResponse;
import com.example.answeroom.register.AuthorizeRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorizeRegisterImpl implements AuthorizeRegister {

    // region Autowired


    // endregion

    @Override
    public AuthorizeResponse authorize(AuthorizationRequest request) {
        return null;
    }
}
