package util;

import javax.swing.*;

public abstract class BaseFrame extends JFrame {

    //模板模式

    //设计一个规则 任何窗口想要画出来 执行固定的流程

    public BaseFrame(){}
    public BaseFrame(String title){
        super(title);
    }
    protected void init(){
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }


    //设置 字体 背景 位置 布局 等等
    protected abstract void setFontAndSoOn();
    //将属性添加到窗体里
    protected abstract void addElement();
    //添加事件监听
    protected abstract void addListener();
    //设置窗体自己的信息
    protected abstract void setFrameSelf();
}
