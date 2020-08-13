package 继承;

public class Test {
    public static void main(String[] args){
        //加载类模板的过程
        //Person类  Animal类  Object类
        //创建一个Person类型的对象
        Person p = new Person();
        //通过p调用person中的属性、方法
        //p.sleep();//从Animal类中继承过来的方法

//        p.name = "张三";
//        p.eat();//重写
//        p.sleep();
//        p.study();//独有的方法

//        int[] a = new int[5];
//        System.out.println(a);//[I@2f4d3709

//        System.out.println(p);//继承.Person@4e50df2e
    }
}

