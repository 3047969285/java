package org.arr_grammer;

import java.util.ArrayList;

public class ArrayList_String {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("Java");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.size());
        System.out.println("remove:"+list.remove(0));
        System.out.println(list);

    }
}
