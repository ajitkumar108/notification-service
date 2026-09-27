package com.example.notification_service.service;

import com.example.notification_service.entity.Notification;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.notification_service.dto.NotificationRequest;
import com.example.notification_service.entity.NotificationStatus;
import com.example.notification_service.entity.UserPreference;
import com.example.notification_service.exception.NotificationException;
import com.example.notification_service.provider.NotificationProvider;
import com.example.notification_service.provider.ProviderFactory;
import com.example.notification_service.repository.DeliveryLogRepository;
import com.example.notification_service.repository.NotificationRepository;
import com.example.notification_service.entity.Channel;
import com.example.notification_service.entity.DeliveryLog;
@Service 
public class NotificationService {

    @Autowired 
    private UserPreferenceService userPreferenceService;

    @Autowired 
    private ProviderFactory providerFactory;

    @Autowired 
    private NotificationRepository notificationRepository;

    @Autowired 
    private DeliveryLogRepository deliveryLogRepository;

    private static final Logger log = 
                    LoggerFactory.getLogger(NotificationService.class);

    public Notification send(NotificationRequest request){
        log.info("Received notification Request for eventId {} and userId {}", 
            request.getEventId(),request.getUserId()
        );

        if(notificationRepository
        .findByEventId(request.getEventId())
        .isPresent()) {

    throw new NotificationException(
            "Event already processed", HttpStatus.NOT_FOUND);
}

        UserPreference preference = userPreferenceService.
                getByUserId(request.getUserId());

        log.info("User {} preffered channel is {}", 
            request.getUserId(), preference.getPreferredChannel()
        );

        Channel channel = preference.getPreferredChannel();

        NotificationProvider provider = providerFactory.getProvider(channel);

        boolean result = provider.send(request.getMessage());

        if(result){
            log.info("Notification sent successfully for eventId {}",
                request.getEventId()
            );
        }
        else{
            log.error("Notification get failed for eventId{}",
                request.getEventId()
            );
        }

        DeliveryLog deliveryLog = new DeliveryLog();

deliveryLog.setEventId(request.getEventId());

deliveryLog.setAction(
        result
                ? "SUCCESS"
                : "FAILED");

deliveryLog.setDetails(
        request.getMessage());

deliveryLogRepository.save(deliveryLog);

        Notification notification = new Notification();

        notification.setEventId(request.getEventId());

        notification.setUserId(request.getUserId());

        notification.setMessage(request.getMessage());

        notification.setChannel(channel);
        notification.setRetryCount(0);

      
        notification.setStatus(
            result
            ?NotificationStatus.SENT
            :NotificationStatus.FAILED
        );

        log.info("Saving notification with satatus {}",
            notification.getStatus()
        );
        return notificationRepository.save(notification);
    }
        public List<Notification> getAllNotifications() {
    return notificationRepository.findAll();
}
public void delete(Long id) {
    notificationRepository.deleteById(id);
}

}