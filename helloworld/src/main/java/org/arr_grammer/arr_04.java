package org.arr_grammer;

public class arr_04 {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,3,2,1};
        int[] arr2={1,2,3,4,5,6,7,8,9,10};
        boolean result=equal(arr1,arr2);
        System.out.print("[");
        for(int i=0;i<arr1.length;i++)
        {
            System.out.print(i+" ");
            if(i < arr1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n[");
        for(int i=0;i<arr2.length;i++)
        {
            System.out.print(i+" ");
            if(i < arr2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n是否一致："+result);
    }
    public static boolean equal(int[] arr1, int[] arr2){
        for(int i=0,j=0;i<arr1.length&&j<arr2.length;j++,i++)
        {
            if(arr1[i]!=arr2[j])
            {
                return false;
            }

        }
        return true;
    }
}
