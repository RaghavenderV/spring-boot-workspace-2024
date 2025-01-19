package com.vodapally.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonScope {
    public SingletonScope() {
        System.out.println("\n\nSingletonScope instance created...\n\n");
    }
}
