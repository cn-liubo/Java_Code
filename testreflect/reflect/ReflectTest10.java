package 反射.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
必须掌握
    通过反射机制怎么调用一个对象的方法？

        反射机制，让代码具有通用性，可变化的内容都是写到配置文件当中，
        将来修改配置文件之后，创建的对象不一样了，调用的方法也不同了，
        但是java代码不需要做任何改动，这就是反射机制的魅力
 */
public class ReflectTest10 {
    public static void main(String[] args) throws Exception{

        //使用反射机制来调用一个对象的方法
        Class userServiceClass = Class.forName("反射.bean.UserService");
        //创建对象
        Object obj = userServiceClass.newInstance();
        //获取Method
        Method loginMethod = userServiceClass.getDeclaredMethod("login", String.class, String.class);
        //调用方法
        //反射机制中最最最最重要的一个方法
        Object reValue = loginMethod.invoke(obj, "admin", "123");
        System.out.println(reValue);

    }
}
