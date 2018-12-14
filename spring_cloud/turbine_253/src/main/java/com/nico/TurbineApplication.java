package com.nico;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableEurekaClient
@SpringCloudApplication
public class TurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}