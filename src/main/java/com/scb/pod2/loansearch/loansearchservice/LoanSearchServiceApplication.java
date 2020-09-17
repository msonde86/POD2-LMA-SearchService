package com.scb.pod2.loansearch.loansearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.Generated;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanSearchServiceApplication {

	@Generated
	public static void main(String[] args) {
		SpringApplication.run(LoanSearchServiceApplication.class, args);
	}

}
