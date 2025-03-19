package com.vodapally.controller;

import com.vodapally.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
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
    public Mono<String> getProductById(@PathVariable Long id) {
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
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        this::handleErrorResponse)
                .bodyToMono(String.class)
                .onErrorResume(error ->{
                    System.err.println("Fallback due to error: "+error.getMessage());
                    return Mono.just("Fallback response");
                })
                .map(productDetails -> "Order with Product: " + productDetails)
                .doOnError(e ->
                        System.err.println("Error occurred: " + e.getMessage())
                        );
    }
    private Mono<? extends Throwable> handleErrorResponse(ClientResponse response) {
        return response.bodyToMono(String.class)
                .flatMap(body -> {
                    System.err.println("Error response body: " + body);
                    return Mono.error(new CustomException("Server responded with error: " + response.statusCode()));
                });
    }

    @GetMapping("/webclient/orders")
    public Mono<List<Product>> getProducts() {
        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");

        if (instances == null || instances.isEmpty()) {
            throw new RuntimeException("product-service instance is not available..");
        }
        URI productServiceUri = instances.get(0).getUri();
        System.out.println("productServiceUri = " + productServiceUri);

        return webClientBuilder.build()
                .get()
                .uri(productServiceUri + "/products")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    static class CustomException extends RuntimeException {
        public CustomException(String message) {
            super(message);
        }
    }
}


