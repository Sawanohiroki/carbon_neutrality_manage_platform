package com.book.servlet.auth;

import com.book.dao.EnterpriseMapper;
import com.book.entity.Enterprise;
import com.book.entity.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import jakarta.servlet.ServletContext;
import com.book.utils.MybatisUtil;
import com.book.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserService service;
    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        if(req.getSession().getAttribute("register-failure") != null){
            context.setVariable("register-failure", true);
            req.getSession().removeAttribute("register-failure");
        }
        ThymeleafUtil.process("register.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean flag = false;
        try (SqlSession sqlSession = MybatisUtil.getSession()){
            EnterpriseMapper mapper = sqlSession.getMapper(EnterpriseMapper.class);
            Enterprise enterprise = mapper.getEnterpriseByUsername(username);
            if(enterprise != null) flag = true;
        }
        if(flag){
            req.getSession().setAttribute("register-failure", new Object());
            this.doGet(req, resp);
        }else {
            try (SqlSession sqlSession = MybatisUtil.getSession()){
                EnterpriseMapper mapper = sqlSession.getMapper(EnterpriseMapper.class);
                mapper.insertEnterprise(username, password);
            }
            resp.sendRedirect("login");
        }
    }
}
