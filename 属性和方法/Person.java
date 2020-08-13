package 属性和方法;

public class Person {
    //这个文件是在计算机内 画的一张图纸
    //描述计算机里的人类长成什么样子

    //属性和方法--静态描述特点
    //必要的组成部分
    //  修饰符   数据类型   属性姓名[=值]
    //权限修饰符 [特征修饰符] 数据类型 属性名字
    public String name;//全局变量
    public int age;
    public String sex;

    //方法--描述可以做什么事情(动作)
    //权限修饰符 [特征修饰符] 返回值类型 ([参数列表])[{方法体}]
    //1、无参数无返回值
    //2、无参数有返回值
    //3、有参数无返回值
    //4、有参数有返回值

    //无参数无返回值
    //设计一个方法  用来描述人类可以做吃饭这件事
    public void eat(){
        System.out.println("吃了一碗大米饭");
    }
    //无参数有返回值
    //设计一个方法  用来告诉别人我的名字
    public String tellName(){
        System.out.println("你们问我叫什么名字呀？勉强告诉你们一下");
        return "刘博";
    }
    //有参数无返回值
    //设计一个新的吃饭方法
    public void chiFan(int count,String something){
        System.out.println("吃了"+count+"碗"+something);
    }
    //有参数有返回值
    //设计一个方法 买饮料  1.需不需要提供条件   2.需不需要给别人留下什么结果
    //需要提供条件   钱     需要返回值   饮料
    public String buyDrink(int money){
        if(money>5){
            return "红牛";
        }
        else{
            return "矿泉水";
        }
    }
}

