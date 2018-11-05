package com.nico.ctl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nico.web.hibernate.dao.UserDao;
import com.nico.web.hibernate.entity.User;

@RestController
@Transactional
public class UserCtl {
	@Resource
	private UserDao userDao;
	
	@RequestMapping(value = "/user/add/{name}", method = RequestMethod.GET)
	public Object add(@PathVariable("name") String name) {
		User user = new User();
		user.setLoginName(name);
		user.setUsername(name);
		return userDao.save(user);
	}
	
	@RequestMapping(value = "/user/select/{name}", method = RequestMethod.GET)
	public Object select(@PathVariable("name") String name) {
		
		return userDao.findByUsernameContaining(name);
	}
	
}
