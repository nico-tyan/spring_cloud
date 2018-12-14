package com.nico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignAPP {
	public static void main(String[] args) {
		SpringApplication.run(FeignAPP.class , args);
	}
	
	@Bean
    public IRule feignRule() {
		//return new RoundRobinRule();//默认轮询
        return new RandomRule();//随机
    }

}
