package com.nico.ctl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.nico.web.mybatis.entity.SysUser;
import com.nico.web.mybatis.mapper.SysUserMapper;

@RestController
@Transactional
public class UserCtl {
	@Resource
	private SysUserMapper sysUserMapper;
	
	@RequestMapping(value = "/user/add/{name}", method = RequestMethod.GET)
	public Object add(@PathVariable("name") String name) {
		SysUser sysUser = new SysUser();
		sysUser.setLoginName(name);
		sysUser.setUserName(name);
		return sysUserMapper.insert(sysUser);
	}
	
	@RequestMapping(value = "/user/select/{name}", method = RequestMethod.GET)
	public Object select(@PathVariable("name") String name) {
		EntityWrapper<SysUser> entityWrapper = new EntityWrapper<>();
		entityWrapper.like("user_name", name);
		return sysUserMapper.selectList(entityWrapper);
	}
	
}
