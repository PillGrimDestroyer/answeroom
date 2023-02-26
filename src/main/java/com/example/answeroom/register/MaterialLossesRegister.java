package com.example.answeroom.register;

import com.example.answeroom.model.Page;
import com.example.answeroom.model.response.MaterialLossesResponse;

public interface MaterialLossesRegister {
    MaterialLossesResponse loadPage(Page page);
}
