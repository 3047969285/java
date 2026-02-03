package org.if_garammer;

import java.util.Scanner;

public class if_08 {
    public static void main(String[] args) {
        System.out.println("请输入1-12的数字：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch (n)
            {
            case 1:
                System.out.println("1:水瓶");
                break;
            case 2:
                System.out.println("2:双鱼");
                break;
            case 3:
                System.out.println("3:白羊");
                break;
            case 4:
                System.out.println("4:金牛");
                break;
            case 5:
                System.out.println("5:双子");
                break;
            case 6:
                System.out.println("6:巨蟹");
                break;
            case 7:
                System.out.println("7:狮子");
                break;
            case 8:
                System.out.println("8:处女");
                break;
            case 9:
                System.out.println("9:天秤");
                break;
            case 10:
                System.out.println("10:天蝎");
                break;
            case 11:
                System.out.println("11:射手");
                break;
            case 12:
                System.out.println("12:摩羯");
                break;
            default:
                System.out.println("输入错误");
            }
    }
}
