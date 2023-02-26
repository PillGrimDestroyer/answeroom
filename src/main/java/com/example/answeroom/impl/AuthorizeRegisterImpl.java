package com.example.answeroom.impl;

import com.example.answeroom.dao.SubdivisionDao;
import com.example.answeroom.dao.UserDao;
import com.example.answeroom.exception.AuthorizeException;
import com.example.answeroom.exception.SubdivisionDoesNotExistException;
import com.example.answeroom.exception.UserAlreadyExistException;
import com.example.answeroom.model.request.AuthorizationRequest;
import com.example.answeroom.model.request.RegistrationRequest;
import com.example.answeroom.model.response.AuthorizeResponse;
import com.example.answeroom.register.AuthorizeRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.IdGenerator;

@Component
@RequiredArgsConstructor
public class AuthorizeRegisterImpl implements AuthorizeRegister {

    // region Autowired

    private final IdGenerator    idGenerator;
    private final UserDao        userDao;
    private final SubdivisionDao subdivisionDao;

    // endregion

    @Override
    public AuthorizeResponse authorize(AuthorizationRequest request) {
        var user = userDao.findByEmailAndPassword(request.email(), request.password());

        if (user == null) {
            throw new AuthorizeException();
        }

        return AuthorizeResponse.of(user);
    }

    @Override
    public void register(RegistrationRequest request) {
        var isUserWithSameEmailExist = userDao.existByEmail(request.email());

        if (isUserWithSameEmailExist) {
            throw new UserAlreadyExistException();
        }

        var isSubdivisionExist = subdivisionDao.existById(request.subdivisionId());

        if (!isSubdivisionExist) {
            throw new SubdivisionDoesNotExistException();
        }

        userDao.registerNewUser(
                idGenerator.generateId().toString(), request.email(), request.password(),
                request.firstName(), request.lastName(), request.subdivisionId()
        );
    }
}
