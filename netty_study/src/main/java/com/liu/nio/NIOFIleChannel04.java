package com.liu.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/*
    拷贝文件transferFrom方法，使用FileChannel（通道）和方法transferFrom，完成文件（图片）的拷贝，
 */
public class NIOFIleChannel04 {
    public static void main(String[] args) throws Exception {
        //创建相关流
        FileInputStream fileInputStream = new FileInputStream("");
        FileOutputStream fileOutputStream = new FileOutputStream("");

        //获取各个流对应的fileChannel
        FileChannel sourceCh = fileInputStream.getChannel();
        FileChannel destCh = fileOutputStream.getChannel();

        //使用transferForm完成拷贝
        destCh.transferFrom(sourceCh, 0, sourceCh.size());
        //关闭相关通道和流
        sourceCh.close();
        destCh.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
