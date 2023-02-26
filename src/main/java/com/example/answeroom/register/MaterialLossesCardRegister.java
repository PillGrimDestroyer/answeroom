package com.example.answeroom.register;

import com.example.answeroom.model.Page;
import com.example.answeroom.model.response.MaterialLossesCardResponse;

public interface MaterialLossesCardRegister {
    MaterialLossesCardResponse loadPage(Page page);
}
