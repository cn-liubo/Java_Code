package 特征修饰符.class_load;

public class Test {
    public static void main(String[] args) {
        //存在继承关系的类 加载机制及执行过程

        //加载类的过程--静态元素已经加载
        new Person();
        //1.加载父类
        //2.父类会产生自己的静态空间    属性 方法 块
        //     执行静态块
        //3.加载子类
        //4.子类会产生自己的静态空间    属性 方法 块
        //    执行静态块
        //5.开辟空间
        //6.加载父类的非静态成员    属性 方法 块 构造方法
        //7.  执行块     执行构造方法
        //8.加载子类的非静态成员    属性 方法 块 构造方法
        //9.  执行块     执行构造方法
        //10.将对象空间的地址引用交给变量来存储
        //Person p = new Person();
    }
}
