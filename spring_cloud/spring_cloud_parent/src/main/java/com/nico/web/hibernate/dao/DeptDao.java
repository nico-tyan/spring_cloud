package com.nico.web.hibernate.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nico.web.hibernate.entity.Dept;

public interface  DeptDao extends BaseJpaDao<Dept, Long> {
	//查询用户名称包含username字符串的用户对象-
    List<Dept> findByDeptNameContaining(String deptName);

    //获得单个用户对象，根据username和pwd的字段匹配
    Dept getByDeptNameIsAndDeptNoIs(String deptName,String deptNo);

    //精确匹配username的用户对象
    Dept getByDeptNameIs(String deptName);
    
    //上面的JPA自动根据find  get  匹配关键字和后面的条件进行查询，以官方规则为准
    //下面的是手动注入SQL查询
    @Query("select w from Dept w where w.deptName = :deptName")
    User searchUserWeibo(@Param("deptName") String deptName);
    
    @Modifying
    @Transactional(readOnly = false)
    @Query("update Dept w set w.deptName = :deptName where w.deptId = :deptId")
    int  setDeptById(@Param("deptId") Long deptId,@Param("deptName")String deptName);
    
}
