package com.book.dao;

import com.book.entity.Enterprise;
import com.book.entity.Government;
import com.book.entity.Policy;
import com.book.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface PolicyMapper {

    @Select("select * from policy")
    List<Policy> getPolicyList();

}
