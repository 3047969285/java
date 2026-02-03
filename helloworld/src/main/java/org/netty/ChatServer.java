package org.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 聊天室服务器主类
 */
public class ChatServer {
    private final int port;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ScheduledExecutorService messageScheduler;

    public ChatServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        new ChatServer(8080).start();
    }

    public void start() throws Exception {
        // 创建两个EventLoopGroup对象
        bossGroup = new NioEventLoopGroup();  // 接收连接
        workerGroup = new NioEventLoopGroup(); // 处理连接

        try {
            // 创建ServerBootstrap对象
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServerInitializer());

            // 绑定端口并启动服务器
            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("聊天室服务器启动成功，监听端口: " + port);

            // 启动自动消息推送服务
            startAutoMessagePush();

            // 等待服务器通道关闭
            future.channel().closeFuture().sync();
        } finally {
            // 优雅关闭线程组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            
            // 关闭消息推送服务
            if (messageScheduler != null) {
                messageScheduler.shutdown();
            }
        }
    }

    /**
     * 启动自动消息推送服务
     */
    private void startAutoMessagePush() {
        messageScheduler = Executors.newSingleThreadScheduledExecutor();
        
        // 每隔5秒向所有连接的客户端推送一条系统消息
        messageScheduler.scheduleAtFixedRate(() -> {
            if (!ChatServerHandler.channels.isEmpty()) {
                // 创建自动推送的消息
                ChatMessage autoMessage = new ChatMessage(
                    "系统自动推送消息 - " + System.currentTimeMillis(),
                    "System"
                );
                
                String message = "[" + autoMessage.getSender() + "] " + 
                                autoMessage.getContent() + "\n";
                
                // 向所有连接的客户端推送消息
                ChatServerHandler.channels.writeAndFlush(message);
                System.out.println("自动推送消息: " + autoMessage.getContent());
            }
        }, 5, 5, TimeUnit.SECONDS); // 延迟5秒后开始，每隔5秒执行一次
        
        System.out.println("自动消息推送服务已启动");
    }
}