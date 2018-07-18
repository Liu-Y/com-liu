package com.eureka.init;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.util.Optional;

/**
 * Created by Administrator on 2018/7/16.
 */
//@Component
public class KafkaService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @KafkaListener(topics = "WordsWithCountsTopic")
    public void testTopic(ConsumerRecord<?, ?> record){
        try{
            logger.info("WordsWithCountsTopic 接受消息");
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            if (kafkaMessage.isPresent()) {
                Object message = kafkaMessage.get();
                System.out.println("--------------message------------"+message);
//                if (message!=null) {
//                    String msg = new JsonSlurper().parseText(message);
//
//                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
