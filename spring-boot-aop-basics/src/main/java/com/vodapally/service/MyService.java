package com.vodapally.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public String doSomething(){
        System.out.println("Doing doSomething...");
        return "Done!";
    }

    public String doSomethingElse(){
        System.out.println("Doing doSomething else...");
        return "Done something else!!";
    }

}
