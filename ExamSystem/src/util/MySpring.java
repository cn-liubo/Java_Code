package util;

import java.util.HashMap;

//目的是为了管理对象的产生
//对象的控制权交给当前类来负责  IOC对象的控制反转
//生命周期托管的方式实现了对象的单例
public class MySpring {

    //属性 为了存储所有被管理的对象
    private static HashMap<String,Object> beanBox = new HashMap<>();

    //设计一个方法  获取任何一个类的对象
    // 参数String类名    返回值Object(或泛型)
    public static <T>T getBean(String className){//传递一个类全名
        T obj = null;
        try {
            //直接取beanBox里面获取
            obj = (T)beanBox.get(className);
            //判断 如果obj是null，证明之前没有创建过这个对象
            if(obj == null){
                //通过类名获取Class
                Class clazz =Class.forName(className);
                //通过反射产生一个对象
                obj = (T)clazz.newInstance();
                //新的对象存入集合中
                beanBox.put(className,obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
