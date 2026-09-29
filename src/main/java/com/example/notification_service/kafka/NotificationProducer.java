package com.example.notification_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC =
            "notification-topic";

    public void send(String message) {

        kafkaTemplate.send(
                TOPIC,
                message);

        System.out.println(
                "Message Sent : " + message);
    }
}