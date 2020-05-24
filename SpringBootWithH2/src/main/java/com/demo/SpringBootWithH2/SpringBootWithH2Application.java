package com.demo.SpringBootWithH2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.demo.controller", "com.demo.service" })
@EntityScan("com.demo.entity")
@EnableJpaRepositories("com.demo.repo")
public class SpringBootWithH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithH2Application.class, args);
	}

}
