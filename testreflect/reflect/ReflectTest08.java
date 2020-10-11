package 反射.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
反射Method
 */
public class ReflectTest08 {
    public static void main(String[] args) throws Exception{

        Class userServiceClass = Class.forName("反射.bean.UserService");
        //获取所有的Method
        Method[] methods =userServiceClass.getDeclaredMethods();
        System.out.println(methods.length);

        //遍历Method
        for(Method method : methods) {
            //获取修饰符列表
            System.out.println(Modifier.toString(method.getModifiers()));
            //获取方法的返回值类型
            System.out.println(method.getReturnType().getSimpleName());
            //获取方法名
            System.out.println(method.getName());
            //获取方法的修饰符列表
            Class[] parameterTypes = method.getParameterTypes();
            for(Class parameterType : parameterTypes){
                System.out.println(parameterType.getSimpleName());
            }

        }
    }
}
