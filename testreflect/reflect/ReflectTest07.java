package 反射.reflect;

import java.lang.reflect.Field;

/*
必须掌握：
    怎么通过反射机制访问一个java对象的属性
        给属性赋值set
        获取属性的值get
 */
public class ReflectTest07 {
    public static void main(String[] args) throws Exception{

        //使用反射机制，怎么范文一个对象的属性
        Class studentClass = Class.forName("反射.bean.Student");
        Object obj = studentClass.newInstance();//obj就是Student对象，底层调用无参数构造方法

        //获取no属性(根据属性的名称来获取Field)
        Field noField = studentClass.getDeclaredField("no");
        //给obj对象（Student对象）的no属性赋值
        noField.set(obj, 222);//给obj对象的no属性赋值
        //读取属性的值
        System.out.println(noField.get(obj));

        //获取私有的属性
        Field nameField = studentClass.getDeclaredField("name");

        //打破封装
        nameField.setAccessible(true);

        nameField.set(obj, "jack");
        System.out.println(nameField.get(obj));

    }
}
