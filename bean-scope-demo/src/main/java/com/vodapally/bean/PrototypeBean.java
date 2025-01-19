package com.vodapally.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("\nPrototypeBean instance created...\n");
    }
}
