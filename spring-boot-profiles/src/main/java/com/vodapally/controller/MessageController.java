package com.vodapally.controller;

import com.vodapally.config.AppConfig;
import com.vodapally.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private AppConfig appConfig;

    @GetMapping("/myBean")
    public String myBean(){
        return appConfig.devBean(); // if dev profile is active returns, else exception.

    }

    @GetMapping("/message")
    public String getMessage() {
        return messageService.getMessage();
    }
}
