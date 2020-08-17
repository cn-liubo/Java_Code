package 特征修饰符.teststatic;

public class Person {

    public String name;
    public static int age;//斜体

    static{
        System.out.println("我是静态块");
    }
    public Person(){
        System.out.println("我是Person构造方法");
    }
    public void test(){
        System.out.println("我是普通方法"+Person.age);
    }
    public static void testStatic(){
        System.out.println("我是静态方法");
    }

    public static void main(String[] args){

        //加载一个Person的类模板
        try {
            //通过类的全名字  反射机制加载类
            Class.forName("特征修饰符.teststatic.Person");
        }catch(Exception e){

        }




//        Person p1 = new Person();
//        p1.name = "刘小哥哥";
//        p1.age = 18;
//        Person p2 = new Person();
//        p2.name = "王小姐姐";
//        p2.age = 16;
//        System.out.println(p1.name+"今年"+p1.age+"岁");
//        System.out.println(p2.name+"今年"+p2.age+"岁");
    }
}

