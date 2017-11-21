package com.hocklo.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${com.hocklo.kafka.sender.topic:pocTopic}")
    private String topic;

    public void send(String message) {
        kafkaTemplate.send(topic, message);
        LOGGER.info("Sended message({}) to topic({})", message, topic);
    }

    public String getTopic(){
        return this.topic;
    }
}
