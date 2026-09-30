package com.example.notification_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class UserPreference implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    @Enumerated(EnumType.STRING)
    private Channel preferredChannel;

    public Channel getPreferredChannel() {
        return preferredChannel;
    }

    public void setPreferredChannel(Channel preferredChannel) {
        this.preferredChannel = preferredChannel;
    }
}
