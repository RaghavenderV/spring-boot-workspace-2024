package com.vodapally.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CustomFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Pre-processing logic (before the request reaches the controller)
        System.out.println("CustomFilter: Before request processing");
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        // Proceed with the next filter or the controller
        filterChain.doFilter(request, response);

        // Post-processing logic (after the response is generated)
        System.out.println("CustomFilter: After request processing");
        int status = response.getStatus();
        System.out.println("Response Status: " + status);
    }
}
