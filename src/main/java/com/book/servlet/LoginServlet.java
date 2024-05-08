package com.book.servlet;

import com.book.dao.UserMapper;
import com.book.entity.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.utils.MybatisUtil;
import com.book.utils.ThymeleafUtil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService service;
    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   System.out.println("!!!");
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            String username = null;
            String password = null;
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("username")) username = cookie.getValue();
                if(cookie.getName().equals("password")) password = cookie.getValue();
            }
            if(username != null && password != null){
                if(service.enterprise(username, password, req.getSession())){
                    resp.sendRedirect("index");
                    return;
                }
                if(service.government(username, password, req.getSession())){
                    resp.sendRedirect("index2");
                    return;
                }
            }
        }
        Context context = new Context();
        if(req.getSession().getAttribute("login-failure") != null){
            context.setVariable("failure", true);
            req.getSession().removeAttribute("login-failure");
        }
        if(req.getSession().getAttribute("user") != null) {
            resp.sendRedirect("index");
            return;
        }
        if(req.getSession().getAttribute("government") != null) {
            resp.sendRedirect("index2");
            return;
        }
        ThymeleafUtil.process("login.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   System.out.println("???");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember-me");
        String is_government = req.getParameter("is_government");
    //    System.out.println(req.getParameter("username"));
      //  System.out.println(req.getParameter("remember-me"));
       // System.out.println(req.getParameter("is_government"));
        if (is_government != null) {
            System.out.println("hehe");
            if (service.government(username, password, req.getSession())) {
                if (remember != null) {
                    Cookie cookie_username = new Cookie("username", username);
                    cookie_username.setMaxAge(60 * 60 * 24 * 7);
                    Cookie cookie_password = new Cookie("password", password);
                    cookie_password.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(cookie_username);
                    resp.addCookie(cookie_password);
                }
                System.out.println("xixi");
                resp.sendRedirect("index2");
            } else {

                req.getSession().setAttribute("login-failure", new Object());
                this.doGet(req, resp);
            }
        }
        else {
            if (service.enterprise(username, password, req.getSession())) {
                if (remember != null) {
                    Cookie cookie_username = new Cookie("username", username);
                    cookie_username.setMaxAge(60 * 60 * 24 * 7);
                    Cookie cookie_password = new Cookie("password", password);
                    cookie_password.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(cookie_username);
                    resp.addCookie(cookie_password);
                }
                resp.sendRedirect("index");
            } else {
                req.getSession().setAttribute("login-failure", new Object());
                this.doGet(req, resp);
            }
        }
    }
}
