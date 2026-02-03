package org.arr_grammer;

import java.util.ArrayList;
import java.util.Random;

public class ArrayList_add {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<6;i++){
            int r=random.nextInt(33)+1;
            list.add(r);
        }
        for(int i=0;i<list.size();i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }
}
