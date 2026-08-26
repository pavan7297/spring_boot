package com.ai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

	 @Bean
	    public RestClient restClient() {
	        return RestClient.builder()
	                .baseUrl("http://localhost:11434")
	                .build();
	    }

	 @Bean
	    public WebClient webClient() {
	        return WebClient.builder()
	                .baseUrl("http://localhost:11434")
	                .build();
	    }
}
