package com.nico.web.ctl;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SERVER-USER", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptServiceFeign {

	@RequestMapping(value = "/dept/add/{deptName}/{deptNo}", method = RequestMethod.GET)
	public Object add(@PathVariable("deptName") String deptName,@PathVariable("deptNo") String deptNo) ;

	@RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
	public Object findAll();

}
