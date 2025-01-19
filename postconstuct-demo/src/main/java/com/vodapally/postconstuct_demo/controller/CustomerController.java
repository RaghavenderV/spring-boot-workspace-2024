package com.vodapally.postconstuct_demo.controller;

import com.vodapally.postconstuct_demo.entity.Customer;
import com.vodapally.postconstuct_demo.service.CustomerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController() {
        //System.out.println(customerService.getCustomer()); //test this
        System.out.println("Constructor :: CustomerController");
    }

    @PostConstruct
    public void getCustomer(){
        System.out.println("getCustomer :: CustomerController");
        System.out.println(customerService.getCustomer());
    }
}
