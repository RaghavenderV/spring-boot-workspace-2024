package com.vodapally.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.vodapally.service.MyService.*(..))")
    public void serviceMethods(){
    }

    @Before("serviceMethods()")
    public void beforeServiceMethodExecution() {
        System.out.println("Before executing service method..");
    }

    @After("serviceMethods()")
    public void afterServiceMethodExecution() {
        System.out.println("After executing service method..");
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterReturningServiceMethodExecution(Object result) {
        System.out.println("After returning from service method. Result: " + result);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "exception")
    public void afterThrowingServiceMethodExecution(Exception exception) {
        System.out.println("After throwing exception in service method. Exception: " + exception.getMessage());
    }
}
