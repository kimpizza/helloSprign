package com.cos.security01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.cos.security01")
public class Security01Application {

	public static void main(String[] args) {
		SpringApplication.run(Security01Application.class, args);
	}
}
