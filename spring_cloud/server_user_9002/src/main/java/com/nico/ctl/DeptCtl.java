package com.nico.ctl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nico.web.hibernate.dao.DeptDao;
import com.nico.web.hibernate.entity.Dept;

@RestController
@Transactional
public class DeptCtl {
	@Resource
	private DeptDao deptDao;
	
	@RequestMapping(value = "/dept/add/{deptName}/{deptNo}", method = RequestMethod.GET)
	@HystrixCommand
	public Object add(@PathVariable("deptName") String deptName,@PathVariable("deptNo") String deptNo) {
		Dept dept=new Dept();
		dept.setDeptName(deptName);
		dept.setDeptNo(deptNo);
		dept.setDataSource("springcloud_mybatis");
		return deptDao.save(dept);
	}
	
	@RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
	@HystrixCommand
	public Object select() {
		
		return deptDao.findAll();
	}
}
