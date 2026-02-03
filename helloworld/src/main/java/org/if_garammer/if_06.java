package org.if_garammer;

public class if_06 {
    public static void main(String[] args) {
        boolean bVar=false, bVar1=true;
        int count=8;
        do {
            System.out.println("Hello Java!"+ count);
            if(count>=7)
            {
                bVar1=false;
                count--;
            }
            else
            {
                count+=3;
            }

        }while (bVar1==bVar&&count<9);
    }
}
