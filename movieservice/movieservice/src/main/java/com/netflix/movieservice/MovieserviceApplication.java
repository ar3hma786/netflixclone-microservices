package com.netflix.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MovieserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieserviceApplication.class, args);
	}

}
