package com.vodapally.controller;

import com.vodapally.client.UserWebClient;
import com.vodapally.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/webclient")
public class UserWebClientController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/findUsers")
    public List<UserResponse> getUsers() {

        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(UserResponse.class)
                .collectList()
                .block();

    }
}
