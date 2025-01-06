package com.woomzip.apiinquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.woomzip")
public class ApiInquiryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiInquiryApplication.class, args);
	}

}
