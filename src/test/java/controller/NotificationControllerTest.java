package com.example.notification_service.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.notification_service.entity.Notification;
import com.example.notification_service.service.NotificationService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class NotificationControllerTest {

    @Mock
    private NotificationService service;

    @InjectMocks
    private NotificationController controller;

    @Test
    void shouldReturnAllNotifications() {

        List<Notification> notifications =
                new ArrayList<>();

        when(service.getAllNotifications())
                .thenReturn(notifications);

        List<Notification> result =
                controller.getAllNotifications();

        assertEquals(
                notifications,
                result);

        verify(service)
                .getAllNotifications();
    }
}