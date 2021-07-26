package com.liu.nio.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

//Java IO 客户端
public class NewIOServer {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 7001));
        String fileName = "protoc-3.6.1-win32.zip";

        //得到一个文件的Channel
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        //准备发送
        long startTime = System.currentTimeMillis();

        //再linux下一个transferTo方法就可以传输
        //windows下一次调用transferTo只能发送8m，就可以分段传输文件，而且要注意传输时的位置
        //transferTo底层使用到零拷贝
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送的总的字节数 = " + transferCount + "，耗时" + (System.currentTimeMillis() - startTime));

        //关闭
        fileChannel.close();
    }
}
