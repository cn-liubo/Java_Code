package com.liu.chat.server.handler;

import com.liu.chat.server.service.UserServiceFactory;
import com.liu.chat.server.session.SessionFactory;
import com.liu.message.LoginRequestMessage;
import com.liu.message.LoginResponseMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class LoginRequestMessageHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginRequestMessage loginRequestMessage) throws Exception {
        String username = loginRequestMessage.getUsername();
        String password = loginRequestMessage.getPassword();
        boolean login = UserServiceFactory.getUserService().login(username, password);
        LoginResponseMessage message = null;
        if (login) {
            SessionFactory.getSession().bind(channelHandlerContext.channel(), username);
            message = new LoginResponseMessage(true, "登录成功");
        } else {
            message = new LoginResponseMessage(false, "用户名或密码错误");
        }
        channelHandlerContext.writeAndFlush(message);
    }
}
