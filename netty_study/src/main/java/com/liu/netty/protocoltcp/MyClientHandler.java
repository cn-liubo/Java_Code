package com.liu.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //使用客户端发送10条数据 ”今天天气冷，吃火锅“ 编号
        for (int i = 0; i < 5; i++) {
            String message = "今天天气冷，吃火锅";
            byte[] content = message.getBytes(Charset.forName("UTF-8"));
            int length = message.getBytes(Charset.forName("UTF-8")).length;

            //创建协议包对象
            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setLen(length);
            messageProtocol.setContent(content);
            ctx.writeAndFlush(messageProtocol);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常信息 = " + cause.getMessage());
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int length = msg.getLen();
        byte[] content = msg.getContent();
        System.out.println("客户端接收到消息如下：");
        System.out.println("长度 = " + length);
        System.out.println("内容 = " + new String(content, Charset.forName("UTF-8")));

        System.out.println("客户端接收消息数量 = " + (++this.count));
    }
}
