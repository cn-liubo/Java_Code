package com.liu.nio.c1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestByteBuffer {
    @Test
    public void test1() {
        //FileChannel
        //1.输入输出流 2.RandomAccessFile
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            //准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while(true) {
                //从channel读取数据，向buffer写入
                int len = channel.read(buffer);
                log.debug("读取到的字节数{}", len);
                if(len == -1) {//没有内容了
                    break;
                }
                //打印buffer内容
                buffer.flip();//切换到读模式
                while(buffer.hasRemaining()) {//检查是否还有剩余的未读的数据
                    byte b = buffer.get();
                    log.debug("实际字节{}", (char) b);
                }
                buffer.clear();//切换为写模式
            }

        } catch (IOException e) {
        }
    }

}
