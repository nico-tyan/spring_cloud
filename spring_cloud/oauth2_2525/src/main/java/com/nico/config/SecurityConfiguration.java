package com.nico.config;

import java.util.Objects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// 使用内存中的用户
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
		manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
		return manager;
	}

	//
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.requestMatchers()
		// 放行所有的oauth开头请求
		.antMatchers("/oauth/*")
		// 放行所有的login开头请求
		.antMatchers("/login/*")
        .and()
        .authorizeRequests()
        .anyRequest().authenticated();
		
	}

	/**
	 * 如果想用OPENID 可以在此处配置
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}

	
}
