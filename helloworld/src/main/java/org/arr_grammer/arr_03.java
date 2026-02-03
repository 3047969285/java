package org.arr_grammer;

public class arr_03 {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,3,2,1};
        int[] arr2={1,2,3,4,5,2,1};
        boolean result1=sym(arr1);
        boolean result2=sym(arr2);
        System.out.print("[");
        for(int i=0; i<arr1.length; i++)
        {
            System.out.print(arr1[i]);
            if(i < arr1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]是否对称："+result1+"\n");
        System.out.print("[");
        for(int i=0; i<arr2.length; i++)
        {
            System.out.print(arr2[i]);
            if(i < arr2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]是否对称："+result2);
    }
    public static boolean sym(int[] arr){
        for(int start=0,end=arr.length-1;start<end;start++,end--)
        {
            if(arr[start]!=arr[end])
            {
                return false;
            }
        }
        return true;
    }
}