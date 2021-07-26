package com.liu.netty.c4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class TestByteBuf2 {
    public static void main(String[] args) {
        ByteBuf buf1 = ByteBufAllocator.DEFAULT.buffer();
        System.out.println(buf1.getClass());//io.netty.buffer.PooledUnsafeDirectByteBuf
        ByteBuf buf2 = ByteBufAllocator.DEFAULT.heapBuffer();
        System.out.println(buf2.getClass());//io.netty.buffer.PooledUnsafeHeapByteBuf
    }
}
