package com.vodapally;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WhatsappChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsappChatApplication.class, args);
	}

}
