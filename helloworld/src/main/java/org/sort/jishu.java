package org.sort;

import java.util.ArrayList;

/**
 * 计数排序
 * @author wangchangzhen
 */
public class jishu {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(3);
        list.add(8);
        list.add(6);
        list.add(7);
        list.add(2);
        list.add(9);
        list.add(4);
        list.add(1);
        list.add(0);
        list.add(5);
        list.add(8);
        countSort(list);

    }
    public static void countSort(ArrayList<Integer> list) {
        // 获取最大值
        int max = list.get(0);

        for (int i = 0 ; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        int [] count = new int[max+1];
        for (int i = 0 ; i < list.size(); i++) {
            count[list.get(i)]++;
        }

        for (int i = 0 ; i <= max; i++) {
            for(int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
