package org.grammer;

public class yufa_02 {
    public static void main(String[] args) {
        boolean o1 = doCheck(2);
        System.out.println(o1);
        boolean o2 = doCheck(3);
        System.out.println(o2);
    }
    public static boolean doCheck(int num) {
        boolean flag;
        if ( num % 2 == 0)
        {
           for(int i=0;i<=20;i++)
           {
               num-=i;

           }
           flag=true;
        }
        else {
            for(int i=0;i<=20;i++)
            {
                num+=i;
            }
            flag=false;
        }
        System.out.println("num="+ num);
        return flag;
    }
}
