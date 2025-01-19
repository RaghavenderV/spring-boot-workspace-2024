package com.vodapally.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class SingletonBeanProblem {

    @Autowired
    private PrototypeBean prototypeBean;

    public SingletonBeanProblem() {
        System.out.println("\n\n SingletonBeanProblem instance created...\n\n");
    }

    public PrototypeBean getPrototypeBean() {
        return prototypeBean;
    }
}
