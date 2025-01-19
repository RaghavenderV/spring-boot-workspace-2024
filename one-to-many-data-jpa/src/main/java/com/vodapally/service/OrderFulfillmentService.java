package com.vodapally.service;

import com.vodapally.dto.CustomerOrderDTO;
import com.vodapally.dto.OrderRequest;
import com.vodapally.entity.Customer;
import com.vodapally.repositry.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFulfillmentService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createOrder(OrderRequest orderRequest){
        Customer customer = (Customer) orderRequest.getCustomer();
        customer.getOrders().forEach(order -> order.setCustomer(customer));

        return customerRepository.save(customer);
    }

    public List<CustomerOrderDTO> findCustomerNameWithOrderCount(){
        return customerRepository.findCustomerNameWithOrderCount();
    }

}

