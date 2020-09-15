package com.scb.pod2.loansearch.loansearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanSearchServiceApplication.class, args);
	}

}
