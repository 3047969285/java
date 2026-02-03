package org.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * WebSocket聊天室服务器初始化器
 */
public class WebSocketChatServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // HTTP编解码器
        pipeline.addLast(new HttpServerCodec());
        // 支持大数据流处理
        pipeline.addLast(new ChunkedWriteHandler());
        // HTTP消息聚合器
        pipeline.addLast(new HttpObjectAggregator(64 * 1024));
        
        // WebSocket协议处理器
        // 处理路径为/ws的WebSocket握手和数据传输
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        
        // 自定义的WebSocket消息处理器
        pipeline.addLast(new WebSocketChatServerHandler());
    }
}