package com.book.dao;

import com.book.entity.Enterprise;
import com.book.entity.Government;
import org.apache.ibatis.annotations.*;

public interface GovernmentMapper {
    @Select("select * from government where username = #{username} and password = #{password}")
    Government getGovernment(@Param("username") String username, @Param("password") String password);


    @Select("SELECT * from enterprise")
    <List>Enterprise getAllEnterprise();

    @Insert("INSERT into government (username, password) value (#{username}, #{password});")
    void insertGovernment(@Param("username") String username, @Param("password") String password);

    @Update("UPDATE government SET scope1 = #{scope1}, scope2 = #{scope2}, scope3 = #{scope3} where username = #{username})")
    void updateGovernment(@Param("username") String username, @Param("scope1") String scope1, @Param("scope2") String scope2, @Param("scope3") String scope3);

    @Delete("DELETE from government where username = #{username}")
    void deleteGovernment(String username);
}
