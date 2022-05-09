package com.hof.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages="com.cybage")
@EnableJpaRepositories(basePackages="com.cybage.repository")
@EntityScan(basePackages="com.cybage.domain")
public class SecretSantaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretSantaApplication.class, args);
		
	}

}


