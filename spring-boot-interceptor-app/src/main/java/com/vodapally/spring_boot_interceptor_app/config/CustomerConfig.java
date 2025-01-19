package com.vodapally.spring_boot_interceptor_app.config;

import com.vodapally.spring_boot_interceptor_app.interceptor.LoggingInterceptor;
import com.vodapally.spring_boot_interceptor_app.interceptor.RequestHeaderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomerConfig implements WebMvcConfigurer {
    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Autowired
    private RequestHeaderInterceptor requestHeaderInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/customer/**") //define the url pattern to be intercepted
                .excludePathPatterns("/customer/auth/**"); //define the url pattern to be excluded from interception

        registry.addInterceptor(requestHeaderInterceptor);
    }
}
