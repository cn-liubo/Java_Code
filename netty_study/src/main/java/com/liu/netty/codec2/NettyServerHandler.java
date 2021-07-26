package com.liu.netty.codec2;

import com.liu.netty.codec.StudentPOJO;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/*
    说明
    1.我们自定义一个Handler需要继承netty规定好的某个HandlerAdapter（规范）
    2.这是我们自定义的Handler，才能称为一个handler
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    //读取数据事件（这里我们可以读取客户端发送的的消息）
    /*
        1.ChannelHandlerContext ctx：上下文对象，含有管道pipeline，通道channel，地址
        2.Object msg：就是客户端发送的数据，默认Object
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

        //根据dataType来显示不同的信息
        MyDataInfo.MyMessage.DateType dateType = msg.getDataType();
        if(dateType == MyDataInfo.MyMessage.DateType.StudentType) {
            MyDataInfo.Student student = msg.getStudent();
            System.out.println("学生id = " + student.getId() + "，姓名 = " + student.getName());
        } else if (dateType == MyDataInfo.MyMessage.DateType.WorkerType) {
            MyDataInfo.Worker worker = msg.getWorker();
            System.out.println("工人姓名 = " + worker.getName() + "，年龄 = " + worker.getAge());
        } else {
            System.out.println("传输的类型不正确");
        }
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //writeAndFlush是write + flush，将数据写入到缓存，并刷新
        //一般讲，饿哦们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端~1", CharsetUtil.UTF_8));
    }

    //处理异常，一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
