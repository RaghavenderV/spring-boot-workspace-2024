package com.vodapally.service;

import com.vodapally.model.CustomerOrderSummary;
import com.vodapally.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<CustomerOrderSummary> getCustomerOrderSummaries(){
        return orderRepository.getCustomerOrderSummaries();
    }
}
