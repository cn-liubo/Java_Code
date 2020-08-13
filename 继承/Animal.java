package 继承;

public class Animal {
    public Animal(){
        System.out.println("Animal中无参数的构造方法");
    }
    public Animal(int i){
        System.out.println("Animal中int参数构造方法");
    }

    //public protected 默认不写 private
//    public void eat(){
//        System.out.println("动物的吃饭方法");
//    }
//    public void sleep(){
//        this.eat();
//        //this是人类重写的吃饭
//        //代替的是当前调用方法是的那个对象   不一定是当前类的
//        System.out.println("动物的睡觉方法");
//    }
}

