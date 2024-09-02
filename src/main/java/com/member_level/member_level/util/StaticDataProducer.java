package com.member_level.member_level.util;

import com.member_level.member_level.service.impl.MemberboxMessagesServiceImpl;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StaticDataProducer {
    private static final Logger logger = LoggerFactory.getLogger(StaticDataProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.static-data-topic}")
    private String staticDataTopic;


    public StaticDataProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @PostConstruct
    public void sendStaticData(){
        String staticData= "{\"grandTotal\" : 30,\"cardNumber\" : \"999999999\"}";
        logger.info(String.format("Message sent -> %s", staticData));
        kafkaTemplate.send(staticDataTopic,staticData);
    }
}
