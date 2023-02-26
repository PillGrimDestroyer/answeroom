package com.example.answeroom.dao;

import com.example.answeroom.model.dao.Company;
import com.example.answeroom.model.dao.Subdivision;
import com.example.answeroom.model.dao.User;
import org.apache.ibatis.annotations.*;

public interface UserDao {

    // region Sub-queries

    @Results({
            @Result(property = "company", column = "company_id", javaType = Company.class, one = @One(select = "companyById"))
    })
    @Select("select * from subdivisions where id = #{id}")
    Subdivision subdivisionById(@Param("id") String id);

    @Select("select * from companies where id = #{id}")
    Company companyById(@Param("id") String id);

    // endregion

    @Results(id = "user", value = {
            @Result(property = "subdivision", column = "subdivision_id", javaType = Subdivision.class, one = @One(select = "subdivisionById"))
    })
    @Select("select * from users where email = #{email} and password = #{password}")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Select("select exists(SELECT 1 FROM users WHERE email = #{email})")
    boolean existByEmail(@Param("email") String email);

    @Insert("insert into users (id, email, password, first_name, last_name, subdivision_id) " +
            "values " +
            "(${id}, #{email}, #{u.password}, #{firstName}, #{lastName}, #{subdivisionId})")
    void registerNewUser(@Param("id") String id,
                         @Param("email") String email,
                         @Param("password") String password,
                         @Param("firstName") String firstName,
                         @Param("lastName") String lastName,
                         @Param("subdivisionId") String subdivisionId);
}
