package com.hocklo.springbootkafka.kafka;

import com.hocklo.springbootkafka.storage.MessageStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    MessageStorage storage;

    @KafkaListener(topics="pocTopic")
    public void processMessage(String content) throws Exception {

        LOGGER.info("Received content = '{}'", content);
        storage.put(content);
    }
}
