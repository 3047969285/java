package org.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        // 创建代理对象
        Proxy proxy = new Proxy();
        
        // 通过代理唱歌
        String result = proxy.sing("蔡徐坤");
        System.out.println("表演结果: " + result);
        
        System.out.println("-------------------");
        
        // 通过代理跳舞
        proxy.dance();
        System.out.println("表演结束");
    }
}