package com.vodapally.config;

import com.vodapally.beans.MyBean;
import com.vodapally.beans.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean(){
        MyBean bean = new MyBean();
        bean.setMessage("Hello! Spring!!");
        return bean;
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
