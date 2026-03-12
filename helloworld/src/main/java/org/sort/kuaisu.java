package org.sort;
/**
 * 快速排序
 * @author wangchangzhen
 */

public class kuaisu {
    public static void main(String[] args) {
        int[] arr = {4,2,5};
        quickSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] arr, int i, int i1) {
        if (i >= i1) {
            return;
        }
        int pivotIndex = partition(arr, i, i1);
        quickSort(arr, i, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, i1);
    }

    private static int partition(int[] arr, int i, int i1) {
        // 最左侧作为基准值
        int pivot = arr[i];
        // 左侧left
        int left = i;
        // 右侧为right
        int right = i1;

        // 操作数组，左边比基准值小，右边比基准值大
        while (left < right) {
            // 从左向右找比基准值大的元素
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 从右向左找比基准值小的元素
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 交换两个元素
            if (left < right) {
                swap(arr, left, right);
            }
        }
        // 将基准值放到中间位置
        swap(arr, i, left);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
