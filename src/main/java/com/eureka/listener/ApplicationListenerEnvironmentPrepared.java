package com.eureka.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by Administrator on 2018/8/6.
 */
@Configuration
public class ApplicationListenerEnvironmentPrepared implements ApplicationListener<ApplicationPreparedEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
//        System.out.println("监听器启动啦");
//    }

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        System.out.println("监听器启动啦");
    }
}
