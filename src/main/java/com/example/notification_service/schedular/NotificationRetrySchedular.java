package com.example.notification_service.schedular;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.notification_service.entity.Notification;
import com.example.notification_service.entity.NotificationStatus;
import com.example.notification_service.repository.NotificationRepository;

@Component 
public class NotificationRetrySchedular {
    
    @Autowired 
    private NotificationRepository repository;

   @Scheduled(fixedRate = 30000)
public void retryFailedNotifications() {

    List<Notification> failedNotifications =
            repository.findByStatus(
                    NotificationStatus.FAILED);

    System.out.println(
            "FAILED RECORDS FOUND : "
            + failedNotifications.size());

    for (Notification notification : failedNotifications) {

    if (notification.getRetryCount() >= 3) {

        System.out.println(
                "MAX RETRY REACHED : "
                        + notification.getEventId());

        continue;
    }

    notification.setRetryCount(
            notification.getRetryCount() + 1);

    double random = Math.random();

    if (random > 0.5) {

        notification.setStatus(
                NotificationStatus.SENT);

        System.out.println(
                "RETRY SUCCESS : "
                        + notification.getEventId());

    } else {

        System.out.println(
                "RETRY FAILED : "
                        + notification.getEventId());
    }

    repository.save(notification);
}
}
}
