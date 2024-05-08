package com.book.dao;

import com.book.entity.Enterprise;
import com.book.entity.Government;
import com.book.entity.Policy;
import com.book.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface PolicyMapper {

    @Select("select * from policy")
    List<Policy> getPolicyList();

    @Insert("insert into policy(name, scope1, scope2, scope3, description, launchtime) values(#{name}, #{scope1}, #{scope2}, #{scope3}, #{description}NOW())")
    void insertPolicy(String name, String scope1, String scope2, String scope3, String description, Date date);
}
