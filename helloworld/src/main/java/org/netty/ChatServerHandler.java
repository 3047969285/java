package org.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 处理聊天室消息的处理器
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    // 用于保存所有连接的客户端通道
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 当客户端连接到服务器时调用
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        // 广播通知其他用户有新用户加入
        channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 加入聊天室\n");
        channels.add(ctx.channel());
        System.out.println("[SERVER] - " + incoming.remoteAddress() + " 加入聊天室");
    }

    /**
     * 当客户端断开连接时调用
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel outgoing = ctx.channel();
        // 广播通知其他用户有用户离开
        channels.writeAndFlush("[SERVER] - " + outgoing.remoteAddress() + " 离开聊天室\n");
        System.out.println("[SERVER] - " + outgoing.remoteAddress() + " 离开聊天室");
    }

    /**
     * 读取客户端发送的数据
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incoming = ctx.channel();
        // 向除自己外的所有客户端转发消息
        for (Channel channel : channels) {
            if (channel != incoming) {
                channel.writeAndFlush("[" + incoming.remoteAddress() + "] " + msg + "\n");
            }
        }
        System.out.println("[" + incoming.remoteAddress() + "] " + msg);
    }

    /**
     * 处理客户端异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("聊天室服务器发生异常: " + cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }
}