package com.vodapally.controller;

import com.vodapally.dto.Product;
import com.vodapally.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public List<Product> saveProduct(@RequestBody @Valid Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/search/{productType}")
    public ResponseEntity<?> getProducts(@PathVariable String productType){
        System.out.println("getProducts method in ProductController class called....");
        List<Product> productList = productService.getProductByType(productType);
        return ResponseEntity.ok(productList);
    }

    @GetMapping(produces = {"application/json","application/xml"})
    public List<Product> listAllProducts(@RequestParam(value = "productType", required = false) String productType){
        return productType!=null ? productService.getProductByType(productType)
                                 : productService.getProducts();
    }


}
