package org.grammer;

public class yufa_06 {
    public static void main(String[] args) {
       int a=round(2.9);
       System.out.println(a);
    }
    public static int round(double a)
    {
        double b=a+0.5;
        return (int)b;
    }
}
