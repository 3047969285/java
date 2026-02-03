package org.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * WebSocket聊天室服务器
 */
public class WebSocketChatServer implements EventChangeListener {
    
    private final int port;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel channel;

    public WebSocketChatServer(int port) {
        this.port = port;
        // 注册事件监听器
        EventObserver.addListener(this);
    }

    public static void main(String[] args) throws Exception {
        new WebSocketChatServer(8081).start(); // 更改端口号为8081
    }

    public void start() throws Exception {
        bossGroup = new NioEventLoopGroup(5);
        workerGroup = new NioEventLoopGroup(5);
        
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new WebSocketChatServerInitializer());

            ChannelFuture future = bootstrap.bind(port).sync();
            channel = future.channel();
            
            System.out.println("WebSocket聊天室服务器启动成功，监听端口: " + port);
            
            // 等待服务器通道关闭
            channel.closeFuture().sync();
        } finally {
            shutdown();
        }
    }
    
    /**
     * 关闭服务器
     */
    public void shutdown() {
        if (channel != null) {
            channel.close();
        }
        
        if (bossGroup != null) {
            bossGroup.shutdownGracefully();
        }
        
        if (workerGroup != null) {
            workerGroup.shutdownGracefully();
        }
        
        System.out.println("WebSocket聊天室服务器已关闭");
    }

    @Override
    public void onEventAdded(Event event) {
        // 当有新事件添加时，构建消息并广播
        String message = event.getTime() + " " + event.getLocation() + " " + event.getIncident();
        System.out.println("检测到新事件: " + message);
        
        // 创建聊天消息对象并转换为JSON格式，避免重复广播
        try {
            ChatMessage chatMessage = new ChatMessage(message, "System[事件推送]");
            chatMessage.setType("EVENT");
            chatMessage.setTimestamp(System.currentTimeMillis());
            
            // 直接广播纯消息内容，不包含额外的格式
            WebSocketChatServerHandler.broadcastMessage(
                WebSocketChatServerHandler.getObjectMapper().writeValueAsString(chatMessage));
        } catch (Exception e) {
            System.err.println("消息序列化失败: " + e.getMessage());
        }
    }
}