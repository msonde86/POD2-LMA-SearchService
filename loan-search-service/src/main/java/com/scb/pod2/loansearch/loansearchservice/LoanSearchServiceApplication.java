package com.scb.pod2.loansearch.loansearchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.scb.pod2.loansearch.loansearchservice.filter.ZuulPreFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class LoanSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanSearchServiceApplication.class, args);
	}

	@Bean
	public ZuulPreFilter preFilter() {
		return new ZuulPreFilter();
	}

}
