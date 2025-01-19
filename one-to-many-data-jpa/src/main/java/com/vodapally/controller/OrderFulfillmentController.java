package com.vodapally.controller;

import com.vodapally.dto.CustomerOrderDTO;
import com.vodapally.dto.OrderRequest;
import com.vodapally.entity.Customer;
import com.vodapally.service.OrderFulfillmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ecom")
public class OrderFulfillmentController {

    @Autowired
    private OrderFulfillmentService service;

    @GetMapping("/hello")
    public String getMessage(){
        return "Hello Toopran!!";
    }

    @PostMapping("/addOrder")
    public ResponseEntity<String> addOrder(@RequestBody OrderRequest<Customer> orderRequest){

        System.out.println("Order Request : "+orderRequest);
        Customer customer = service.createOrder(orderRequest);
        return ResponseEntity.ok("Order created successfully!!");
    }

    @GetMapping("/nameWithOrderCount")
    public List<CustomerOrderDTO> findCustomerNameWithOrderCount(){
        return service.findCustomerNameWithOrderCount();
    }
}
