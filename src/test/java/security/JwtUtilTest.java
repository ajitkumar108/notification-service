package com.example.notification_service.security;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class JwtUtilTest {

    @Test
    void shouldGenerateToken() {

        JwtUtil jwtUtil =
                new JwtUtil();

        String token =
                "sample-token";

        assertNotNull(token);
    }
}