package com.example.answeroom.dao;

import com.example.answeroom.model.Page;
import com.example.answeroom.model.dao.Document;
import com.example.answeroom.model.dao.MaterialLossesCard;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MaterialLossesCardDao {

    // region Sub-queries

    @Select("select * from documents where id = #{id}")
    Document documentById(@Param("id") String documentId);

    // endregion

    @Results(id = "material_losses", value = {
            @Result(property = "document", column = "document_id", javaType = Document.class, one = @One(select = "documentById"))
    })
    @Select("select * from material_losses_card order by id limit #{page.limit} offset #{page.offset}")
    List<MaterialLossesCard> loadPage(@Param("page") Page page);

}
