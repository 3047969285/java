package org.example;

public class hello_03 {
    public static void main(String[] args) {
        char ch='J';
        char lowerCh = (char)(ch + 32);

        char ch2='a';
        char upperCh = (char)(ch2 - 32);
        double d3=352523.34;

        int i3=34243;
        double sum3;
        sum3=d3+i3;
        
        // 输出sum3的整数部分


        double d4=24142.5334;
        int i4=34234;
        int mul4=i4*i4;

        System.out.println(lowerCh);
        System.out.println(upperCh);
        System.out.println(sum3);
        System.out.println("sum3的整数部分的值: " + (int)sum3);
        System.out.println(mul4);
    }
}