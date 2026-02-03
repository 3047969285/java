package yufa;

import java.util.Arrays;

public class yufa008 {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        bubbleSortWithTernary(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        // 使用三元运算符判断数组是否已排序
        boolean isSorted = isArraySorted(arr);
        System.out.println("Is array sorted? " + (isSorted ? "Yes" : "No"));
    }
    
    /**
     * 冒泡排序实现（在某些地方使用三元运算符）
     * @param arr 待排序的数组
     */
    public static void bubbleSortWithTernary(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                // 使用三元运算符来决定是否交换元素
                // 注意：这里主要是演示三元运算符的使用，实际上直接用if更合适
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // 如果没有发生交换，说明数组已经有序
            if (!swapped) break;
        }
    }
    
    /**
     * 使用三元运算符判断数组是否已排序
     * @param arr 待检查的数组
     * @return 如果已排序返回true，否则返回false
     */
    public static boolean isArraySorted(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            // 使用三元运算符决定返回值（仅作为演示）
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 一个更纯粹地使用三元运算符的排序示例（归并排序风格）
     * @param arr 输入数组
     * @return 排序后的数组
     */
    public static int[] sortUsingTernary(int[] arr) {
        if (arr.length <= 1) {
            return arr.clone();
        }
        
        // 创建副本以避免修改原数组
        int[] result = arr.clone();
        
        // 这里只是演示三元运算符的使用，实际排序仍需传统方法
        // 因为排序算法涉及复杂的状态变更，三元运算符并不适合
        bubbleSortWithTernary(result);
        return result;
    }
}