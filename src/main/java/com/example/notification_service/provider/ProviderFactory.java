package com.example.notification_service.provider;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.notification_service.entity.Channel;


@Component 
public class ProviderFactory {
    @Autowired 
    private EmailProvider emailProvider;

    @Autowired 
    private PushProvider pushProvider;

    @Autowired 
    private  SmsProvider smsProvider;

    public NotificationProvider getProvider(Channel channel){
        return switch(channel){
            case EMAIL  -> emailProvider;
            case SMS -> smsProvider;
            case PUSH -> pushProvider;
        };
    }
}
