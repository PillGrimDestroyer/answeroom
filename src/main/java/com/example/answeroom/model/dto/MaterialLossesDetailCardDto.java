package com.example.answeroom.model.dto;

import com.example.answeroom.model.dao.Document;
import com.example.answeroom.model.dao.MaterialLossesCard;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(fluent = true)
public class MaterialLossesDetailCardDto {

    private String   materialLossesCarId;
    private Document document;
    private Date     expiredAt;


    public static MaterialLossesDetailCardDto of(MaterialLossesCard materialLossesCard) {
        var res = new MaterialLossesDetailCardDto();

        res.materialLossesCarId(materialLossesCard.id());
        res.document(materialLossesCard.document());
        res.expiredAt(materialLossesCard.expiredAt());

        return res;
    }

}
