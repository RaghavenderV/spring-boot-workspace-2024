package com.vodapally.controller;

import com.vodapally.client.ProductClient;
import com.vodapally.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderFeignController {
    @Autowired
    private ProductClient productClient;

    @GetMapping("/feign/orders/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productClient.getProductById(id);
    }

    @GetMapping("/feign/orders")
    public List<Product> getProducts(){
        return productClient.getProducts();
    }

}
