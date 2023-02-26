package com.example.answeroom.model.response;

import com.example.answeroom.model.dto.MaterialLossesCardDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public class MaterialLossesCardResponse {

    private List<MaterialLossesCardDto> materialLossesCards;
    private boolean                     hasNext;


    public static MaterialLossesCardResponse of(List<MaterialLossesCardDto> materialLossesCards, boolean hasNext) {
        var res = new MaterialLossesCardResponse();

        res.materialLossesCards(materialLossesCards);
        res.hasNext(hasNext);

        return res;
    }

}
