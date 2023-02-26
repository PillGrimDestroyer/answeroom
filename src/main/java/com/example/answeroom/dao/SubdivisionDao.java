package com.example.answeroom.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SubdivisionDao {

    @Select("select exists(SELECT 1 FROM subdivisions WHERE id = #{id})")
    boolean existById(@Param("id") String id);

}
