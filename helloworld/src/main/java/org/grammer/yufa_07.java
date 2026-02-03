package org.grammer;

import java.util.Scanner;

public class yufa_07 {
    public static void main(String[] args) {
        System.out.println("请输入摄氏度：");
        Scanner sc =new Scanner(System.in);
        double c=sc.nextDouble();
        System.out.println("摄氏度为："+c+"°C"+"--华氏度为："+temperature(c)+"°F");
        System.out.println("华氏度为："+temperature(c)+"°F"+"--摄氏度为："+c+"°C");

    }
    public static double temperature(double c){
        double f = c * 1.8 + 32;
        return f;
    }
}