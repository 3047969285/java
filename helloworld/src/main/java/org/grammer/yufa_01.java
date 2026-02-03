package org.grammer;

public class yufa_01 {
    public static void main(String[] args) {
        int a=10;
        int b=10;
        printNum(a,b);
        doubling(a,b);
        printNum(a,b);
         a= doubling(a);
         b= doubling(b);
         printNum(a,b);
    }
    public static void printNum(int iVar, int iVar2){
        System.out.println("iVar:"+ iVar+ " iVar2:"+ iVar2);
    }
    public static void doubling(int r,int p){
        r=r*2;
        p=p*2;
        System.out.println("r:"+ r+ " p:"+ p);
    }
    public static int doubling (int r){
        r=r*2;
        System.out.println("r:"+ r);
        return r;
    }
}
