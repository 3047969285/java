package org.webscoket;

import javax.websocket.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import com.fasterxml.jackson.databind.ObjectMapper;

@ClientEndpoint
public class WebSocketClient {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("已连接到服务器。Session ID: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message) {
        try {
            // 尝试解析为Message对象
            Message receivedMsg = objectMapper.readValue(message, Message.class);
            System.out.println("[" + receivedMsg.getType() + "] " + receivedMsg.getSender() + ": " + receivedMsg.getContent());
        } catch (Exception e) {
            // 如果不是JSON格式，按普通文本处理
            System.out.println("服务器回复: " + message);
        }
    }

    @OnClose
    public void onClose() {
        System.out.println("与服务器的连接已关闭");
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println("连接发生错误: " + t.getMessage());
        t.printStackTrace();
    }

    public static void main(String[] args) {
        try {
            System.out.println("请输入用户名:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String username = reader.readLine();
            
            // 创建WebSocket容器
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            
            // 连接到WebSocket服务器，使用新的端口号8081和用户名路径参数
            WebSocketClient client = new WebSocketClient();
            Session session = container.connectToServer(client, 
                    URI.create("ws://localhost:8081/websockets/echo/" + username));
            
            System.out.println("已连接到WebSocket服务器，用户名: " + username);
            System.out.println("命令:");
            System.out.println("  send <消息> - 发送普通消息");
            System.out.println("  click - 模拟按钮点击");
            System.out.println("  private <用户名> <消息> - 发送私信");
            System.out.println("  quit - 退出");
            
            String input;
            while (!(input = reader.readLine()).equals("quit")) {
                if (input.startsWith("send ")) {
                    String message = input.substring(5);
                    session.getBasicRemote().sendText(message);
                } else if (input.equals("click")) {
                    // 发送按钮点击事件
                    Message buttonMsg = new Message("button_click", "按钮被点击了", "system", username);
                    session.getBasicRemote().sendText(objectMapper.writeValueAsString(buttonMsg));
                } else if (input.startsWith("private ")) {
                    String[] parts = input.split(" ", 3);
                    if (parts.length >= 3) {
                        String recipient = parts[1];
                        String content = parts[2];
                        Message privateMsg = new Message("private", content, recipient, username);
                        session.getBasicRemote().sendText(objectMapper.writeValueAsString(privateMsg));
                    } else {
                        System.out.println("格式错误，应为: private <用户名> <消息>");
                    }
                }
            }
            
            // 关闭会话
            session.close();
            System.out.println("客户端已断开连接");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}