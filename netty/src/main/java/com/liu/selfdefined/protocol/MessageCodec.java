package com.liu.selfdefined.protocol;

import com.liu.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/*
自定义协议要素
    1.魔数，用来在第一时间判定是否是无效数据包
    2.版本号，可以支持协议的升级
    3.序列化算法，消息正文到底采用哪种序列化方式，可以由此扩展，例如：json、protobuf、hessian、jdk
    4.指令类型，是登录、注册、单聊、群聊...跟业务相关
    5.请求序号，为了双工通信，提供异步能力
    6.正文长度
    7.消息正文
 */
@Slf4j
//@ChannelHandler.Sharable
public class MessageCodec extends ByteToMessageCodec<Message> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        //1.4个字节的魔数
        byteBuf.writeBytes(new byte[]{1, 2, 3, 4});
        //2.1个字节的版本
        byteBuf.writeByte(1);
        //3.1个字节的序列化方式 0 jdk，1 json
        byteBuf.writeByte(0);
        //4.1个字节的指令类型
        byteBuf.writeByte(message.getMessageType());
        //5.4个字节的请求序号
        byteBuf.writeInt(message.getSequenceId());
        //无意义，对其填充
        byteBuf.writeByte(0xff);
        //6.获取内容的字节数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(message);
        byte[] bytes = bos.toByteArray();
        //7.正文长度
        byteBuf.writeInt(bytes.length);
        //8.写入内容
        byteBuf.writeBytes(bytes);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int magicNum = byteBuf.readInt();
        byte version = byteBuf.readByte();
        byte serializerType = byteBuf.readByte();
        byte messageType = byteBuf.readByte();
        int sequencedId = byteBuf.readInt();
        byteBuf.readByte();
        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes, 0, length);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Message message = (Message) ois.readObject();
        log.debug("{}, {}, {}, {}, {}, {}", magicNum, version, serializerType, messageType, sequencedId, length);
        log.debug("{}", message);
        list.add(message);
    }
}
