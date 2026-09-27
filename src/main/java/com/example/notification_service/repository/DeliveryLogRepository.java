package com.example.notification_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notification_service.entity.DeliveryLog;

public interface DeliveryLogRepository extends JpaRepository<DeliveryLog, Long> {
    
}
