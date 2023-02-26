package com.example.answeroom.impl;

import com.example.answeroom.dao.MaterialLossesDao;
import com.example.answeroom.model.Page;
import com.example.answeroom.model.dto.MaterialLossesDto;
import com.example.answeroom.model.response.MaterialLossesResponse;
import com.example.answeroom.register.MaterialLossesRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MaterialLossesRegisterImpl implements MaterialLossesRegister {

    // region Autowired

    private final MaterialLossesDao materialLossesDao;

    // endregion

    @Override
    public MaterialLossesResponse loadPage(Page page) {
        var materialLosses = materialLossesDao.loadPage(page).stream()
                .map(MaterialLossesDto::of)
                .collect(Collectors.toList());
        
        var hasNext = materialLosses.size() == page.limit();

        return MaterialLossesResponse.of(materialLosses, hasNext);
    }

}
