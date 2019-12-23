package com.esteban.springsecuritypoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringSecurityPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityPocApplication.class, args);
	}

}
