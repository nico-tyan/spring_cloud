package com.nico.web.ctl;

import org.springframework.stereotype.Component;

import com.nico.web.ctl.DeptServiceFeign;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptServiceFeign> {

	@Override
	public DeptServiceFeign create(Throwable arg0) {

		return new DeptServiceFeign() {
			
			@Override
			public Object findAll() {
				
				return fallback();
			}
			
			@Override
			public Object add(String deptName, String deptNo) {
				
				return fallback();
			}
		};
	}

	public Object fallback() {

		return "feign熔断中,暂停提供服务";
	}

}
