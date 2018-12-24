package com.nico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 建造者模式缓存用户
 * @Title: 
 * @Package com.nico.config  
 * @Description: 
 * @author fangshu  
 * @date 2018年12月20日  
 * @version
 */
/*@Configuration
@EnableWebSecurity
public class SecurityConfiguration2 {
	   
	   @Bean
	   protected UserDetailsService userDetailsService(){
	       InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	       manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
	       manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
	       return manager;
	   }
}*/
