package com.hocklo.springbootkafka.web;

import com.hocklo.springbootkafka.kafka.KafkaProducer;
import com.hocklo.springbootkafka.storage.MessageStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    MessageStorage messageStorage;
    @GetMapping(value = "/produces")
    public String producer(@RequestParam("message") String message) {
        kafkaProducer.send(message);

        return String.format("Message(%s) sent to the Kafka Topic %s Successfully", message, kafkaProducer.getTopic());
    }

    @GetMapping(value="/consumes")
    public String getAllRecievedMessage(){
        String messages = messageStorage.toString();
        messageStorage.clear();

        return messages;
    }
}
