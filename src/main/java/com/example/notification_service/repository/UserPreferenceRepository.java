package com.example.notification_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.notification_service.entity.Channel;

import com.example.notification_service.entity.UserPreference;

public interface UserPreferenceRepository
        extends JpaRepository<UserPreference, Long> {

    Optional<UserPreference> findByUserIdAndPreferredChannel(
            Long userId,
            Channel preferredChannel);
}
