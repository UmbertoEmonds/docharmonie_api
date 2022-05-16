package com.umbertoemonds.docharmonie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/hello")
	public String hello(){
		return "Bienvenue sur l'API de DOCTEUR HARMONIE";
	}
	
}