package org.example;

public class hello_10 {
    public static void main(String[] args) {
        int a=10,b=5;
        add(a,b);
        sub(a,b);
        mul(a,b);
        div(a,b);
        remain(a,b);
    }
    public static void add(int a,int b){
        int sum=a+b;
        System.out.println("a+b的值为："+sum);
    }
    public static void sub(int a,int b){
        int sub=a-b;
        System.out.println("a-b的值为："+sub);
    }
    public static void mul(int a,int b){
        int mul=a*b;
        System.out.println("a*b的值为："+mul);
    }
    public static void div(int a,int b){
        int div=a/b;
        System.out.println("a/b的值为："+div);
    }
    public static void remain(int a,int b){
        int remain=a%b;
        System.out.println("a%b的值为："+remain);
    }
}
