package com.example.notification_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification_service.dto.LoginRequest;
import com.example.notification_service.dto.LoginResponse;
import com.example.notification_service.security.JwtUtil;

@RestController 
public class AuthController {
    
    @Autowired 
    private JwtUtil jwtUtil;

    @PostMapping("/login")
public LoginResponse login(
        @RequestBody LoginRequest request) {

    String token =
            jwtUtil.generateToken(
                    request.getUsername(),
                    request.getRole());

    return new LoginResponse(token);
}
}
