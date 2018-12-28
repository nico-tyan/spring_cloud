package com.nico.common.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Filter注册
 * @author xwolf
 * @version 1.0
 * @since 1.8
 */
@Configuration
public class FilterConfig {
	private Logger log=LoggerFactory.getLogger(FilterConfig.class);  

    private static final String[] URLS = {"/*"};

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new customFilter());
        filterRegistrationBean.addUrlPatterns(URLS);
        filterRegistrationBean.setName("XSSFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
    
    class customFilter implements Filter{

		@Override
		public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
			
			
		}

		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			  log.info("customFilter 过滤前·············");
			  chain.doFilter(request,response);
			  log.info("customFilter 过滤后·············");
		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}
    	
    }
}
