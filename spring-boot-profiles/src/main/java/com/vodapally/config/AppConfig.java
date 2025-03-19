package com.vodapally.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public String devBean(){
        return "This bean is active in DEV profile only!";
    }

    @Bean
    @Profile("prod")
    public String prodBean(){
        return "This bean is active in PROD profile only!";
    }
}
