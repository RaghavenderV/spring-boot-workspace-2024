package com.vodapally.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home(){
        return "Welcome to Home Page!";
    }

    @GetMapping("/public")
    public String publicPage(){
        return "This is a public page!!";
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User principal){
        // Display user info from GitHub
        return "Hello, "+principal.getAttribute("login");
    }
}
