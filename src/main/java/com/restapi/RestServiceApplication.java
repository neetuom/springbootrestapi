package com.restapi;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://andriperera.medium.com/create-a-rest-api-in-spring-boot-with-mysql-b250ff3aaa9b
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="SpringBootRestApi API",version="3.0",description="Promotion API"))
public class RestServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestServiceApplication.class, args);
    }

}