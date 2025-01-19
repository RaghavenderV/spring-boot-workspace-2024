package com.vodapally;

import com.vodapally.client.UserClient;
import com.vodapally.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
//@RestController
public class FeignClientDemoApplication {

//	@Autowired
//	private UserClient userClient;
//
//	@GetMapping("/findUsers")
//	public List<UserResponse> getUsers(){
//		return userClient.getUsers();
//	}

	public static void main(String[] args) {
		SpringApplication.run(FeignClientDemoApplication.class, args);
	}

}
