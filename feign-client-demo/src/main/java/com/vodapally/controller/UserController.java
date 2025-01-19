package com.vodapally.controller;

import com.vodapally.client.UserClient;
import com.vodapally.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/findUsers")
    public List<UserResponse> getUsers(){
        return userClient.getUsers();
    }
}
