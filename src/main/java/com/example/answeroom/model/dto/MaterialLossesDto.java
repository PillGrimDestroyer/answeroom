package com.example.answeroom.model.dto;

import com.example.answeroom.model.dao.MaterialLosses;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(fluent = true)
public class MaterialLossesDto {

    private String documentName;
    private Date expiredAt;


    public static MaterialLossesDto of(MaterialLosses materialLosses) {
        var res = new MaterialLossesDto();

        res.documentName(materialLosses.document().name());
        res.expiredAt(materialLosses.expiredAt());

        return res;
    }

}
