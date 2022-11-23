package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@CrossOrigin(origins="*")
public class CustomerServiceApplication {






	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	@Bean
	public WebMvcConfigurer crosConfigurer() {
		
		return new WebMvcConfigurer()
				{
			public void addCrosMappings(CorsRegistry registry)
			{
				registry.addMapping("pathPattern:'/*'").allowedHeaders("*").allowedOrigins("*").allowedMethods("*")
				.allowCredentials(true);
			}
			
				};
		
	}
	

	

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
