package com.vodapally.controller;

import com.vodapally.scope.RequestScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestScopeController {

    @Autowired
    private RequestScope requestScope;

    @RequestMapping("/message")
    public String getMessage(){
        return requestScope.getMessage();
    }
}
