package spring_cloud_config;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class AopProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object source, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
		StringBuilder sb=new StringBuilder();
		Object result = null;
		
		long start = System.currentTimeMillis();
        boolean hasError = false;
        try {
            sb.append("thread[" + Thread.currentThread().getId() + "] " + method.getName() + " =>args:");
            if (params!=null) {
            	int i=0;
                for (Object param:params) {
                    sb.append("[" + i + "]" + params[i].toString() + ",");
                    i++;
                }
            } else {
                sb.append(" ");
            }
            result = methodProxy.invokeSuper(source, params);
            sb.append(" result:" + result);
        } catch (Exception e) {
            sb.append(", error:" + e.getMessage());
            hasError = true;
        } finally {
            long execTime = System.currentTimeMillis() - start;
            sb.append(", execTime:" + execTime + " ms");
        }
        System.out.println(sb.toString());
        return result;
	}
	
	public static void main(String[] args) {
		
		
	}

}
