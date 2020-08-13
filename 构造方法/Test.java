package 构造方法;

public class Test {
    public static void main(String[] args){
        //new的过程其实就是在调用构造方法
        //调用Person类中的构造方法
        //若自己定义带参数的构造方法，将系统提供的默认无参数的构造构造方法也写出来  构成构造方法的重载
        Person p = new Person("刘博",19,"男");//构造方法结构上没有返回值类型  有返回值是对象
        System.out.println(p.name+"今年"+p.age+"岁，性别是"+p.sex);
    }
}
