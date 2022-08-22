package com.umbertoemonds.docharmonie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@SpringBootApplication
public class DocharmonieApplication {
	public static void main(String[] args) {
		SpringApplication.run(DocharmonieApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder(BCryptVersion.$2A, 4);
	}
	
	@Bean
	public WebClient iaApiClient(){
		return WebClient.create("http://127.0.0.1:8000");
	}

}