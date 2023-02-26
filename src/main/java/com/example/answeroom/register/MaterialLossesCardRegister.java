package com.example.answeroom.register;

import com.example.answeroom.model.Page;
import com.example.answeroom.model.response.MaterialLossesCardResponse;
import com.example.answeroom.model.response.MaterialLossesDetailCardResponse;

public interface MaterialLossesCardRegister {
    MaterialLossesCardResponse loadPage(Page page);

    MaterialLossesDetailCardResponse loadDetail(String materialLossesCarId, String userId);
}
