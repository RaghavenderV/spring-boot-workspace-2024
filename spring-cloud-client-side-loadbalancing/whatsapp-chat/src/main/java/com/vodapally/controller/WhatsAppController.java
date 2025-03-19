package com.vodapally.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/greeting")
    public String greeting(){
        return "Hello from WhatsApp ( port: "+port+" )";
    }
}
