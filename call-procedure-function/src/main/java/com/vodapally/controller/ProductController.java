package com.vodapally.controller;

import com.vodapally.entity.Product;
import com.vodapally.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PutMapping("/update/{productId}/{quantity}")
    public Product updateInventoryStock(@PathVariable Integer productId, @PathVariable Integer quantity){
        return productService.updateStockQuantity(productId, quantity);
    }

    @GetMapping("/total-price/{productId}")
    public Double getTotalPrice(@PathVariable Integer productId){
        return productService.calculateProductPrice(productId);
    }
}
