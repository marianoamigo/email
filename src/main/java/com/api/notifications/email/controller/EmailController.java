package com.api.notifications.email.controller;

import com.api.notifications.email.services.EmailService;
import com.api.notifications.email.services.ErrorService;
import dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/home")
    public String home() {
        return "Microservicio de Email operativo 🚀";
    }

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody NotificationDTO notification) throws ErrorService {
        emailService.send(notification);
        return ResponseEntity.status(HttpStatus.CREATED).body(notification);
    }


}
