package com.vodapally.security;

import com.vodapally.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// Create a security configuration class to enable oauth2 login
public class SecurityConfig {
    @Bean
    public CustomOAuth2UserService customOAuth2UserService(){
        return new CustomOAuth2UserService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authorize ->
                authorize.requestMatchers("/", "/public").permitAll() //public end points
                        .anyRequest().authenticated() // all other end points require authentication
        )
                .oauth2Login(oauth2 ->
                        oauth2.userInfoEndpoint(userInfo ->
                                        userInfo.userService(customOAuth2UserService()))
                                .defaultSuccessUrl("/user",true));

        return http.build();
    }
}
