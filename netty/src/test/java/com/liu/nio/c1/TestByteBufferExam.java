package com.liu.nio.c1;

import java.nio.ByteBuffer;

public class TestByteBufferExam {
    /*
    网络上有多条数据发送给服务器，数据之间使用\n分隔，但由于某种原因这些数据在接收时，被进行重新组合，
    例如元是数据有3条为
        Hello,world\n
        I'm zhangsan\n
        How are you?\n
    编程了下面的两个byteBuffer（黏包：为了服务端的效率，半包：服务端缓冲区的大小）
        Hello,world\nI'm zhangsan\nHo
        w are you?\n
    现在要求编写程序，将错乱的数据恢复成原来按\n分隔的数据
     */
    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);

    }
    private static void split(ByteBuffer source) {
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            //找到一条完整消息
            if(source.get(i) == '\n') {
                int length = i + 1 - source.position();
                //把这条完整消息存入新的ByteBuffer
                ByteBuffer buffer = ByteBuffer.allocate(length);
                //从source读，向buffer写
                for (int j = 0; j < length; j++) {
                    buffer.put(source.get());
                }
                ByteBufferUtil.debugAll(buffer);
            }
        }
        source.compact();
    }

}
