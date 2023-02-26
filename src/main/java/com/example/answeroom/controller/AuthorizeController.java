package com.example.answeroom.controller;

import com.example.answeroom.model.request.AuthorizationRequest;
import com.example.answeroom.model.request.RegistrationRequest;
import com.example.answeroom.model.response.AuthorizeResponse;
import com.example.answeroom.register.AuthorizeRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/authorize")
@RequiredArgsConstructor
public class AuthorizeController {

    //region Autowired

    private final AuthorizeRegister authorizeRegister;

    //endregion

    @PostMapping("/login")
    public AuthorizeResponse authenticate(@Valid @RequestBody AuthorizationRequest request) {
        return authorizeRegister.authorize(request);
    }

    @PostMapping("/register")
    public AuthorizeResponse register(@Valid @RequestBody RegistrationRequest request) {
        return authorizeRegister.register(request);
    }

}
