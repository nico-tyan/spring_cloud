package spring_cloud_config.config;

import org.springframework.stereotype.Repository;

//子类
@Repository("children")
public class Children extends Father implements IChildren {
	String name = "Children112";

	public void childrenTest() {
		fatherTest();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}