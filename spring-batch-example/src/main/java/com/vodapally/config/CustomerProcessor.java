package com.vodapally.config;

import com.vodapally.entity.Customer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        int age = Integer.parseInt(customer.getAge());
        if(age>=18)
            return customer;
        return null;
    }
}
