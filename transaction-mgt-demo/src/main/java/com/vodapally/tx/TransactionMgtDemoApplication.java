package com.vodapally.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionMgtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionMgtDemoApplication.class, args);
	}

}
