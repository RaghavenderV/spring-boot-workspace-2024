package com.vodapally.aop;

import com.vodapally.dto.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Aspect
@Component
public class ProductAspect {

    @Pointcut(value = "execution(* com.vodapally.controller.ProductController.*(..))")
    public void productPointcut(){
        System.out.println("\n inside productPointcut..\n");
    }

    //executes before any method with any parameters  in ProductController class(any return type)
    @Before(value = "productPointcut()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("\n inside beforeAdvice...");
        System.out.println("Request to "+joinPoint.getSignature()+" started at "+new Date()+"\n");
    }

    //executes after any method with any parameters  in ProductController class(any return type)
    @After(value = "productPointcut()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("\n inside afterAdvice....");
        System.out.println("Request to "+joinPoint.getSignature()+" ended at "+new Date()+"\n");
    }

    //if product saved successfully, then below aspect executes; (not working now as expected)
    @AfterReturning(value = "execution(* com.vodapally.service.ProductService.saveProduct(..))", returning = "product")
    public void afterReturningAdviceForProductService(JoinPoint joinPoint, Product product){
        System.out.println("\n inside aroundAdviceForSaveProductService ....\n");
        System.out.println("Business logic to save product ran successfully with product id : "+product.getId());
    }

    //if any exception in saveProduct in ProductService, below aspect will be executed
    @AfterThrowing(value = "execution(* com.vodapally.service.ProductService.saveProduct(..))", throwing = "exception")
    public void afterReturningAdviceForProductService(JoinPoint joinPoint, Exception exception){
        System.out.println("\n inside afterReturningAdviceForProductService..\n");
        System.out.println("Business logic to save product threw an exception "+exception.getMessage());
    }

    // Around advice gives us the power to control the code flow
    @Around(value = "execution(* com.vodapally.service.ProductService.saveProduct(..))")
    public List<Product> aroundAdviceForSaveProductService(ProceedingJoinPoint joinPoint){
        System.out.println("\n Inside Around Advice aspect : Business logic to saveProduct started at : "+new Date());
        try {
            List<Product> products = (List<Product>) joinPoint.proceed();// to call the actual method , that is saveProduct(); this proceed method will take over the control
            return products;
        } catch (Throwable e) {
            System.out.println("Inside Around Advice aspect : Business logic to saveProduct FAILED TERRIBLY!!" +e.getMessage());
        }
        return null;
    }
}
