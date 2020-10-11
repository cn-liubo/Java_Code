package 反射.reflect;

import java.lang.reflect.Constructor;

/*
使用反射机制怎么创建对象

 */
public class ReflectTest12 {
    public static void main(String[] args) throws Exception{

        //使用反射机制创建对象
        Class c = Class.forName("反射.bean.Vip");
        //调用无参数构造方法
        Object obj = c.newInstance();
        System.out.println(obj);

        //调用有参数的构造方法
        //1.先获取到这个有参数的构造方法
        Constructor con1 = c.getDeclaredConstructor(int.class, String.class, String.class, boolean.class);
        //2.调用构造方法new对象
        Object newObj1 = con1.newInstance(110, "jack", "1999-12-31", true);
        System.out.println(newObj1);

        //获取无参数构造方法
        Constructor cons2 = c.getDeclaredConstructor();
        Object newObj2 = cons2.newInstance();
        System.out.println(newObj2);

    }
}
