package com.movies.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MoviesRatingServiceApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(MoviesRatingServiceApplication.class, args);
	}

}
