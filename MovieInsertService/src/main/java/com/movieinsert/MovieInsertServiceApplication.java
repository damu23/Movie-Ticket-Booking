package com.movieinsert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieInsertServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieInsertServiceApplication.class, args);
	}

} 
