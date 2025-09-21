package com.pos.employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	// For RestTemplate Internal Communication
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}


//	//For Web Client Internal Communication
//	@Bean
//	public WebClient webClient() {
//		return WebClient.builder().build();
//	}




}
