package com.vodapally.command.api.events;

import com.vodapally.command.api.data.Product;
import com.vodapally.command.api.data.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ProcessingGroup("product")
public class ProductEventsHandler {
    private ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent, product);
        productRepository.save(product);
        //throw new Exception("Forcefully throwing exception..");
        //If there is any exception, after saving the product in db, it will revoke the transaction.
        //No record is saved if exception. Uncomment 25 line to test this.
    }

    @ExceptionHandler
    public void handler(Exception exception) throws Exception {
        throw exception;
    }
}
