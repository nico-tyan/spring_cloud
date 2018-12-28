package com.nico.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nico.web.mybatis.entity.SysUser;

public class SysUserDetails extends SysUser implements UserDetails{

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		ArrayList<SimpleGrantedAuthority> roleList=new ArrayList<SimpleGrantedAuthority>();
//		
//		SimpleGrantedAuthority role1=new SimpleGrantedAuthority("ADMIN");
//		roleList.add(role1);
//		
//		SimpleGrantedAuthority role2=new SimpleGrantedAuthority("USER");
//		roleList.add(role2);
		
//		return roleList;
		
		return AuthorityUtils.createAuthorityList("ADMIN","USER");
		
	}

	@Override
	public String getPassword() {
		
		return getLoginPassword();
	}

	@Override
	public String getUsername() {
		return getLoginName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
