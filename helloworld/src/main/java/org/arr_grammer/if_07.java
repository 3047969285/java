package org.arr_grammer;

public class if_07 {
    public static void main(String[] args) {
        int[]arr = {'a','i','f','m','o','b','b','s','n'};
        printCount( arr);
    }
    public static void printCount(int[] arr){
        int[] count = new int[26];
        for(int i:arr){
            count[i-'a']++;
        }
        for(int i=0;i<26;i++){
            if(count[i]>0){
                System.out.println((char)(i+'a')+":--"+count[i]);
            }
        }
    }

}
