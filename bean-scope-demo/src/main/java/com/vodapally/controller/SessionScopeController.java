package com.vodapally.controller;

import com.vodapally.scope.RequestScope;
import com.vodapally.scope.SessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionScopeController {

    @Autowired
    private SessionScope sessionScope;

    @RequestMapping("/message")
    public String getMessage(){
        return sessionScope.getMessage();
    }
}
