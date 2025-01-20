package com.vodapally.service;

import com.vodapally.entity.Product;
import com.vodapally.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product updateStockQuantity(Integer productId, Integer quantity){
        productRepository.updateStock(productId, quantity);
        return productRepository.findById(productId).get();
    }

    public Double calculateProductPrice(int id){
        return productRepository.getTotalPriceForProduct(id);
    }
}
