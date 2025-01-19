package com.vodapally;

import com.vodapally.bean.SingletonBeanProblem;
import com.vodapally.bean.SingletonBeanSolution;
import com.vodapally.scope.PrototypeScope;
import com.vodapally.scope.SingletonScope;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.crypto.spec.PSource;

@SpringBootApplication
public class BeanScopeDemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(BeanScopeDemoApplication.class, args);

		System.out.println("\n\n*********************************");
		//only one instance of the bean SingletonScope created per ApplicationContext
		SingletonScope singletonScope1 = context.getBean(SingletonScope.class);
		SingletonScope singletonScope2 = context.getBean(SingletonScope.class);
		SingletonScope singletonScope3 = context.getBean(SingletonScope.class);

		System.out.println("\n\n*********************************");

		//multiple instances of the bean PrototypeScope created
		PrototypeScope prototypeScope1 = context.getBean(PrototypeScope.class);
		PrototypeScope prototypeScope2 = context.getBean(PrototypeScope.class);
		PrototypeScope prototypeScope3 = context.getBean(PrototypeScope.class);

		System.out.println("\n\n*********************************");
		System.out.println("\nWhat happens if we inject PrototypeBean into SingletonBean?");

		SingletonBeanProblem sb1 = context.getBean(SingletonBeanProblem.class);
		SingletonBeanProblem sb2 = context.getBean(SingletonBeanProblem.class);

		System.out.println(sb1.getPrototypeBean().hashCode()+" : "+sb2.getPrototypeBean().hashCode());

		System.out.println("\n\n Only one instance of the bean will be created..PrototypeBean looses" +
				" its behaviour");

//		System.out.println("\n Solution-1 using ApplicationContext");
//
//		SingletonBeanSolution sb3 = context.getBean(SingletonBeanSolution.class);
//		SingletonBeanSolution sb4 = context.getBean(SingletonBeanSolution.class);
//
//		System.out.println(sb3.getPrototypeBean().hashCode()+" : "+sb4.getPrototypeBean().hashCode());
//		System.out.println("Multiple instances of the bean will be created..");

		System.out.println("\n Solution-2 using @Lookup");

		SingletonBeanSolution sb5 = context.getBean(SingletonBeanSolution.class);
		SingletonBeanSolution sb6 = context.getBean(SingletonBeanSolution.class);

		System.out.println(sb5.getInstance().hashCode()+" : "+sb6.getInstance().hashCode());

		System.out.println("Multiple instances of the bean will be created..");
	}

}
