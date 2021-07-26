package com.liu.advance.c1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

//解决方法四：在发送消息前，先约定用定长字节表示接下来数据的长度，LengthFieldBasedFrameDecoder
public class TestLengthFieldDecoder {
    public static void main(String[] args) {
        /*
        LengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset,
        int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip， boolean failFast)
        参数解释：
        maxFrameLength：发送数据帧最大长度
        lengthFieldOffset：长度字段偏移量
        lengthFieldLength：长度字段长度
        lengthAdjustment：长度字段为基准，还有几个字节是内容
        initialBytesToStrip：从头剥离几个字节
        failFast：true: 读取到长度域超过maxFrameLength，就抛出一个 TooLongFrameException。
                  false: 只有真正读取完长度域的值表示的字节之后，才会抛出 TooLongFrameException，
                  默认情况下设置为true，建议不要修改，否则可能会造成内存溢出
        发送数据包长度 = 长度域的值 + lengthFieldOffset + lengthFieldLength + lengthAdjustment
         */
        EmbeddedChannel channel = new EmbeddedChannel(
                new LengthFieldBasedFrameDecoder(1024, 0,
                        4, 1, 4),
                new LoggingHandler(LogLevel.DEBUG)
        );

        //4个字节的内容长度，实际内容
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        send(buf, "hello, world");
        send(buf, "Hi!");
        channel.writeInbound(buf);
    }

    private static void send(ByteBuf buf, String content) {
        byte[] bytes = content.getBytes();//实际内容
        int length = bytes.length;//实际内容长度
        buf.writeInt(length);
        buf.writeByte(1);
        buf.writeBytes(bytes);
    }
}
