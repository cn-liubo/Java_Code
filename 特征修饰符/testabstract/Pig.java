package 特征修饰符.testabstract;

public class Pig extends Animal{

    public void eat(){
        System.out.println("猪不能随便吃  提供饲料");
    }
    public void sleep(){
        System.out.println("猪不能随便睡  温暖的猪窝");
    }
}
