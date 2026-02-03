package org.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Base createProxy(BigStar bigStar) {
        return (Base) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Base.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 在调用真实方法前可以添加前置处理
                        System.out.println("代理收取费用...");
                        
                        // 调用真实对象的方法
                        Object result = method.invoke(bigStar, args);
                        
                        // 在调用真实方法后可以添加后置处理
                        System.out.println("表演完成，代理服务结束");
                        
                        return result;
                    }
                }
        );
    }
}