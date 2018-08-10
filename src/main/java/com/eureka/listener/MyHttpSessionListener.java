package com.eureka.listener;

import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 2018/8/6.
 */
@Configuration
public class MyHttpSessionListener implements HttpSessionListener {

    public static int peopleOnLine = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("myHttpSessionListener.sessionCreated():"+se);
        peopleOnLine++;
        se.getSession().setAttribute("peopleOnLine",peopleOnLine);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("myHttpSessionListener.sessionDestroyed():"+se);
        peopleOnLine--;
        se.getSession().setAttribute("peopleOnLine",peopleOnLine);
    }
}
