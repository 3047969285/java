package org.example;

public class hello_09 {
    public static void main(String[] args) {
        printNum();
    }
    public static void printNum(){
        String str=null;
        int num=3414421;
        str = (num%2==0 ? "偶数" : "奇数");
        System.out.println("num:"+ num+ "是"+ str);
    }
}