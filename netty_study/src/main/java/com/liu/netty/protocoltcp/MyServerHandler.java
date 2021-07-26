package com.liu.netty.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

//处理业务
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        //接收到处理并处理
        int length = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("服务器接收到信息如下：");
        System.out.println("长度 = " + length);
        System.out.println("内容 = " + new String(content, Charset.forName("UTF-8")));

        System.out.println("服务器接收到消息包数量 = " + (++this.count));

        //回复消息
        String responseContent = UUID.randomUUID().toString();
        byte[] responseContents = responseContent.getBytes("UTF-8");
        int responseLen = responseContent.getBytes("UTF-8").length;
        //构建一个协议包
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(responseLen);
        messageProtocol.setContent(responseContents);

        ctx.writeAndFlush(messageProtocol);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
        ctx.close();
    }
}
