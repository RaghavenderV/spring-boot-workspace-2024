package com.vodapally;

import com.vodapally.beans.MyBean;
import com.vodapally.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBeanLifecycleApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MyBean bean = context.getBean(MyBean.class);
		bean.execute();

		context.close();
	}

}
