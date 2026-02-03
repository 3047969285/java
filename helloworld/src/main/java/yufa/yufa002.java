package yufa;

import java.util.Scanner;

public class yufa002 {
    public static void main(String[] args) {

       //找到Scanner这个语法
        System.out.println("请输入第一个数字：");
        Scanner sc = new Scanner(System.in);
        Double a = sc.nextDouble();
        System.out.println(a);

        System.out.println("请输入第二个数字：");
        Scanner sc1 = new Scanner(System.in);
        int  b = sc1.nextInt();
        System.out.println(b);

        System.out.println("请输入第三个数字：");
        Scanner sc2 = new Scanner(System.in);
        String c = sc2.next();
        System.out.println(c);

    }
}
