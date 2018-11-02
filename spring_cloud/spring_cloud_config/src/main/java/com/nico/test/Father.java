package com.nico.test;

import org.springframework.stereotype.Component;

//父类
@Component("father")
public class Father implements IChildren{
	String name = "father112";

	public String getValue() {
		
		return this.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}