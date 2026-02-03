package yufa;

import java.math.BigDecimal;
import java.util.Scanner;

public class yufa003 {
    public static void main(String[] args) {


        int a,b;
        int choice; // 用于存储用户的选择
        BigDecimal cc;
        cc = new BigDecimal("0.0");
        Scanner sc = new Scanner(System.in);

        float x = sc.nextFloat();
        Double c = sc.nextDouble();
        String d = sc.next();
        char e = sc.next().charAt(0);
        long f = sc.nextLong();
        short g = sc.nextShort();
        byte h = sc.nextByte();
        boolean i = sc.nextBoolean();
        int j = sc.nextInt();
       int aff =100;
       byte bbb=( byte) aff;

        while (true) {
            System.out.println("请输入两个数字：");
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println("请选择运算类型：1.加法 2.减法 3.乘法 4.除法 5.退出");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(a + " + " + b + " = " + (a + b));
                    break;
                case 2:
                    System.out.println(a + " - " + b + " = " + (a - b));
                    break;
                case 3:
                    System.out.println(a + " * " + b + " = " + (a * b));
                    break;
                case 4:
                    System.out.println(a + " / " + b + " = " + (a / b));
                    break;
                case 5:
                    System.out.println("退出程序");
                    break;
            }
        }
    }
}