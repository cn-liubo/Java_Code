package com.liu.nio.c1;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {
    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
        /*
        class java.nio.HeapByteBuffer    Java堆内存，读写效率较低，受到GC的影响
        class java.nio.DirectByteBuffer  直接内存，读写掉率高（少一次数据拷贝），不会受到GC的影响，分配内存的效率低
         */

    }
}
