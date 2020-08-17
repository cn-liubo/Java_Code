package 特征修饰符.testabstract;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.eat();
        person.sleep();
        Pig pig = new Pig();
        pig.eat();
        pig.sleep();
    }
}
