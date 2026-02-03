package org.netty;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * WebSocket聊天室服务器处理器
 */
public class WebSocketChatServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 用于保存所有连接的客户端通道
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    
    // 用于JSON序列化和反序列化
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    // 日期时间格式化器
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // 用于跟踪已处理的消息，避免重复处理
    private static final Set<String> processedMessages = new HashSet<>();

    /**
     * 当客户端连接到服务器时调用
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        channels.add(incoming);
        System.out.println("[SERVER] - " + incoming.remoteAddress() + " 连接到服务器");
    }

    /**
     * 当WebSocket握手完成时调用
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Channel incoming = ctx.channel();
        
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            // WebSocket握手完成
            System.out.println("[SERVER] - " + incoming.remoteAddress() + " WebSocket握手完成");
            
            // 发送欢迎消息给当前客户端
            ChatMessage welcomeMsg = new ChatMessage("欢迎连接到聊天室!", "System");
            welcomeMsg.setType("JOIN");
            incoming.writeAndFlush(new TextWebSocketFrame(objectMapper.writeValueAsString(welcomeMsg)));
            
            // 不再广播用户加入消息，避免前端显示重复消息
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    /**
     * 处理接收到的WebSocket文本消息
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        Channel incoming = ctx.channel();
        String request = msg.text();
        
        System.out.println("[" + incoming.remoteAddress() + "] " + request);
        
        // 检查消息是否已处理过，避免重复处理
        if (processedMessages.contains(request)) {
            return;
        }
        
        // 添加消息到已处理集合
        processedMessages.add(request);
        
        // 设置定时清理已处理消息，避免内存泄漏
        final String messageToRemove = request;
        new Thread(() -> {
            try {
                Thread.sleep(1000); // 1秒后移除
                processedMessages.remove(messageToRemove);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        
        try {
            // 解析客户端发送的JSON消息
            ChatMessage chatMessage = objectMapper.readValue(request, ChatMessage.class);
            
            // 对于事件消息，直接广播原始内容
            if ("EVENT".equals(chatMessage.getType())) {
                broadcastMessage(chatMessage.getContent());
                return;
            }
            
            // 创建带时间戳的消息
            ChatMessage responseMessage = new ChatMessage(
                chatMessage.getContent(), 
                incoming.remoteAddress().toString()
            );
            responseMessage.setTimestamp(System.currentTimeMillis());
            responseMessage.setType("CHAT");
            
            // 广播消息给所有客户端
            broadcastMessage(objectMapper.writeValueAsString(responseMessage));
        } catch (Exception e) {
            // 如果不是有效的JSON，当作普通文本消息处理
            ChatMessage responseMessage = new ChatMessage(request, incoming.remoteAddress().toString());
            responseMessage.setTimestamp(System.currentTimeMillis());
            responseMessage.setType("CHAT");
            
            // 广播消息给所有客户端
            broadcastMessage(objectMapper.writeValueAsString(responseMessage));
        }
    }

    /**
     * 当客户端断开连接时调用
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel outgoing = ctx.channel();
        channels.remove(outgoing);
        
        // 不再广播用户离开消息，避免前端显示重复消息
        
        System.out.println("[SERVER] - " + outgoing.remoteAddress() + " 断开连接");
    }

    /**
     * 处理客户端异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("聊天室服务器发生异常: " + cause.getMessage());
        cause.printStackTrace();
        
        // 移除异常通道并关闭连接
        channels.remove(ctx.channel());
        ctx.close();
    }
    
    /**
     * 向所有连接的客户端广播消息
     * @param message 要广播的消息
     */
    public static void broadcastMessage(String message) {
        if (!channels.isEmpty()) {
            channels.writeAndFlush(new TextWebSocketFrame(message));
        }
    }
    
    /**
     * 获取ObjectMapper实例
     * @return ObjectMapper实例
     */
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}