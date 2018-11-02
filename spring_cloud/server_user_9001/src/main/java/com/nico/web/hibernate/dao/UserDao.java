package com.nico.web.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nico.web.hibernate.entity.User;

public interface  UserDao extends BaseJpaDao<User, Long> {
	//查询用户名称包含username字符串的用户对象-
    List<User> findByUsernameContaining(String username);

    //获得单个用户对象，根据username和pwd的字段匹配
    User getByUsernameIsAndUserpwdIs(String username,String pwd);

    //精确匹配username的用户对象
    User getByUsernameIs(String username);
    
    //上面的JPA自动根据find  get  匹配关键字和后面的条件进行查询，以官方规则为准
    //下面的是手动注入SQL查询
    @Query("select w from User w where w.loginName = :loginName")
    User searchUserWeibo(@Param("loginName") String loginName);
    
    @Modifying
    @Transactional(readOnly = false)
    @Query("update User w set w.loginName = :loginName where w = :user")
    int  setUserById(@Param("loginName") String loginName,@Param("user")User user);
    
}
