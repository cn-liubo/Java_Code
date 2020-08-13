package 属性和方法;

public class Test {
    //这个类没有什么现实意义
    //只是为了将主方法写在这里

    public static void main(String[] args){
//        //想要在这里使用一个人  来执行操作
//        //创建一个类的对象 找一个空间来储存
//        Person p = new Person();
//        //通过对象.去调用属性  存值/取值
//        //属性有默认值  name = null  age = 0  sex = null
//        p.name = "刘博";
//        p.age = 19;
//        p.sex = "男";
//
//        //Person p1 = new Person();
//        Person p1 = p;
//        p1.name = "王";
//        p1.age = 18;
//        p1.sex = "女";
//        System.out.println(p.name+"今年"+p.age+"岁，性别是"+p.sex);
//        System.out.println(p1.name+"今年"+p1.age+"岁，性别是"+p1.sex);

        //创建一个对象
        Person p = new Person();
        //通过对象.的方式调用方法  让方法按照自己描述的过程执行一遍
        p.eat();
        String myName = p.tellName();
        System.out.println("接受到了tellName方法的返回值："+myName);
        p.chiFan(2,"大米饭");
        String drinkName = p.buyDrink(10);
        System.out.println("买到了一瓶"+drinkName);
    }
}

