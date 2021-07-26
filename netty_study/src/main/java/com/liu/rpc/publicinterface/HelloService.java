package com.liu.rpc.publicinterface;

/*
需求说明
    1.dubbo底层使用Netty作为网络通讯框架，要求用Netty实现一个简单的RPC框架
    2，模仿dobbo，消费者和提供者约定接口和协议，消费者远程调用提供者的服务，提供者返回一个字符串，消费者
    打印提供者返回的数据
设计说明
    1.创建一个接口，定义抽象方法。用于消费者和提供者之间的约定
    2，创建一个提供者，该类需要监听消费者的请求，并按照约定返回数据
    3.创建一个消费者，该类需要透明的调用自己不存在的方法，内部需要使用Netty请求提供者返回数据

 */
public interface HelloService {

    String hello(String mes);
}
