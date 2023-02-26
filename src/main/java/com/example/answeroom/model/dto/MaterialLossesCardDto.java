package com.example.answeroom.model.dto;

import com.example.answeroom.model.dao.MaterialLossesCard;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(fluent = true)
public class MaterialLossesCardDto {

    private String documentName;
    private Date expiredAt;


    public static MaterialLossesCardDto of(MaterialLossesCard materialLossesCard) {
        var res = new MaterialLossesCardDto();

        res.documentName(materialLossesCard.document().name());
        res.expiredAt(materialLossesCard.expiredAt());

        return res;
    }

}
