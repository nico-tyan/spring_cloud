package com.nico.ctl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nico.config.MyLog;
import com.nico.test.Children;
import com.nico.test.Father;

/**
 * @author sam
 * @since 2017/7/13
 */
@RestController
public class IndexController {

	@Autowired
	public Children children; 
	@Autowired
	public Father father; 
	
	
    @MyLog(name="我是测试",desc="我是测试详情")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(String name) {
    	if(name!=null)
    		return name;
        return "inde11112222x";
    }
    
    /**
     * 测试AOP替换参数
     * @Title: 
     * @Description: 
     * @date 2018年11月2日  
     * @param name
     * @return        
     * @throws
     */
    @MyLog(name="我是测试11",desc="我是测试详情11")
    @RequestMapping(value = "/index1/{name}",method = RequestMethod.GET)
    public String index1(@PathVariable("name") String name) {
    	if(name.length()>5)
    		return children.getValue();
        return father.getValue();
    }
    
}