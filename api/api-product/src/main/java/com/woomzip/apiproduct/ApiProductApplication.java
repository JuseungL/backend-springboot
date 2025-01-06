package com.woomzip.apiproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.woomzip")
public class ApiProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiProductApplication.class, args);
    }

}
