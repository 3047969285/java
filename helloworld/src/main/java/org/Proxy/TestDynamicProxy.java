package org.Proxy;

import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public static void main(String[] args) {
        System.out.println("=== 测试动态代理 ===");
        
        // 创建真实对象
        BigStar bigStar = new BigStar();
        
        // 创建代理对象
        Base proxy = ProxyUtil.createProxy(bigStar);
        
        // 通过代理调用方法
        System.out.println("通过代理唱歌:");
        String songResult = proxy.sing("Let it go");
        System.out.println("歌曲结果: " + songResult);
        
        System.out.println("\n通过代理跳舞:");
        proxy.dance();
    }
}