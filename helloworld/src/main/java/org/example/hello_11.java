package org.example;

public class hello_11 {
    public static void main(String[] args) {
        // 定义两个数组分别存储花色和点数
        String[] suits = {"♠", "♥", "♣", "♦"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        
        // 创建扑克牌数组
        String[] poker = new String[suits.length * ranks.length];
        
        // 使用计数器
        int count = 0;
        
        // 使用嵌套for循环拼接字符串效果，保存到扑克牌数组中
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                poker[count++] = suits[i] + ranks[j];
            }
        }
        
        // 遍历扑克牌数组，打印全部内容
        for (int i = 0; i < poker.length; i++) {
            System.out.print(poker[i] + " ");
            // 每13张牌换一行
            if ((i + 1) % 13 == 0) {
                System.out.println();
            }
        }
    }
}