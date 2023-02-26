package com.example.answeroom.model.response;

import com.example.answeroom.model.dao.MaterialLossesCard;
import com.example.answeroom.model.dto.MaterialLossesDetailCardDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class MaterialLossesDetailCardResponse {

    private MaterialLossesDetailCardDto materialLossesDetailCardDto;
    private boolean                     openOnCrossDepartmentalQuery;


    public static MaterialLossesDetailCardResponse of(MaterialLossesCard materialLossesCard,
                                                      boolean openOnCrossDepartmentalQuery) {
        var res = new MaterialLossesDetailCardResponse();

        res.materialLossesDetailCardDto(MaterialLossesDetailCardDto.of(materialLossesCard));
        res.openOnCrossDepartmentalQuery(openOnCrossDepartmentalQuery);

        return res;
    }

}
