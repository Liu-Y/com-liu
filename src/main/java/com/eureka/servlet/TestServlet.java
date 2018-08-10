package com.eureka.servlet;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by Administrator on 2018/8/2.
 */
public class TestServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("----------TestServlet init------------");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("----------TestServlet service------------");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("----------TestServlet destroy------------");
    }
}
