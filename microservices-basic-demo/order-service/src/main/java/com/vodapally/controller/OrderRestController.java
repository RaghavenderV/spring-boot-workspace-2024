package com.vodapally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderRestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/rest/orders/{id}")
    public String callProductService(@PathVariable Long id){

        String url = "http://product-service/products/"+id;
        return restTemplate.getForObject(url, String.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
