package com.liu.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
    使用ByteBuffer（缓冲）和FileChannel（通道），将一个文件中的数据读入到程序中，并显示在控制台上
 */
public class NIOFIleChannel02 {
    public static void main(String[] args) throws IOException {

        //创建文件的输入流
        File file = new File("");
        FileInputStream fileInputStream = new FileInputStream(file);

        //通过fileInputStream获取对应的FileChannel，实际类型 FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();

        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //将通道的数据读入到byteBuffer
        fileChannel.read(byteBuffer);

        //将byteBuffer的字节数据转成String
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
