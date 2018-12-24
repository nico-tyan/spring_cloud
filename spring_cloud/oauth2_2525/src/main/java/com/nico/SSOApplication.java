package com.nico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SSOApplication extends WebMvcConfigurerAdapter {
	/**
	 * 
	http://localhost:2525/oauth/token?grant_type=client_credentials&scope=select&client_id=client_1&client_secret=12346

	http://localhost:2525/oauth/token?username=user_1&password=123456&grant_type=password&scope=select&client_id=client_2&client_secret=123456

	 * 
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(SSOApplication.class, args);
	}
}
