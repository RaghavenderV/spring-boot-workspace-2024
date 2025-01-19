package com.vodapally.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.vodapally.business.ShoppingCart.checkOut())")
    public void logger(){
        System.out.println("Loggers...");
    }
}
