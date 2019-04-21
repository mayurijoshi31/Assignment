package com.uxpsystems.assignment.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.uxpsystems.assignment.dao.UserRepository;

@SpringBootApplication (scanBasePackages={"com.uxpsystems.assignment.model","com.uxpsystems.assignment.dao","com.uxpsystems.assignment.service", "com.uxpsystems.assignment.config", "com.uxpsystems.assignment.controller"})
@EntityScan("com.uxpsystems.assignment.model")
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
@ImportResource("classpath:spring-security-config.xml")
public class UserApiApplication {
	
   	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}
	
	



}
