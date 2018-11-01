package spring_cloud_config.config;

import org.springframework.stereotype.Component;

//父类
@Component("father")
public class Father {
	String name = "father112";

	public void fatherTest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}