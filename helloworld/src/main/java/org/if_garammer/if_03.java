package org.if_garammer;

public class if_03 {
    public static void main(String[] args) {
        int a=10,b=20,c=30;
        method1();
        method2();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    public static void method1(){
        int a=-5;
        int b=--a;
        if(a%2==0)
        {
            a=++b;
        }
        else {
            b=--a;
        }
        System.out.println(a);
        System.out.println(b);
    }
    public static void method2(){
        int a=0;
        while(a<=5)
        {
            for(int  b=1;b<=5;b++)
            {
                System.out.print(b+" ");
            }
            System.out.println("\n");
            a++;
        }
    }
}
