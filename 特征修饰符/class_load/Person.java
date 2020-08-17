package 特征修饰符.class_load;

public class Person extends Animal{
    public String test = "PersonField";
    public static String testStatic = "PersonStsticField";

    public Person(){
        //super();//默认的调用父类无参数的构造方法
        System.out.println("我是Person类中无参数的构造方法");
    }

    {
        this.testPerson();
        System.out.println("我是Person类中的普通代码块"+test);
    }
    static{
        Person.testStatic();
        System.out.println("我是Person类中的静态代码块"+testStatic);
    }


    public void testPerson(){
        System.out.println("我是Person类中的普通方法");
    }
    public static void testStatic(){
        System.out.println("我是Person类中的静态方法");
    }
}
