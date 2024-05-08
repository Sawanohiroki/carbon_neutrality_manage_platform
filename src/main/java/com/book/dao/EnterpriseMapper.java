package com.book.dao;

import com.book.entity.Enterprise;
import com.book.entity.Government;
import com.book.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface EnterpriseMapper {
    @Select("select * from enterprise where username = #{username} and password = #{password}")
    Enterprise getEnterprise(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * from enterprise where username = #{username}")
    Enterprise getEnterpriseByUsername(String username);

    @Select("SELECT * from enterprise")
    <List>Enterprise getAllEnterprise();

    @Insert("INSERT into enterprise (username, password) value (#{username}, #{password});")
    void insertEnterprise(@Param("username") String username, @Param("password") String password);

    @Update("UPDATE enterprise SET scope1 = #{scope1}, scope2 = #{scope2}, scope3 = #{scope3} where username = #{username})")
    void updateEnterprise(@Param("username") String username, @Param("scope1") String scope1, @Param("scope2") String scope2, @Param("scope3") String scope3);

    @Delete("DELETE from enterprise where username = #{username}")
    void deleteEnterprise(String username);
}
