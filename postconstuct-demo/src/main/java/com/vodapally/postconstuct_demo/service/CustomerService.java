package com.vodapally.postconstuct_demo.service;

import com.vodapally.postconstuct_demo.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public CustomerService() {
        System.out.println("Constructor :: CustomerService");
    }

    public Customer getCustomer(){
        //return new Customer("Somanath", "Kerala");

        return new Customer("Modi","Gujarat");
    }
}
