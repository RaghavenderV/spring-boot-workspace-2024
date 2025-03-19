package com.vodapally;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcGroupByApplication {

	public static void main(String[] args) {
		System.out.println("\nHello Spring JDBC!!\n");
		SpringApplication.run(SpringBootJdbcGroupByApplication.class, args);
	}

}
