package com.nico.web.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nico.web.mybatis.entity.SysUser;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2018-06-22
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
	List<Map> selectAll();
}
