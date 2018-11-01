package spring_cloud_config.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_cloud_config.config.Children;
import spring_cloud_config.config.Father;
import spring_cloud_config.config.MyLog;

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
    
    
    @MyLog(name="我是测试11",desc="我是测试详情11")
    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public String index1(@RequestParam("name") String name) {
    	if(StringUtils.isEmpty(name))
    		return children.getName();
        return father.getName();
    }
    
}