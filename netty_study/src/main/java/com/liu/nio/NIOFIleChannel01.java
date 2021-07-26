package com.liu.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
    使用ByteBuffer（缓冲）和FileChannel（通道），将字符串写入文件中
 */
public class NIOFIleChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "hello";
        //创建一个输出流 channel
        FileOutputStream fileOutputStream = new FileOutputStream("");
        //通过FileOutputStream获取对应的FileChannel
        //这个fileOutputStream真实类型是FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个缓冲区ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将str放入byteBuffer
        byteBuffer.put(str.getBytes());

        //对byteBuffer进行flip
        byteBuffer.flip();

        //将byteBuffer数据写入到fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
