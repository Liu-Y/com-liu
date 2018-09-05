package com.eureka;

import com.eureka.listener.ApplicationListenerEnvironmentPrepared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/6/14.
 */


@SpringBootApplication
@EnableEurekaServer
@ServletComponentScan
public class Application {

    @Autowired
    private RestTemplateBuilder builder;


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

}
