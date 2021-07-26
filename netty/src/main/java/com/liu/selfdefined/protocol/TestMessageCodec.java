package com.liu.selfdefined.protocol;

import com.liu.message.LoginRequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;

public class TestMessageCodec {
    public static void main(String[] args) throws Exception {
        EmbeddedChannel channel = new EmbeddedChannel(
//                new LoggingHandler(LogLevel.DEBUG),
                //帧解码器，当发现数据半包问题时，不会传给下一个handler
                new LengthFieldBasedFrameDecoder(1024, 12, 4, 0, 0),
                new LoggingHandler(),
                new MessageCodec());

        //encode
        LoginRequestMessage message = new LoginRequestMessage("zhangsan", "123", "张三");
        channel.writeOutbound(message);

        //decode
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        new MessageCodec().encode(null, message, buf);
        //入站
        channel.writeInbound(buf);

        //测试半包问题
/*        ByteBuf b1 = buf.slice(0, 100);
        ByteBuf b2 = buf.slice(100, buf.readableBytes() - 100);
        b1.retain();//引用计数加1
        channel.writeInbound(b1);//会调用release
        channel.writeInbound(b2);*/
    }
}
