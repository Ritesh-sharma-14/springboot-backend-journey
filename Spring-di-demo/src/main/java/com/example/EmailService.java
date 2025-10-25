package com.example;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {
    public void sendMessage(String msg) {
        System.out.println("Email Sent: " + msg);
    }
}
