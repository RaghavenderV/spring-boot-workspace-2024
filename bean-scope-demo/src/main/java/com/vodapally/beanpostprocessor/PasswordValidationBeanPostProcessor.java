package com.vodapally.beanpostprocessor;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof User user){
            if(!isValidPassword(user.getPassword())){
                throw new IllegalArgumentException("Invalid Password for user : "+user.getUserName());
            }
            System.out.println("Created User ("+ user.getUserName()+") Successfully!! \n");
        }

        return bean;
    }

    // returns true if password is >=6
    private boolean isValidPassword(String password) {
        System.out.println("\n Password length--->"+password.length());
        return password.length()>=6;
    }

//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        return bean;
//    }

    @PostConstruct
    public void testPostConstruct(){
        System.out.println("\n ****************************\n");
        System.out.println("PostConstruct called.........\n");
        System.out.println("\n ****************************\n");
    }

}
