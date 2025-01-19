package com.vodapally.spring_boot_interceptor_app.controller;

import com.vodapally.spring_boot_interceptor_app.exception.InvalidFieldException;
import com.vodapally.spring_boot_interceptor_app.model.Customer;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    @GetMapping("/welcome")
    public String getMessage(){
        String message = "Welcome to CustomerController!!";
        log.info("getMessage() :: CustomerController");
        return message;
    }

    @GetMapping("/info")
    public String getInfo(){
        String info = "Customer Info :: Raghavender";
        log.info("getInfo() :: CustomerController");
        return info;
    }

    @PostMapping
    public String saveCustomer(@RequestHeader("my-secret-key") String authorization, @RequestBody Customer customer){
        if(StringUtils.isBlank(customer.getLastName())){
            throw new InvalidFieldException("Last Name is a required field");
        }

        System.out.println("Authorized Successfully!!");

        return String.format("Authorization %s is valid, and data is saved successfully!", authorization);
    }

}
