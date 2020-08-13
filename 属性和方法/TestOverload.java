package 属性和方法;

import java.sql.SQLOutput;

public class TestOverload {
    //JDK1.5版本之后 出现的一个新的写法-->动态参数列表
    //不能与数组类型的方法构成重载，因为本质上是一样的
    public void test(int... x){//本质上是数组
        System.out.println("执行了test方法携带的动态列表");
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }
    public void test(int[]...x){
        System.out.println();
    }

//    //方法重载
//    public void test(){
//        System.out.println("执行了test方法中没有带参数");
//    }
//    public void test(boolean b){
//        System.out.println("执行了test方法中带boolean参数"+b);
//    }
//    public void test(int i){
//        System.out.println("执行了test方法中带int参数"+i);
//    }
//    public void test(char c){
//        System.out.println("执行了test方法中带char参数"+c);
//    }
//    public void test(String s){
//        System.out.println("执行了test方法中带String参数"+s);
//    }

    public static void main(String[] args){
        //创建对象
        TestOverload to = new TestOverload();
        to.test(1,2,3,4,5);

        //通过对象.方法名字  调用方法  可以直接通过方法名字定位方法
        //如果方法名字一直  通过方法的参数列表类型来定位
        //通过对象调用方法 方法执行一遍
        //to.test('a');//方法参数传递  类型之间的转换问题
        //当没有chat类型的方法是，会找一个参数类型可以自动转换的int类型方法

        System.out.println(to);//TestOverload@34e45f-->hashCode码


    }
}

