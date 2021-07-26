package com.liu.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/*
Netty心跳检测机制案例
实例要求：
    编写一个Netty心跳检测机制案例，当服务器超过3秒没有读时，就提示读空闲
    当服务器超过5秒没有写操作时，就提示写空闲
    实现当服务器超过7秒没有读或者写操作时，就提示读写空闲
 */
public class MyServer {
    public static void main(String[] args) throws Exception {

        //创建两个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))//在bossGroup增加一个日志处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //加入Netty提供的IdleStateHandler
                            /*
                            说明：
                                1.IdleStateHandler是Netty提供的处理空闲状态的处理器
                                    long readerIdleTime：表示多长时间没有读，就会发送一个心跳检测包，检测是否是连接状态
                                    long writerIdleTime：表示多长时间没有写，就会发送一个心跳检测包，检测是否是连接状态
                                    long allIdleTime：表示多长时间没有读写，就会发送一个心跳检测包，检测是否是连接状态
                                2.文档说明
                                Triggers an {@link IdleStateEvent} when a {@link Channel} has not performed read, write, or both operation for a while.
                                3.当IdleStateHandler触发后，就会传递给管道的下一个handler去处理，通过调用（触发）下一个handler的userEventTiggered，在该方法中去处理IdleStateHandler(读空闲, 写空闲,读写空闲)
                             */
                            pipeline.addLast(new IdleStateHandler(3, 5, 7, TimeUnit.SECONDS));
                            //加入一个对空闲检测进一步处理的handler（自定义）
                            pipeline.addLast(new MyServerHandler());
                        }
                    });

            //启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
