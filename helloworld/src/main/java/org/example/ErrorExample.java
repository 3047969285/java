package org.example;

public class ErrorExample {
    public static void main(String[] args) {
        // 尝试调用非静态方法会报错
        // printMessage(); // 这行会报错
        
        // 正确的做法：创建对象实例来调用非静态方法
        ErrorExample example = new ErrorExample();
        example.printMessage();
    }
    
    // 非静态方法
    public void printMessage() {
        System.out.println("这是一个非静态方法");
    }
}