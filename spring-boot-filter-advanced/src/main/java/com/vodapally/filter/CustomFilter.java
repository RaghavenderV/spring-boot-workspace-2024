package com.vodapally.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;

@Component
public class CustomFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Log request details
        logRequestDetails(request);

        // Modify request headers (example: add a custom header)
        CustomHttpServletRequestWrapper wrappedRequest = new CustomHttpServletRequestWrapper(request);
        wrappedRequest.addHeader("X-Custom-Request-Header", "Request-Header-Value");

        // Authentication check (example: validate a token)
        String authToken = request.getHeader("Authorization");
        if (authToken == null || !authToken.equals("Bearer valid-token")) {
            // Return a 401 Unauthorized response if the token is invalid
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized: Invalid or missing token");
            return; // Stop further processing
        }

        // Proceed with the next filter or the controller
        filterChain.doFilter(wrappedRequest, response);

        // Modify response headers (example: add a custom header)
        response.addHeader("X-Custom-Response-Header", "Response-Header-Value");

        // Log response details
        logResponseDetails(response);
    }

    private void logRequestDetails(HttpServletRequest request) {
        System.out.println("=== Request Details ===");
        System.out.println("Method: " + request.getMethod());
        System.out.println("URI: " + request.getRequestURI());
        System.out.println("Headers:");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + request.getHeader(headerName));
        }
    }

    private void logResponseDetails(HttpServletResponse response) {
        System.out.println("=== Response Details ===");
        System.out.println("Status: " + response.getStatus());
        System.out.println("Headers:");
        response.getHeaderNames().forEach(headerName ->
                System.out.println(headerName + ": " + response.getHeader(headerName)));

    }
}
