package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    @Autowired
    private MessageService messageService;  // Dependency Injection

    public void processMessage(String msg) {
        messageService.sendMessage(msg);
    }
}
