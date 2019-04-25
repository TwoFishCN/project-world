package com.project.world.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

        for (int id = 0; id < 200; id++) {
            sendMessage("hello world. " + id);
        }

    }

    private void sendMessage(String message) {
        kafkaTemplate.send("topic1", "message", message);
    }

    @KafkaListener(topics = "topic1")
    public void listen(ConsumerRecord<String, String> cr) {
        log.info(cr.toString());
    }


}
