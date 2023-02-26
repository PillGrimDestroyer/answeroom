package com.example.answeroom.model.dto;

import com.example.answeroom.model.dao.MaterialLosses;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class MaterialLossesDto {

    private String documentName;


    public static MaterialLossesDto of(MaterialLosses materialLosses) {
        var res = new MaterialLossesDto();

        res.documentName(materialLosses.document().name());

        return res;
    }

}
