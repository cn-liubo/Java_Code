package 反射.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*
反编译一个类的Constructor构造方法
 */
public class ReflectTest11 {
    public static void main(String[] args) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        Class vipClass = Class.forName("反射.bean.Vip");

        stringBuilder.append(Modifier.toString(vipClass.getModifiers()));
        stringBuilder.append(" class ");
        stringBuilder.append(vipClass.getSimpleName());
        stringBuilder.append("{\n");
        //拼接构造方法
        Constructor[] constructors = vipClass.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            stringBuilder.append("\t");
            stringBuilder.append(Modifier.toString(vipClass.getModifiers()));
            stringBuilder.append(" ");
            stringBuilder.append(vipClass.getSimpleName());
            stringBuilder.append("(");
            //拼接参数
            Class[] parameterTypes = constructor.getParameterTypes();
            for(Class parameterType : parameterTypes){
                stringBuilder.append(parameterType.getSimpleName());
                stringBuilder.append(",");
            }
            //删除最后下标位置上的字符
            if(parameterTypes.length > 0){
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append("){}\n");
        }
        stringBuilder.append("}");

        System.out.println(stringBuilder);
    }
}
