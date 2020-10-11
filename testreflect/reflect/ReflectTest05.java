package 反射.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
反射Student类当中的所有的Field
 */
public class ReflectTest05 {
    public static void main(String[] args) throws Exception{
        //获取整个类
        Class studentClass = Class.forName("反射.bean.Student");
        String className = studentClass.getName();
        System.out.println("完整类名：" + className);
        String simpleName = studentClass.getSimpleName();
        System.out.println("简类名：" + simpleName);

        //获取类中的所有的public修饰的Field
        Field[] fields = studentClass.getFields();
        System.out.println(fields.length);//测试数组中只有1个元素
        //取出这个Field
        Field f = fields[0];
        //取出这个Field的名字
        String fieldName = f.getName();
        System.out.println(fieldName);

        //获取所有的Field
        Field[] fs = studentClass.getDeclaredFields();
        System.out.println(fs.length);

        System.out.println("==============================");
        //遍历
        for(Field field : fs){
            //获取属性的修饰符列表
            int i = field.getModifiers();//返回的修饰符是一个数字，每个数字是修饰符的代号
            System.out.println(i);
            //可以将这个“代号”数字转换成字符串吗？可以,使用Modifier类
            String modifer = Modifier.toString(i);
            System.out.println(modifer);
            //获取属性的类型
            Class fieldType = field.getType();
            String fName = fieldType.getSimpleName();
            System.out.println(fName);
            //获取属性的名字
            System.out.println(field.getName());
        }

    }
}
