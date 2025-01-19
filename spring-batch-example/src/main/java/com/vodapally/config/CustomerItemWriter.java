package com.vodapally.config;

import com.vodapally.entity.Customer;
import com.vodapally.repository.CustomerRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerItemWriter implements ItemWriter<Customer> {
    @Autowired
    private CustomerRepository repository;
    @Override
    public void write(Chunk<? extends Customer> chunk) throws Exception {
        System.out.println("Writer Thread : "+Thread.currentThread().getName());
        repository.saveAll(chunk);
    }
}
