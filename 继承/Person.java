package 继承;

public class Person extends Animal{
    public Person(){
        //隐藏了一行代码   super();
        this(10);
        System.out.println("Person中无参数构造方法");
}
    public Person(int i){
        super();
        System.out.println("Person中int参数构造方法");
    }
//    //重写override父类的方法
//    public void eat(){
//        super.eat();
//        System.out.println("人类的吃饭方法");
//    }
//    //添加一些独有的属性 或 方法
//    public void study(){
//        System.out.println("好好学习，天天向上");
//    }
}
