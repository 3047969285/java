package org.webscoket;

import org.glassfish.tyrus.server.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebSocketServer {
    public static void main(String[] args) {
        // 创建WebSocket服务器实例，使用8081端口避免冲突
        Server server = new Server("localhost", 8081, "/websockets", null, EchoServer.class);

        try {
            // 启动服务器
            server.start();
            System.out.println("WebSocket服务器已启动，监听端口: 8081");
            System.out.println("WebSocket地址: ws://localhost:8081/websockets/echo/{username}");
            System.out.println("按回车键停止服务器...");

            // 启动一个线程来处理系统消息发送
            Thread systemMessageThread = new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String input;
                    System.out.println("输入用户名和消息，格式: username:消息内容 (例如: john:你好)");
                    while ((input = reader.readLine()) != null) {
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
            });
            systemMessageThread.setDaemon(true);
            systemMessageThread.start();

            // 等待用户输入以停止服务器
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 停止服务器
            server.stop();
            System.out.println("WebSocket服务器已停止");
        }
    }
}