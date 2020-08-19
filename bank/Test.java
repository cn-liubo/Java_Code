package 练习.bank;

public class Test {
    public static void main(String[] args){
        Bank bank = new Bank();
//        OldMan om = new OldMan("长者");
//        bank.profession(om);

        Person p = new OldMan("老年人");
        bank.profession(p);

//        Person p = new Toff("土豪");
//        bank .profession(p);

        //按照刚才的设计 可能有问题
        //1.三个不同的人类方法名不一致(可以)
        //2.银行办理业务的方法写了三个
        //解决如上所述的问题 可以在三个人类之上创建一个父类
        //1.解决三个人类的相同代码  比如name属性 get方法之类的
        //2.父类定义的三个方法可以是抽象的 解决了子类命名不一致的问题 子类执行也不一致
        //3.父类可以作为参数传入银行
    }
}
