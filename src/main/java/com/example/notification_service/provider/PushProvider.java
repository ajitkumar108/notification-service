package com.example.notification_service.provider;

import org.springframework.stereotype.Component;

@Component 
public class PushProvider implements NotificationProvider {
    @Override
    public boolean send(String message) {

            System.out.println(
            "PUSH SENT : " + message);

        return true;
    
    }
    
}
