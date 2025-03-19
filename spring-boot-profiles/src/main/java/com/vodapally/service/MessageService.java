package com.vodapally.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class MessageService {
    @Value("${app.message}")
    private String message;

}
