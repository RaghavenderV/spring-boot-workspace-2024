package com.vodapally;

import com.vodapally.business.ShoppingCart;
import com.vodapally.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 *
 */
@EnableAspectJAutoProxy
public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);
        shoppingCart.checkOut();

    }
}
