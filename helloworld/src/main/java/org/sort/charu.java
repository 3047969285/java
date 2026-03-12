package org.sort;
/**
 * 插入排序
 * @author wangchangzhen
 */

public class charu {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};
        insertSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
