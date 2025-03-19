package com.vodapally.controller;

import com.vodapally.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/doSomething")
    public String doSomething() {
        return myService.doSomething();
    }

    @GetMapping("/doSomethingElse")
    public String doSomethingElse() {
        return myService.doSomethingElse();
    }
}
