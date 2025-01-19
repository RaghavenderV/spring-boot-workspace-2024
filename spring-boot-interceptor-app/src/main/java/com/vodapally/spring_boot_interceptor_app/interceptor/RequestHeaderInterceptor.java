package com.vodapally.spring_boot_interceptor_app.interceptor;

import com.vodapally.spring_boot_interceptor_app.exception.InvalidFieldException;
import com.vodapally.spring_boot_interceptor_app.exception.InvalidHeaderFieldException;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestHeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(StringUtils.isBlank(request.getHeader("my-secret-key"))){
            throw new InvalidHeaderFieldException("Invalid Request");
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
