package com.vodapally.aspect;

import com.vodapally.security.Secured;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Create an aspect that will intercept methods annotated with @Secured and perform security checks.
@Aspect
@Component
public class SecurityAspect {

    @Around("@annotation(com.vodapally.security.Secured)")
    public Object checkSecurity(ProceedingJoinPoint joinPoint) throws Throwable{

        // Get the method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // Get the @Secured annotation
        Secured secured = signature.getMethod().getAnnotation(Secured.class);

        // Simulate the current user's user role
        String[] userRoles = {"USER","ADMIN"};

        // Check if the user has any of the required roles
        boolean hasAccess = Arrays.stream(secured.roles()).anyMatch(role -> Arrays.asList(userRoles).contains(role));

        if (hasAccess){
            // If the user has the required role, proceed with the method execution
            return joinPoint.proceed();
        }
        else {
            // If the user does not have the required role, throw an exception
            throw new SecurityException("Access denied. Required roles: " + Arrays.toString(secured.roles()));
        }
    }
}
