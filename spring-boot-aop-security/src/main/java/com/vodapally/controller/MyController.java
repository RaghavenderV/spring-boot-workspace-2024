package com.vodapally.controller;

import com.vodapally.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    @GetMapping("/admin")
    public String adminOnly() {
        return myService.adminOnlyMethod();
    }

    @GetMapping("/user")
    public String userOrAdmin() {
        return myService.userOrAdminMethod();
    }

    @GetMapping("/public")
    public String publicAccess() {
        return myService.publicMethod();
    }

}
