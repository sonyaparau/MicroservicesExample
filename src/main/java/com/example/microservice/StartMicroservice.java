package com.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.microservice")
@EntityScan(basePackages = "com.example.microservice")
public class StartMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(StartMicroservice.class, args);
    }
}
