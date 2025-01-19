package com.vodapally.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class SingletonBeanSolution {

    @Autowired
    private PrototypeBean prototypeBean;

    public SingletonBeanSolution() {
        System.out.println("\nSingletonBeanSolution instance created...\n");
    }

    //Solution-1
//    @Autowired
//    private ApplicationContext context;
//
//    public PrototypeBean getPrototypeBean() {
//        return context.getBean(PrototypeBean.class);
//    }

    //Solution-2

    @Lookup
    public PrototypeBean getInstance(){
        return null;
    }


}
