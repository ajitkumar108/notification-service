package com.example.notification_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notification_service.entity.Notification;
import com.example.notification_service.entity.NotificationStatus;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification>findByStatus(NotificationStatus status);
    Optional<Notification>findByEventId(String eventId);
    long countByStatus(NotificationStatus status);
    
}
