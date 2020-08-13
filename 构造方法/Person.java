package 构造方法;

public class Person {
    public String name;
    public int age;
    public String sex;

    public Person(){
        System.out.println("我是无参数的默认的构造方法");
    }
    public Person(String name,int age,String sex){
        this();//调用无参数的构造方法
        System.out.println("我是带参数的构造方法");
        //创建一个对象(开辟空间)
        this.name = name;
        this.age = age;
        this.sex = sex;
        //this.eat();
        //返回了创建的这个对象空间的引用
    }

    //程序块
    //是一个没有修饰符，没有参数，没有返回值，没有名字的特殊方法
    //每一次调用构造方法之前  系统会帮我们自动的调用一次程序块 执行
    //块可以在里面写一些程序 在创建对象之前执行的
    {
        System.out.println("我也是一个块");
    }
    {
        System.out.println("我是一个普通的程序块");
    }
    {
        System.out.println("我又是一个块");
    }

    //权限修饰符  与类名一致的方法名([参数列表]){方法体}
    //只有这么一个特殊的方法  名字是大写字母
    //少了结构  特征修饰符(没有)  返回值类型(结构没有)
    //特点：1.每一个类都有构造方法，若自己在类中没有定义，系统会默认提供一个无参数的构造方法
    //        若在类中自己定义了构造方法，则默认无参数的构造方法及被覆盖
    //      2.构造方法存在构造方法的重载
//    public Person(){
//        System.out.println("我是Person类的构造方法");
//    }
//    public Person(String s){
//        System.out.println("我是带String参数的构造方法");
//    }

    public void eat(){
        System.out.println("人类的吃饭方法");
    }
}

