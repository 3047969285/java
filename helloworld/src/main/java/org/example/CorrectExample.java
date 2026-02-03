package org.example;

public class CorrectExample {
    public static void main(String[] args) {
        // 调用静态方法 - 直接通过类名调用
        printStaticMessage();
        
        // 调用非静态方法 - 需要先创建对象实例
        CorrectExample example = new CorrectExample();
        example.printInstanceMessage();
        
        // 或者直接创建并调用
        new CorrectExample().printInstanceMessage();
    }
    
    // 静态方法
    public static void printStaticMessage() {
        System.out.println("这是一个静态方法");
    }
    
    // 非静态方法
    public void printInstanceMessage() {
        System.out.println("这是一个非静态方法");
    }
}