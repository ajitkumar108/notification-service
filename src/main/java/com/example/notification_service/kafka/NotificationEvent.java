package com.example.notification_service.kafka;

import java.io.Serializable;

public class NotificationEvent implements Serializable {

    private String eventId;
    private Long userId;
    private String message;

    public NotificationEvent() {
    }

    public NotificationEvent(
            String eventId,
            Long userId,
            String message) {

        this.eventId = eventId;
        this.userId = userId;
        this.message = message;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}