package com.vodapally.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomFilterController {

    @GetMapping("/welcome")
    public String greeting() {
        System.out.println("\nCustomFilterController::greeting");
        return "Hello Filters!!";
    }
}
