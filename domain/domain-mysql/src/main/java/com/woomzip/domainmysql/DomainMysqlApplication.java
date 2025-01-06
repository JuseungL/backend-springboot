package com.woomzip.domainmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.woomzip")
public class DomainMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainMysqlApplication.class, args);
    }

}
