package com.nico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 适配器模式缓存用户
 * @Title: 
 * @Package com.nico.config  
 * @Description: 
 * @author fangshu  
 * @date 2018年12月20日  
 * @version
 */
/*@Configuration
@EnableWebSecurity
public class SecurityConfiguration1 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user_1").password("123456").authorities("USER")
                .and()
                .withUser("user_2").password("123456").authorities("USER");
   }

   @Bean
   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
       AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }
}*/
