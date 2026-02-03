package org.example;

public class hello_02 {
    public static void main(String[] args) {
        int i1 = 100;
        long l1=200;
        long add;

        long l2=300;
        float f2=0.44f;
        float add2;

        int i3=1000000;
        double d3=0.45;
        double add3;

        float f4=1000000000.0f;
        double d4 = 1.2625;
        double add4;
        add=i1+l1;
        add2=i1+f2;
        add3=i3+d3;
        add4=i3+d4;
        System.out.println("add的值为：\n"+ add);
        System.out.println("add2的为：\n"+ add2);
        System.out.println("add3的为：\n"+ add3);
        System.out.println("add4的为：\n"+ add4);
    }
}
