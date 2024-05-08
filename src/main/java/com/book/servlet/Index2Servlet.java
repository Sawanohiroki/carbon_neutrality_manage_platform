package com.book.servlet;

import com.book.entity.Policy;
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


@WebServlet("/index2")
public class Index2Servlet extends HttpServlet {

    PolicyService service;
    @Override
    public void init() throws ServletException {
        System.out.println("Index2Servlet init");
        service = new PolicyServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jinqule");
        Context context = new Context();
        context.setVariable("policy_list", service.getPolicyList());
        ThymeleafUtil.process("index2.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jinqule2");
        Context context = new Context();
        context.setVariable("policy_list", service.getPolicyList());
        ThymeleafUtil.process("index2.html", context, resp.getWriter());
    }
}
