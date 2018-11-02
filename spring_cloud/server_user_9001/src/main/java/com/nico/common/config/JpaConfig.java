package com.nico.common.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactory",
//transactionManagerRef = "mysqlTransactionManager",
//设置DAO仓库扫描路径，多个dao用逗号隔开--注意别和mybatis的dao搞混了
basePackages = {"com.nico.web.hibernate.dao"})
public class JpaConfig {
	
	@Bean(name = "mysqlEntityManagerFactory")
	@Autowired
	@Qualifier("mysqlDS")//指定注入该名称的数据源datasource
	public EntityManagerFactory entityManagerFactory(DataSource datasource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setDataSource(datasource);
		//设置实体扫描路径--可传多个路径
		factory.setPackagesToScan("com.nico.web.hibernate.entity","com.nico.web.hibernate.entity2");
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");// 命名策略
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		return factory.getObject();

	}

}