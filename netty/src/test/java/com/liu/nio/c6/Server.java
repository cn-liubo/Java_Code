package com.liu.nio.c6;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

@Slf4j
public class Server {
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
                com.liu.nio.c1.ByteBufferUtil.debugAll(buffer);
            }
        }

        source.compact();//0123456789abcdef position:16 limit:16
    }
    public static void main(String[] args) throws IOException {
        //1.创建selector，管理多个channel
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        //2.建立selector和channel的联系（注册）
        //SelectionKey就是将来事件发生后，通过它就可以知道事件和哪个channel的事件
        SelectionKey sscKey = ssc.register(selector, 0, null);
        //key只关注accept事件
        sscKey.interestOps(SelectionKey.OP_ACCEPT);
        log.debug("sscKey:{}", sscKey);
        ssc.bind(new InetSocketAddress(8080));
        while (true) {
            //3.select方法，没有事件发生，线程阻塞，有事件，线程才会恢复运行
            //select在事件未处理时，它不会阻塞，事件发生后要么处理，要么取消，不能置之不理
            selector.select();
            //4.处理事件，selectedKeys内部包含了所有发生的事件
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();//accept, read
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                //处理key时，要么从selectedKeys集合中删除，否则下次处理就会有问题
                iter.remove();
                log.debug("key:{}", key);
                //5.区分事件类型
                if(key.isAcceptable()) {//如果时accept
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    ByteBuffer buffer = ByteBuffer.allocate(16);//attachment
                    //将一个byteBuffer作为附件关联到selectionKey上
                    SelectionKey sckey = sc.register(selector, 0, buffer);
                    sckey.interestOps(SelectionKey.OP_READ);
                    log.debug("{}", sc);
                    log.debug("scKey:{}", sckey);
                } else if(key.isReadable()) {//如果时read
                    try {
                        SocketChannel channel = (SocketChannel) key.channel();//拿到触发事件的channel
                        //获取selectionKey上关联的附件
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        int read = channel.read(buffer);//如果时正常断开，read的方法的返回值是-1
                        if(read == - 1) {
                            key.cancel();
                        } else {
                            split(buffer);
                            if(buffer.position() == buffer.limit()) {
                                ByteBuffer newBuffer = ByteBuffer.allocate(buffer.capacity() * 2);
                                buffer.flip();
                                newBuffer.put(buffer);//0123456789abcdef3333\n
                                key.attach(newBuffer);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        key.cancel();//因为客户端断开了，因此需要将key取消（从selector的keys集合中真正删除key）
                    }
                }
            }
        }
    }
}
