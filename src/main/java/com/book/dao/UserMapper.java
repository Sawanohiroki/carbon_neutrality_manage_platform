package com.book.dao;

import com.book.entity.Government;
import com.book.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    User getUser(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);

    @Select("select * from admin where username = #{username} and password = #{password}")
    Government getGovernment(@Param("username") String username, @Param("password") String password);

    @Insert("INSERT into user (username, password) value (#{username}, #{password});")
    void insertUser(@Param("username") String username, @Param("password") String password);
}
