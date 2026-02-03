package org.arr_grammer;

public class arr_02 {
    public static void main(String[] args) {
        int[] arr={95,92,75,56,98,71,80,58,91,91};
        int ave=average(arr);
        int count=0;
        System.out.println("The average of the array is: "+ave);
        for(int j:arr)
        {
            if(j>ave)
                count++;
        }
        System.out.println("The number of elements greater than the average is: "+count);
    }
    public static int average(int[] arr){
        int sum=0;
        for(int i:arr)
        {
            sum+=i;
        }
        return sum/arr.length;
    }
}
