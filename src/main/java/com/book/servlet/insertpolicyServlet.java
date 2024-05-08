package com.book.servlet;

import com.book.service.PolicyService;
import com.book.service.impl.PolicyServiceImpl;
import com.book.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.Date;

@WebServlet("/add-book")
public class insertpolicyServlet extends HttpServlet {

    PolicyService service;
    @Override
    public void init() throws ServletException {
        service = new PolicyServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThymeleafUtil.process("add-book.html", new Context(), resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String scope1 = req.getParameter("scope1");
        String scope2 = req.getParameter("scope2");
        String scope3 = req.getParameter("scope3");
        String desc = req.getParameter("description");
        Date date = new Date();
        service.insertPolicy(name, scope1, scope2, scope3, desc, date);
        resp.sendRedirect("books");
    }
}
