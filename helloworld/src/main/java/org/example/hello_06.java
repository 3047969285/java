package org.example;

public class hello_06 {
    public static void main(String[] args) {
        printNum();
    }
    public static void printNum() {
        int a=9;
        int b=9;
        int num=++a;
        boolean bo;
        bo=(num>=10 ? true : false);
        int num2=b++;
        boolean bo2;
        bo2=(num2>=10 ? true : false);
        System.out.println("bo的值"+ bo);
        System.out.println("bo2的值"+ bo2);
    }
}
