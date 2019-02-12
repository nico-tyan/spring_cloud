package com.nico.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@EnableAdminServer
public class AdminAPP {
	public static void main(String[] args) {
		
		SpringApplication.run(AdminAPP.class , args);
	}

}
