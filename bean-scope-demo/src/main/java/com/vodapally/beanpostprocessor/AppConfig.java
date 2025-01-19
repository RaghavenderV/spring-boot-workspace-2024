package com.vodapally.beanpostprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public User getUser(){
        User user = new User();
        user.setUserName("Raghu");
        user.setPassword("raghavender"); // creates user if password is >=6
        return user;
    }


}
