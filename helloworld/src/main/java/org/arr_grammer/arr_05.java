package org.arr_grammer;

public class arr_05 {
    public static void main(String[] args) {

        String[] huase = {"♠", "♥", "♣", "♦"};
        String[] dianshu = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        String [] pokers = new String[huase.length * dianshu.length];
        int count = 0;
        for(int i=0;i< huase.length;i++)
        {
            for(int j=0;j< dianshu.length;j++)
            {
                pokers[count++]=huase[i]+dianshu[j];
            }
        }
        for(int i=0;i< pokers.length;i++)
        {
            System.out.print(pokers[i]+" ");
            // 每行打印13张牌
            if((i+1)%13==0)
            {
                System.out.println();
            }
        }
    }
}