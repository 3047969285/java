package org.webscoket;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SystemMessageSender {
    public static void main(String[] args) {
        System.out.println("系统消息发送器");
        System.out.println("输入用户名和消息，格式: username:消息内容 (例如: john:你好)");
        System.out.println("输入 'quit' 退出");
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while (!(input = reader.readLine()).equals("quit")) {
                if (input.contains(":")) {
                    String[] parts = input.split(":", 2);
                    String username = parts[0].trim();
                    String message = parts[1].trim();
                    EchoServer.sendSystemMessage(username, message);
                    System.out.println("已向用户 " + username + " 发送消息: " + message);
                } else {
                    System.out.println("格式错误，请使用 username:消息内容 的格式");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}