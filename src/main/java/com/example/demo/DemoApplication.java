package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig {

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http
					.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
					.csrf(csrf -> csrf.disable());
			return http.build();
		}
	}
}
