package org.webscoket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

@ServerEndpoint("/echo/{username}")
public class EchoServer {
    // 存储所有连接的会话
    private static Map<String, Session> sessions = new ConcurrentHashMap<>();
    private static ObjectMapper objectMapper = new ObjectMapper();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        System.out.println("WebSocket 连接已经建立。用户: " + username + ", Session ID: " + session.getId());
        sessions.put(username, session);
        
        // 发送欢迎消息
        try {
            Message welcomeMsg = new Message("system", "欢迎连接到服务器，" + username + "!", username, "System");
            session.getBasicRemote().sendText(objectMapper.writeValueAsString(welcomeMsg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("username") String username) throws IOException {
        System.out.println("收到客户端 " + username + " 消息：" + message);
        
        try {
            // 尝试解析为Message对象
            Message receivedMsg = objectMapper.readValue(message, Message.class);
            
            if ("button_click".equals(receivedMsg.getType())) {
                // 处理按钮点击事件
                System.out.println("用户 " + username + " 点击了按钮: " + receivedMsg.getContent());
                
                // 发送确认消息给用户
                Message response = new Message("button_response", "系统已收到您的按钮点击: " + receivedMsg.getContent(), username, "System");
                session.getBasicRemote().sendText(objectMapper.writeValueAsString(response));
                
                // 可以在这里添加更多业务逻辑，比如通知管理员等
            } else if ("private".equals(receivedMsg.getType())) {
                // 处理私信
                String recipient = receivedMsg.getRecipient();
                Session recipientSession = sessions.get(recipient);
                if (recipientSession != null && recipientSession.isOpen()) {
                    Message privateMsg = new Message("private", receivedMsg.getContent(), recipient, username);
                    recipientSession.getBasicRemote().sendText(objectMapper.writeValueAsString(privateMsg));
                } else {
                    // 发送失败通知给发送者
                    Message errorMsg = new Message("error", "用户 " + recipient + " 不在线", username, "System");
                    session.getBasicRemote().sendText(objectMapper.writeValueAsString(errorMsg));
                }
            }
        } catch (Exception e) {
            // 如果不是JSON格式的消息，就当作普通文本处理
            session.getBasicRemote().sendText("服务器收到消息：" + message);
        }
    }

    @OnClose
    public void onClose(@PathParam("username") String username) {
        System.out.println("WebSocket 连接已经关闭。用户: " + username);
        sessions.remove(username);
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println("WebSocket 连接出现错误：" + t.getMessage());
        t.printStackTrace();
    }
    
    // 系统向特定用户发送消息的方法
    public static void sendSystemMessage(String username, String content) {
        Session session = sessions.get(username);
        if (session != null && session.isOpen()) {
            try {
                Message message = new Message("system", content, username, "System");
                session.getBasicRemote().sendText(objectMapper.writeValueAsString(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // 获取当前在线用户列表
    public static String getOnlineUsers() {
        return sessions.keySet().toString();
    }
}