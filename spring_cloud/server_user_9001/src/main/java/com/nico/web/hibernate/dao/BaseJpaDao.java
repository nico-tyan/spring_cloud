package com.nico.web.hibernate.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

//使用该注解，让JPA 不去实例化该repository。 
@NoRepositoryBean //一般用作父类的repository，有这个注解，spring不会去实例化该repository。
public interface BaseJpaDao<T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>{

}
