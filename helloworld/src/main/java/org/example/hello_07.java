package org.example;

public class hello_07 {
    public static void main(String[] args) {

        printNum();
    }
    public static void printNum(){
        float f1=12345.01f;
        float f2=12345.00f;
        float var1;
        var1=(f1>=f2 ? 123456  : 123456.02f);
        float var2;
        var2=var1+1024;
        System.out.println("var1的值为："+var1+"  var2的值为："+var2);

    }
}
