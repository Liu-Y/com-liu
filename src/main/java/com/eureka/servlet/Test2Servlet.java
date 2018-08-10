package com.eureka.servlet;

import org.springframework.stereotype.Component;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/8/2.
 */
@Component
public class Test2Servlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("----------Test2Servlet service------------");
    }
}
