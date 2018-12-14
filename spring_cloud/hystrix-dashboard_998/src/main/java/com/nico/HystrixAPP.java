package com.nico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableCircuitBreaker // 启动断路器，如果要监控hystrix的流必须开启此注解，即使fegin已经通过属性
@EnableHystrixDashboard
public class HystrixAPP {
	public static void main(String[] args) {
		SpringApplication.run(HystrixAPP.class , args);
	}

}
