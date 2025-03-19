package com.vodapally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/consume")
    public Mono<String> consume() {

        List<ServiceInstance> instances = discoveryClient.getInstances("whatsapp-chat");
        if (instances==null || instances.isEmpty()){
            return Mono.just("WhatsApp service not available. Please try after sometime.");
        }
        URI uri = instances.get(0).getUri();
        System.out.println("uri = " + uri);

        return webClientBuilder.build()
                .get()
                .uri(uri+"/whatsapp/greeting")
                .retrieve()
                .bodyToMono(String.class);
    }
}
