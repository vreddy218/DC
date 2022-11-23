package com.example.demo;

import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableEurekaClient
public class CompanyServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}

}
