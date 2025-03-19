package com.vodapally.controller;

import com.vodapally.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/rest/orders/{id}")
    public String getProductById(@PathVariable Long id){ // call product service
        String url = "http://product-service/products/"+id;
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/rest/orders")
    public List<Product> getProducts(){ // call product service
        String url = "http://product-service/products";

        ResponseEntity<List<Product>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        List<Product> products = response.getBody();

        return products;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
