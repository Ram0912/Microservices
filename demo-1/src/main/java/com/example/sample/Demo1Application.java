package com.example.sample;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.sample.dao.AccountRepository;
import com.example.sample.dao.RemoteAccountRepository;

@SpringBootApplication
public class Demo1Application {
	public static final String ACCOUNTS_SERVICE_URL = "http://localhost:2222";

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public AccountRepository accountRepository() {
		return new RemoteAccountRepository(ACCOUNTS_SERVICE_URL);
	}
}
