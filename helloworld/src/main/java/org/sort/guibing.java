package org.sort;

import java.util.ArrayList;

/**
 * 归并排序
 * @author wangchangzhen
 */
public class guibing {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        mergeSort(list, 0, list.size() - 1);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
    public static void mergeSort(ArrayList<Integer> list, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }
    public static void merge (ArrayList<Integer> list, int left, int mid, int right) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (list.get(i) <= list.get(j)) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }
        while (i <= mid) {
            temp.add(list.get(i));
            i++;
        }
        while (j <= right) {
            temp.add(list.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }
}
