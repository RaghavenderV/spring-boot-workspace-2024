package com.vodapally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@RestController
public class OrderWebClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/webclient/orders/{id}")
    public Mono<String> getProduct(@PathVariable Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");

        if (instances == null || instances.isEmpty()) {
            return Mono.just("Product service not available.");
        }
        URI productServiceUri = instances.get(0).getUri();
        System.out.println("productServiceUri = " + productServiceUri);

        return webClientBuilder.build()
                .get()
                .uri(productServiceUri + "/products/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .map(productDetails -> "Order with Product: " + productDetails);
    }
}
