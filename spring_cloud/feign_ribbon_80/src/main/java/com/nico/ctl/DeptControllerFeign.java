package com.nico.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nico.web.ctl.DeptServiceFeign;

@RestController
public class DeptControllerFeign {
	
	@Autowired
	private DeptServiceFeign deptServiceFeign;

	@RequestMapping(value = "/dept/add/{deptName}/{deptNo}", method = RequestMethod.GET)
	public Object add(@PathVariable("deptName") String deptName,@PathVariable("deptNo") String deptNo) {

		return deptServiceFeign.add(deptName, deptNo);
	}

	@RequestMapping(value = "/dept/findAll", method = RequestMethod.GET)
	public Object select() {
		
		return deptServiceFeign.findAll();
	}

}
