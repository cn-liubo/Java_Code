package 反射.reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/*
验证反射机制的灵活性
    java代码写一遍，再不改变java源代码的基础上，可以做到不同对象的实例化。
    非常之灵活。（符合OCP开闭原则：对扩展开放，对修改开放）

后期要学习的是高级框架，而在工作过程中，也都是使用高级框架。
包括：ssh ssm
    Spring SpringMVC MyBaits
    Spring Struts Hibernate
    ...
    这些高级框架底层实现原理：都是采用了反射机制，所以反射机制还是很重要的。
    学会了反射机制有利于理解剖析框架底层的源代码。
 */
public class ReflectTest03 {
    public static void main(String[] args) throws Exception {

        //这种方式代码就写死了。只能创建一个User类型的对象
        //User user = new User();

        //通过IO流读取classinfo.properties文件
        FileReader reader = new FileReader("src/反射/classinfo2.properties");
        //创建属性类对象Map
        Properties properties = new Properties();//key和value都是String
        //加载
        properties.load(reader);
        //关闭流
        reader.close();

        //通过key获取value
        String className = properties.getProperty("className");
        System.out.println(className);

        //通过反射机制实例化对象
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        System.out.println(obj);

    }
}
