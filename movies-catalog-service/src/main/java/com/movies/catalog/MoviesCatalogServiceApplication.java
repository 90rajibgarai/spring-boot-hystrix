package com.movies.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.movies.catalog")
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MoviesCatalogServiceApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(MoviesCatalogServiceApplication.class, args);
	}

}
