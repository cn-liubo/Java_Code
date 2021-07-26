package com.liu.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/*
    编写一个NIO入门案例，实现服务器端和客户端之间的数据简单通讯（非阻塞），理解NIO非阻塞网络编程机制
    ServerSocketChannel：侧重于监听客户端的连接，生成一个SocketChannel
    SocketChannel：侧重于对数据的读写
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {

        //创建ServerSocketChannel类似ServerSock
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到一个Selector对象
        Selector selector = Selector.open();

        //绑定端口6666，再服务端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel注册到selector，关注的事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while (true) {
            //这里等待1秒，如果没有事件发送，返回
            if(selector.select(1000) == 0) {//没有事件发送
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }

            //如果返回的大于0，获取到相关的SelectionKey集合
            //1、如果返回的大于0，表示已经获取到关注的事件
            //2、selector.selectedKeys()返回关注事件的集合
            //通过selectionKeys反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            //遍历Set<SelectionKey>，使用迭代器遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据key对应的通道发送的事件做相应的处理
                if (key.isAcceptable()) {//如果时OP_ACCEPT，有新的客户端连接
                    //给该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //将socketChannel设置为非阻塞
                    socketChannel.configureBlocking(false);
                    System.out.println("客户端连接成功，生成了一个socketChannel" + socketChannel.hashCode());
                    //将当前的socketChannel注册到selector，关注事件为OP_READ，同时给socketChannel关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if (key.isReadable()) {//发送OP_READ
                    //通过key方向获取到channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from客户端" + new String(buffer.array()));
                }

                //手动从集合中移除当前的selectionKey，防止重复操作
                keyIterator.remove();
            }
        }

    }
}
