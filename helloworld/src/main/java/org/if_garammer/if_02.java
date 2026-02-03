package org.if_garammer;

public class if_02 {
    public static void main(String[] args) {
        int r=10;
            for(r=r;r>0;)
            {
                int c;
                 c=r;
                while(c>=0)
                {
                    System.out.print(c+" ");
                    c-=2;
                }
                r=r/c;
            }

    }
}
