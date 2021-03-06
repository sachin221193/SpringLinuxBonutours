package com.bontour.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SBontourApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBontourApplication.class, args);
	}
	
	@Bean(name = "restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}
