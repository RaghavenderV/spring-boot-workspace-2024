package com.vodapally.controller;

import com.vodapally.model.CustomerOrderSummary;
import com.vodapally.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<CustomerOrderSummary> getCustomerOrderSummaries(){
        return orderService.getCustomerOrderSummaries();
    }
}
