package com.vodapally.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeScope {
    public PrototypeScope() {
        System.out.println("PrototypeScope instance created...");
    }
}
