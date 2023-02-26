package com.example.answeroom.model.response;

import com.example.answeroom.model.dto.MaterialLossesDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public class MaterialLossesResponse {

    private List<MaterialLossesDto> materialLosses;
    private boolean hasNext;


    public static MaterialLossesResponse of(List<MaterialLossesDto> materialLosses, boolean hasNext) {
        var res = new MaterialLossesResponse();

        res.materialLosses(materialLosses);
        res.hasNext(hasNext);

        return res;
    }

}
