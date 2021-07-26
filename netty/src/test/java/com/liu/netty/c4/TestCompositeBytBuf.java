package com.liu.netty.c4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;

import static com.liu.netty.c4.Log.log;

public class TestCompositeBytBuf {
    public static void main(String[] args) {
        ByteBuf buf1 = ByteBufAllocator.DEFAULT.buffer();
        buf1.writeBytes(new byte[]{1, 2, 3, 4, 5});

        ByteBuf buf2 = ByteBufAllocator.DEFAULT.buffer();
        buf2.writeBytes(new byte[]{6, 7, 8, 9, 10});

        //性能较差
        /*ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        buf.writeBytes(buf1).writeBytes(buf2);
        log(buf);*/

        CompositeByteBuf buf = ByteBufAllocator.DEFAULT.compositeBuffer();
        buf.addComponents(true, buf1, buf2);
        log(buf);
    }
}
