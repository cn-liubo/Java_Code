package com.liu.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;//上下文
    private String result;//返回的结果
    private String para;//客户端调用方式时，传入的参数

    //与服务器的连接创建后，就会被调用，这个方法是第一个被调用（1）
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive被调用");
        context = ctx;//因为在其他方法会使用到ctx
    }

    //收到服务器的数据后，就会被调用（4）
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead被调用");
        result = msg.toString();
        notify();//唤醒等待的线程

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    //被代理对象调用，发送数据给服务器，wait等待被唤醒，返回结果（3）
    @Override
    public synchronized Object call() throws Exception {
        System.out.println("call1被调用");
        context.writeAndFlush(para);
        //进行wait
        wait();//等待channelRead方法获取到服务器的结果后，唤醒
        System.out.println("call2被调用");
        return result;//服务器返回的结果
    }

    //设置参数（2）
    public void setPara(String para) {
        System.out.println("setPara被调用");
        this.para = para;
    }
}
