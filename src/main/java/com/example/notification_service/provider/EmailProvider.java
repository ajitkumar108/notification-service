package com.example.notification_service.provider;

import org.springframework.stereotype.Component;

@Component 
public class EmailProvider implements NotificationProvider{
    @Override
public boolean send(String message) {

    double random = Math.random();

    if(random < 0.5) {

        System.out.println("EMAIL FAILED");

        return false;
    }

    System.out.println(
        "EMAIL SENT : " + message);

    return true;
}
    
}
