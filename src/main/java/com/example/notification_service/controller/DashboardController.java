package com.example.notification_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification_service.dto.DashboardResponse;
import com.example.notification_service.service.DashboardService;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController 
public class DashboardController {
    @Autowired 
    private DashboardService dashboardService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping ("/dashboard")
    public DashboardResponse getDashborad(){
        return dashboardService.getDashboard();
    }
}
