package com.example.answeroom.impl;

import com.example.answeroom.dao.MaterialLossesCardDao;
import com.example.answeroom.dao.UserDao;
import com.example.answeroom.exception.UserDoesNotExistException;
import com.example.answeroom.model.Page;
import com.example.answeroom.model.dto.MaterialLossesCardDto;
import com.example.answeroom.model.response.MaterialLossesCardResponse;
import com.example.answeroom.register.MaterialLossesCardRegister;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MaterialLossesCardRegisterImpl implements MaterialLossesCardRegister {

    // region Autowired

    private final UserDao               userDao;
    private final MaterialLossesCardDao materialLossesCardDao;

    // endregion

    @Override
    public MaterialLossesCardResponse loadPage(Page page) {
        var materialLossesCards = materialLossesCardDao.loadPage(page).stream()
                .map(MaterialLossesCardDto::of)
                .collect(Collectors.toList());

        var hasNext = materialLossesCards.size() == page.limit();

        return MaterialLossesCardResponse.of(materialLossesCards, hasNext);
    }

    @Override
    public void loadDetail(String materialLossesCarId, String userId) {
        var user = userDao.findById(userId);

        if (user == null) {
            throw new UserDoesNotExistException();
        }

        throw new NotImplementedException();
    }

}
