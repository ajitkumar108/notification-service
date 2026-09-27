package com.example.notification_service.provider;

import org.springframework.stereotype.Component;

@Component 
public class SmsProvider implements NotificationProvider {
    @Override
    public boolean send(String message) {
        System.out.println(
            "SMS SENT : " + message);
        return true;
    }
    
}
