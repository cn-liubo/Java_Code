package 反射.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
通过反射机制，反编译一个类的属性Field
 */
public class ReflectTest06 {
    public static void main(String[] args) throws Exception{

        //创建这个是为了拼接字符串
        StringBuilder stringBuilder = new StringBuilder();

        Class studentClass = Class.forName("反射.bean.Student");

        stringBuilder.append(Modifier.toString(studentClass.getModifiers()) + " class " + studentClass.getSimpleName() + " {\n");

        Field[] fields = studentClass.getDeclaredFields();
        for(Field field : fields){
            stringBuilder.append("\t");
            stringBuilder.append(Modifier.toString(field.getModifiers()));
            stringBuilder.append(" ");
            stringBuilder.append(field.getType().getSimpleName());
            stringBuilder.append(" ");
            stringBuilder.append(field.getName());
            stringBuilder.append(";\n");

        }

        stringBuilder.append("}");
        System.out.println(stringBuilder);
    }
}
