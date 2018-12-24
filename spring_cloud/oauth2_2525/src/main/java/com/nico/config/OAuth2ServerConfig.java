package com.nico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 配置资源服务器和授权服务器
 * @Title: 
 * @Package com.nico.config  
 * @Description: 
 * @author fangshu  
 * @date 2018年12月20日  
 * @version
 */
@Configuration
public class OAuth2ServerConfig {

    private static final String DEMO_RESOURCE_ID = "order";
    /**
     * 资源服务器
     * @Title: 
     * @Package com.nico.config  
     * @Description: 
     * @author fangshu  
     * @date 2018年12月20日  
     * @version
     */
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    	
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
            // 如果关闭 stateless，则 accessToken 使用时的 session id 会被记录，后续请求不携带 accessToken 也可以正常响应
//          resources.resourceId(DEMO_RESOURCE_ID).stateless(false);
        }
        
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    // Since we want the protected resources to be accessible in the UI as well we need
                    // session creation to be allowed (it's disabled by default in 2.0.6)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
//                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
                    .antMatchers("/order/**").authenticated();//配置order访问控制，必须认证过后才可以访问
            		
        }
    }

    
    /**
     * 授权服务器
     * @Title: 
     * @Package com.nico.config  
     * @Description: 
     * @author fangshu  
     * @date 2018年12月20日  
     * @version
     */
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        RedisConnectionFactory redisConnectionFactory;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            //配置两个客户端,一个用于password认证一个用于client认证
        	//使用JDBC模式
        	//clients.jdbc(null)
        	//使用内存模式
            clients.inMemory()
            		//客户端1
            		//client_id
            		.withClient("client_1")
                    .resourceIds(DEMO_RESOURCE_ID)
                    //客户端模式（client credentials） 认证
                    //client模式，没有用户的概念，直接与认证服务器交互，
                    //用配置中的客户端信息去申请accessToken，
                    //客户端有自己的client_id,client_secret对应于用户的username,password，
                    //而客户端也拥有自己的authorities，
                    //当采取client模式认证时，对应的权限也就是客户端自己的authorities。
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    //作用域-对应增删查改
                    .scopes("select")
                    //客户端权限名称
                    .authorities("client")
                    //client_secret
                    .secret("123456")
                    //客户端2
                    .and().withClient("client_2")
                    .resourceIds(DEMO_RESOURCE_ID)
                    //密码模式（resource owner password credentials） 认证
                    //password模式，自己本身有一套用户体系，在认证时需要带上自己的用户名和密码，
                    //以及客户端的client_id,client_secret。
                    //此时，accessToken所包含的权限是用户本身的权限，而不是客户端的权限。
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .secret("123456");
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        	//设置访问方式GET POST均可，默认POST
        	endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);// add get method
        	//设置token和相关信息存储到对应的实现类
        	endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
        	//设置认证管理器
                    .authenticationManager(authenticationManager);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            //允许表单认证
            oauthServer.allowFormAuthenticationForClients();
            //oauthServer.realm(DEMO_RESOURCE_ID).allowFormAuthenticationForClients();
        }

    }

}