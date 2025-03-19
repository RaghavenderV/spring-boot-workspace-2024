package com.vodapally;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootAopBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopBasicsApplication.class, args);
	}

}
