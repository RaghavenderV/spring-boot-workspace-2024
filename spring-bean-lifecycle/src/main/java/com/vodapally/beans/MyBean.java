package com.vodapally.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean, DisposableBean {

    private String message;

    public MyBean(){
        System.out.println("Step 1: Bean Instantiated");
    }

    public void setMessage(String message) {
        this.message = message;
        System.out.println("Step 2: Properties Populated - Message: " + message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Step 4: Bean Initialized - afterPropertiesSet() called");
    }

    public void customInit() {
        System.out.println("Step 4: Custom Init Method Called");
    }

    //5. Bean is Ready for Use: The bean is fully initialized and can be used by the application.
    public void execute() {
        System.out.println("Step 5: Bean in Use - Message: " + message);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Step 6: Bean Destroyed - destroy() called");
    }

    public void customDestroy() {
        System.out.println("Step 6: Custom Destroy Method Called");
    }

}
