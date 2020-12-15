package com.liu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class OneListener implements ServletContextAttributeListener {
    @Override
    //在全局作用域对象添加共享数据
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("新增共享数据");
    }

    @Override
    //在全局作用域对象更新共享数据
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("删除共享数据");
    }

    @Override
    //在全局作用域对象删除共享数据
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("删除共享数据");
    }
}
