package com.vodapally.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String> customHeaders;

    public CustomHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.customHeaders = new HashMap<>();
    }
    public void addHeader(String name, String value) {
        customHeaders.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        // Check custom headers first
        String headerValue = customHeaders.get(name);
        if (headerValue != null) {
            return headerValue;
        }
        // Fall back to the original request headers
        return super.getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        // Combine custom headers and original headers
        java.util.Set<String> headerNames = new java.util.HashSet<>(Collections.list(super.getHeaderNames()));
        headerNames.addAll(customHeaders.keySet());
        return Collections.enumeration(headerNames);
    }

}
