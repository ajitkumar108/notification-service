package com.example.notification_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.notification_service.entity.UserPreference;
import com.example.notification_service.exception.NotificationException;
import com.example.notification_service.repository.UserPreferenceRepository;

@Service 
public class UserPreferenceService {
    @Autowired 
    private UserPreferenceRepository repository;

    public UserPreference save(UserPreference preference){
        return repository.save(preference);
    }

    public UserPreference getByUserId(Long userId){
        return repository.findById(userId).
            orElseThrow(()->new NotificationException("user preference not found", HttpStatus.NOT_FOUND));
    }

}
