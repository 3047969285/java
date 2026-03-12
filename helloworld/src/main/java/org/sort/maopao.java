package org.sort;
/**
 * 冒泡排序实现
 * @author wangchangzhen
 */

public class maopao {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};

        for(int i = 0 ;i<arr.length-1;i++) {
            for(int j =0 ;j<arr.length-1-i;j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }


}
