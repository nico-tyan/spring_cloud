package com.nico.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.nico.web.mybatis.entity.SysUser;
import com.nico.web.mybatis.mapper.SysUserMapper;

/**
 * 认证服务
 * @Title: 
 * @Package com.nico.config  
 * @Description: 
 * @author fangshu  
 * @date 2018年12月28日  
 * @version
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	Logger logger=LoggerFactory.getLogger(SecurityConfiguration.class);
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	// 用户服务
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				SysUser sysUser=new SysUser();
				if (sysUser == null) throw new UsernameNotFoundException("Username:[" + username + "]not found");
				sysUser.setLoginName(username);
				sysUser = sysUserMapper.selectOne(sysUser);
				SysUserDetails userDetails =new SysUserDetails();
				BeanUtils.copyProperties(sysUser, userDetails);
				return userDetails;
			}
		};
	}

	//
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.requestMatchers()
//		.antMatchers("/order/*")
//        .and()
//        .authorizeRequests() //定义哪些请求需要被保护
//        // 放行所有的oauth开头请求
//        .antMatchers("/product/*","/login/*").permitAll()
//        //设置所有人都可以访问test/*请求
//        .and()
//        .authorizeRequests() //定义哪些请求需要被保护
//        .antMatchers("/test/*").anonymous()//此处用于认证服务器受保护的资源--授权服务器是另外的
//        //.and()
//       // .authorizeRequests() //定义哪些请求需要被保护
//        .anyRequest().authenticated()//任何请求 登录后都可以访问--
//        .and().csrf().disable();
		
		http
		.requestMatchers()
		// 放行所有的oauth开头请求
		.antMatchers("/oauth/**","/test/**")
		// 放行所有的login开头请求
		//.antMatchers("/login/*")
        .and()
        .authorizeRequests()//定义哪些请求需要被保护
        .anyRequest().authenticated();

	}

	/**
	 * 如果想用OPENID 可以在此处配置
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
		auth.eraseCredentials(false);//擦除凭证
	}
	
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }
	
}
