package com.nico.config;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author sam
 * @since 2017/7/13
 */
@Aspect //AOP 切面
@Component
public class MyLogAspect {


    //切入点
    @Pointcut(value = "@annotation(com.nico.config.MyLog)")
    private void pointcut() {
    	
    }


    /**
     * 在方法执行前后
     *
     * @param point
     * @param myLog
     * @return
     */
    @Around(value = "pointcut() && @annotation(myLog)")
    public Object around(ProceedingJoinPoint point, MyLog myLog) {
        System.out.println("++++执行了around方法++++");
        try {
			Object proceed1 = point.proceed();
			System.out.println("++++替换参数为test++++");
			Object proceed2 = point.proceed(new Object[]{"test"});
			
			System.out.println(proceed1);
			System.out.println(proceed2);
		} catch (Throwable e) {
			e.printStackTrace();
		}
        
        String name = myLog.name();

        Object this1 = point.getThis();//获取代理类本身
        Object target = point.getTarget();//获取被代理类本身
        //拦截的类名
        Class clazz = point.getTarget().getClass();
        
        //拦截的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();

        System.out.println("执行了 类:" + clazz + " 方法:" + method + " 名称:" + name + " 备注:"+myLog.desc());

        try {
            return point.proceed(); //执行程序
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return throwable.getMessage();
        }
    }

    /**
     * 方法执行后
     *
     * @param joinPoint
     * @param myLog
     * @param result
     * @return
     */
    @AfterReturning(value = "pointcut() && @annotation(myLog)", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, MyLog myLog, Object result) {

//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();

        System.out.println("++++执行了afterReturning方法++++");

        System.out.println("执行结果：" + result);

        return result;
    }

    /**
     * 方法执行后 并抛出异常
     *
     * @param joinPoint
     * @param myLog
     * @param ex
     */
    @AfterThrowing(value = "pointcut() && @annotation(myLog)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, MyLog myLog, Exception ex) {
        System.out.println("++++执行了afterThrowing方法++++");
        System.out.println("请求：" + myLog.name() + " 出现异常");
    }

}