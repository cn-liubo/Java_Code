package com.liu.rpc.server.handler;

import com.liu.rpc.message.RpcRequestMessage;
import com.liu.rpc.message.RpcResponseMessage;
import com.liu.rpc.service.HelloService;
import com.liu.rpc.service.ServicesFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RpcRequestMessageHandler extends SimpleChannelInboundHandler<RpcRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequestMessage message) {
        RpcResponseMessage response = new RpcResponseMessage();
        response.setSequenceId(message.getSequenceId());
        try {
            HelloService service = (HelloService) ServicesFactory.getService(Class.forName(message.getInterfaceName()));
            Method method = service.getClass().getMethod(message.getMethodName(), message.getParameterTypes());
            Object invoke = method.invoke(service, message.getParameterValue());

            response.setReturnValue(invoke);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
//            response.setExceptionValue(e);//异常堆栈信息太多，全部返回给客户端，导致缓冲区爆掉
            String msg = e.getCause().getMessage();
            response.setExceptionValue(new Exception("远程调用出错：" + msg));
        }
        ctx.writeAndFlush(response);
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        RpcRequestMessage message = new RpcRequestMessage(1,
                "com.liu.rpc.service.HelloService",
                "sayHello",
                String.class,
                new Class[]{String.class},
                new Object[]{"张三"});


    }
}
