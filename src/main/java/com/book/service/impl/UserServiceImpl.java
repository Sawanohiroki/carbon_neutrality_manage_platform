package com.book.service.impl;

import com.book.dao.EnterpriseMapper;
import com.book.dao.GovernmentMapper;
import com.book.dao.UserMapper;
import com.book.entity.Enterprise;
import com.book.entity.Government;
import com.book.entity.User;
import com.book.service.UserService;
import com.book.utils.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public boolean enterprise(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSession()){
            EnterpriseMapper mapper = sqlSession.getMapper(EnterpriseMapper.class);
            Enterprise user = mapper.getEnterprise(username, password);
            if(user == null) return false;
            session.setAttribute("user", user);
            return true;
        }
    }

    @Override
    public boolean government(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSession()){
            GovernmentMapper mapper = sqlSession.getMapper(GovernmentMapper.class);
            Government government = mapper.getGovernment(username, password);
            if(government == null) return false;
            session.setAttribute("government", government);
            return true;
        }
    }
}
