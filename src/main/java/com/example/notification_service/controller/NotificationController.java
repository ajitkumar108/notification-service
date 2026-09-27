package com.example.notification_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification_service.dto.NotificationRequest;
import com.example.notification_service.entity.Notification;
import com.example.notification_service.service.NotificationService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/notifications")
public class NotificationController {
    @Autowired 
    private NotificationService service;

    @PostMapping 
    public Notification send(@Valid   @RequestBody NotificationRequest request){
        return service.send(request);
    }

    @GetMapping 
    public List<Notification>getAllNotifications(){
        return service.getAllNotifications();
    }
    @DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
    service.delete(id);
}
}
