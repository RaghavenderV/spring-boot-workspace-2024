package com.vodapally.service;

import com.vodapally.entity.Product;
import com.vodapally.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
