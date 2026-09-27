package com.example.notification_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification_service.entity.DeliveryLog;
import com.example.notification_service.repository.DeliveryLogRepository;

@RestController 
@RequestMapping ("/logs")
public class DeliveryController {
    @Autowired 
    private DeliveryLogRepository deliveryLogRepository;

    @GetMapping 
    public List<DeliveryLog> getAllLogs(){
        return deliveryLogRepository.findAll();
    }
}
