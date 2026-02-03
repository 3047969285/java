package yufa;

public class yufa006 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 3, 2, 1};
        System.out.println(isPalindrome(a) ? "是回文数" : "不是回文数");
    }

    /**
     * 检查数组是否为回文序列
     * @param arr 待检查的数组
     * @return 如果是回文返回true，否则返回false
     */
    public static boolean isPalindrome(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true; // 空数组或单元素数组视为回文
        }
        
        int left = 0;
        int right = arr.length - 1;
        
        // 只需检查到中间位置即可
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}