package com.eureka.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/12.
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/test")
    public String test(String code) {
        //获取code然后
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
            map.add("client_id", "dfd6e6c0-4856-4525-8fed-68e450828665");
            map.add("client_secret", "62f16478-7b6c-4194-9a19-cc804c85fe27");
            map.add("grant_type", "authorization_code");
            map.add("code", code);
            map.add("redirect_uri", "http://localhost:8051");
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
            ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:8060/oauth2/access_token", request , String.class );
            System.out.println(response.getBody());
            return code;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "aa";
    }

    @RequestMapping(value="/send")
    public String send(String name) {

        kafkaTemplate.send("TextLinesTopic",name);
        return "succeed";
    }

    @RequestMapping(value="/authorize")
    public void auth(HttpServletRequest req, HttpServletResponse resp){
        int random = (int)(Math.random()*10000);
        StringBuffer stringBuffer = new StringBuffer("http://localhost:8060/oauth2/authorize?");
        stringBuffer.append("client_id=dfd6e6c0-4856-4525-8fed-68e450828665")
                .append("&response_type=code")
                .append("&redirect_uri=http://localhost:8051/test")
                .append("&scope=scope_login")
                .append("&state=").append(random);
        try {
            resp.sendRedirect(stringBuffer.toString());
        }catch (IOException e){
            logger.error("重定向错误",e);
        }
    }


}
