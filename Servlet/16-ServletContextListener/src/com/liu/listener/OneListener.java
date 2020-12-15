package com.liu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OneListener implements ServletContextListener {

    @Override
    //在全局作用域对象被Http服务器初始化被调用
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("恭喜恭喜，来时走一朝");
    }

    @Override
    //在全局作用域对象被Http服务器销毁时候触发调用
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("兄弟不要怕，二十年之后你还是一条好汉");
    }
}
