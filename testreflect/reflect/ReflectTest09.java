package 反射.reflect;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest09 {
    public static void main(String[] args) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        Class userServiceClass = Class.forName("反射.bean.UserService");
        //Class userServiceClass = Class.forName("java.lang.String");

        stringBuilder.append(Modifier.toString(userServiceClass.getModifiers()) + " class "+userServiceClass.getSimpleName()+" {\n");

        Method[] methods = userServiceClass.getDeclaredMethods();
        for(Method method : methods){
            //public boolean login(String name,String password){}
            stringBuilder.append("\t");
            stringBuilder.append(Modifier.toString(method.getModifiers()));
            stringBuilder.append(" ");
            stringBuilder.append(method.getReturnType().getSimpleName());
            stringBuilder.append(" ");
            stringBuilder.append(method.getName());
            stringBuilder.append("(");
            // 参数列表
            Class[] parameterTypes = method.getParameterTypes();
            for(Class parameterType : parameterTypes){
                stringBuilder.append(parameterType.getSimpleName());
                stringBuilder.append(",");
            }
            // 删除指定下标位置上的字符
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("){}\n");
        }
        stringBuilder.append("}");
        System.out.println(stringBuilder);

    }
}
