package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello! Spring Boot CI/CD Pipeline is working!";
    }

    @GetMapping("/status")
    public String status() {
        return "Application is running successfully.";
    }
}