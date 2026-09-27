package com.example.notification_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notification_service.dto.DashboardResponse;
import com.example.notification_service.entity.NotificationStatus;
import com.example.notification_service.repository.DeliveryLogRepository;
import com.example.notification_service.repository.NotificationRepository;

@Service
public class DashboardService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private DeliveryLogRepository deliveryLogRepository;

    public DashboardResponse getDashboard() {

        DashboardResponse response =
                new DashboardResponse();

        response.setTotalNotification(
                notificationRepository.count());

        response.setSent(
                notificationRepository.countByStatus(
                        NotificationStatus.SENT));

        response.setFailed(
                notificationRepository.countByStatus(
                        NotificationStatus.FAILED));

        response.setDeliveryLogs(
                deliveryLogRepository.count());

        return response;
    }
}