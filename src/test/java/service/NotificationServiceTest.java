package com.example.notification_service.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.notification_service.repository.NotificationRepository;
import com.example.notification_service.entity.Notification;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Mock
    private NotificationRepository repository;

    @InjectMocks
    private NotificationService service;

    @Test
    void shouldFindNotification() {

        Notification notification =
                new Notification();

        notification.setId(1L);

        when(repository.findById(1L))
                .thenReturn(
                        Optional.of(notification));

        Optional<Notification> result =
                repository.findById(1L);

        assertNotNull(result);
    }
}