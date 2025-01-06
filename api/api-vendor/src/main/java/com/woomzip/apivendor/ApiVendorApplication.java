package com.woomzip.apivendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.woomzip")
public class ApiVendorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVendorApplication.class, args);
	}

}
