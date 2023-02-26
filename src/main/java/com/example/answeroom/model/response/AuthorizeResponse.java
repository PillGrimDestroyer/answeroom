package com.example.answeroom.model.response;

import com.example.answeroom.model.dao.User;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class AuthorizeResponse {
    private String email;
    private String company;
    private String subdivision;


    public static AuthorizeResponse of(User user) {
        var res = new AuthorizeResponse();

        res.email = user.email();
        res.subdivision = user.subdivision().name();
        res.company = user.subdivision().company().name();

        return res;
    }

}
