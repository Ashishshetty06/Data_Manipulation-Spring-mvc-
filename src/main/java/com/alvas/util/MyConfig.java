package com.alvas.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.alvas")
public class MyConfig {
	@Bean
	public EntityManagerFactory getEmf() {
		return Persistence.createEntityManagerFactory("ashish");
	}
}