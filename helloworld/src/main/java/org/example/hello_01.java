package org.example;

public class hello_01 {
    public static void main(String[] args) {
        byte b1=10;
        byte b2=20;
        byte b3= (byte) (b1+b2);
        short s1=1000;
        short s2=2000;
        short s3= (short) (s1+s2);
        char c1='a';
        int i1=30;
        int ch3=c1+i1;
        System.out.println("byte类型b1和b2的和为："+"\n"+b3);
        System.out.println("short类型s1和s2的和为："+"\n"+s3);
        System.out.println("char类型c1和int类型i1的和为："+"\n"+ch3);
    }
}
