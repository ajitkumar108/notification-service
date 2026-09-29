package com.example.notification_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(
            topics = "notification-topic",
            groupId = "notification-group")
    public void consume(String message) {

        System.out.println(
                "Message Received : "
                        + message);
    }
}