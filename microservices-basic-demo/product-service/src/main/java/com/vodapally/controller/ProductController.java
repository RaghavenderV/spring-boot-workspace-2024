package com.vodapally.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable Long id) {
        return "Product " + id + " details";
    }
}
