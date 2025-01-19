package com.vodapally.spring_transaction;

import com.vodapally.spring_transaction.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTxPropagationApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringTxPropagationApplication.class, args);
		System.out.println("Hello args = " + args);

		Product product = new Product();
		product.setName("Smart Phone");
		System.out.println("----> Product -->"+product.getName());
	}

}
