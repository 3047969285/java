package org.example;

public class hello_04 {
    public static void main(String[] args) {
        // 1.分别判断10,11是否为偶数
        int a1,a2;
        a1=10;
        a2=11;
        if(a1%2==0)
            System.out.println(a1+"是偶数?true");
        else
            System.out.println(a1+"是偶数?false");
        if(a2%2==0)
            System.out.println(a2+"是偶数?true");
        else
            System.out.println(a2+"是偶数?false");
            
        // 2.分别判断12,13是否为奇数
        int b1,b2;
        b1=12;
        b2=13;
        if(b1%2!=0)
            System.out.println(b1+"是奇数?true");
        else
            System.out.println(b1+"是奇数?false");
        if(b2%2!=0)
            System.out.println(b2+"是奇数?true");
        else
            System.out.println(b2+"是奇数?false");
    }
}