package com.vodapally.controller;

import com.vodapally.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {
    @Autowired
    private ProductClient productClient;

    @GetMapping("/feign/orders/{id}")
    public String getProduct(@PathVariable Long id) {
        return productClient.getProduct(id);
    }

}
