package org.if_garammer;

public class if_07 {
    public static void main(String[] args) {
        int count=0;
        double length=0.0001;
        while(length<8848)
        {
            length*=2;
            count++;
        }
        System.out.println("count的值："+count);
        System.out.println("length的值："+length);
    }
}
