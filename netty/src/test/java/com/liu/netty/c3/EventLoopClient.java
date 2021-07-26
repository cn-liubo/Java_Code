package com.liu.netty.c3;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
public class EventLoopClient {
    public static void main(String[] args) throws InterruptedException {
        //带有Future，Promise的类型都是和异步方法配套使用，用来正确处理结果
        ChannelFuture channelFuture = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    //再连接建立后被调用
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new StringEncoder());
                    }
                })
                //1.连接到服务器
                //异步非阻塞，main发起了调用，真正执行connect是NIO线程
                .connect(new InetSocketAddress("localhost", 8080));

        //方法1：使用sync()方法同步处理结果
/*        channelFuture.sync();//阻塞住当前线程，直到NIO线程连接建立完毕
        //如果没有上一行代码，则无阻塞向下执行获取channel，因为此时执行建立连接的线程还没有建立完成，没有获取到channel
        Channel channel = channelFuture.channel();
        log.debug("{}", channel);
        channel.writeAndFlush("hello, world");*/

        //方法2：使用addListener（回调对象）方法异步处理结果
        channelFuture.addListener(new ChannelFutureListener() {
            //在NIO线程连接建立好之后，会调用operationComplete
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Channel channel = channelFuture.channel();
                log.debug("{}", channel);
                channel.writeAndFlush("hello, world");
            }
        });


    }
}
