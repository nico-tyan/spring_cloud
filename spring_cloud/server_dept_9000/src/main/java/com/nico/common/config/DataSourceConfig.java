package com.nico.common.config;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;


@Configuration
public class DataSourceConfig {

    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${spring.datasource.url}")  
    private String dbUrl;  
    @Value("${spring.datasource.username}")  
    private String username;  
    @Value("${spring.datasource.password}")  
    private String password;  
    @Value("${spring.datasource.driver-class-name}")  
    private String driverClassName;  
    @Value("${spring.datasource.initialSize}")  
    private int initialSize;  
    @Value("${spring.datasource.minIdle}")  
    private int minIdle;  
    @Value("${spring.datasource.maxActive}")  
    private int maxActive;  
    @Value("${spring.datasource.maxWait}")  
    private int maxWait;  
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")  
    private int timeBetweenEvictionRunsMillis;  
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")  
    private int minEvictableIdleTimeMillis;  
    @Value("${spring.datasource.validationQuery}")  
    private String validationQuery;  
    @Value("${spring.datasource.testWhileIdle}")  
    private boolean testWhileIdle;  
    @Value("${spring.datasource.testOnBorrow}")  
    private boolean testOnBorrow;  
    @Value("${spring.datasource.testOnReturn}")  
    private boolean testOnReturn;  
    @Value("${spring.datasource.poolPreparedStatements}")  
    private boolean poolPreparedStatements;  
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")  
    private int maxPoolPreparedStatementPerConnectionSize;  
    @Value("${spring.datasource.filters}")  
    private String filters;  
    @Value("${spring.datasource.connectionProperties}")  
    private String connectionProperties;  
    @Value("${spring.datasource.useGlobalDataSourceStat}")  
    private boolean useGlobalDataSourceStat;  
  
    @Bean(name = "mysqlDS")  //声明其为Bean实例  
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource  
    public DataSource dataSource(){  
        DruidDataSource datasource = new DruidDataSource();  
        datasource.setUrl(this.dbUrl);  
        datasource.setUsername(username);  
        datasource.setPassword(password);  
        datasource.setDriverClassName(driverClassName);  
  
        //configuration  
        datasource.setInitialSize(initialSize);  
        datasource.setMinIdle(minIdle);  
        datasource.setMaxActive(maxActive);  
        datasource.setMaxWait(maxWait);  
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);  
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);  
        datasource.setValidationQuery(validationQuery);  
        datasource.setTestWhileIdle(testWhileIdle);  
        datasource.setTestOnBorrow(testOnBorrow);  
        datasource.setTestOnReturn(testOnReturn);  
        datasource.setPoolPreparedStatements(poolPreparedStatements);  
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);  
        datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);  
        try {  
            datasource.setFilters(filters);  
        } catch (SQLException e) {  
            System.err.println("druid configuration initialization filter: "+ e);  
        }  
        datasource.setConnectionProperties(connectionProperties);  
        return datasource;  
    }  

    /**
     * 静态资源过滤
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean fr = new FilterRegistrationBean();
        fr.setFilter(new WebStatFilter());
        fr.addUrlPatterns("/*");
        fr.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return fr;
    }

    /**
     * 数据源监控
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean();
        registration.setServlet(new StatViewServlet());
        registration.setName("druidMonitor");
        List<String> list=new ArrayList<String>();
        list.add("/druid/*");
        registration.setUrlMappings(list);
        //自定义添加初始化参数
        Map<String, String> intParams = new HashMap<String, String>();
        intParams.put("loginUsername","nico");
        intParams.put("loginPassword","nico");
        registration.setName("DruidWebStatFilter");
        registration.setInitParameters(intParams);
        return registration;
    }

}
