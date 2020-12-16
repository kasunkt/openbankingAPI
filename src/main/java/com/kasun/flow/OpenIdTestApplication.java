package com.kasun.flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.kasun")
public class OpenIdTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenIdTestApplication.class, args);
	}

}
