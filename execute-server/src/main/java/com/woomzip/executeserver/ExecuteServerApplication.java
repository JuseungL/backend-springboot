package com.woomzip.executeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.woomzip")
public class ExecuteServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExecuteServerApplication.class, args);
    }

}
