package com.book.filter;

import com.book.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class MainFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = req.getRequestURL().toString();
        if(!url.contains("/static/") && !url.endsWith("login") && !url.endsWith("register") && !url.endsWith("indexgovernment") && !url.endsWith("index")){
            HttpSession session = req.getSession();
            Object user  = session.getAttribute("user");
         //   System.out.println("in Filter");
            if(user == null) {
              //  System.out.println("bu cheng gong");
                res.sendRedirect("login");
                return;
            }
        }
        chain.doFilter(req, res);
    }
}
