package 内部类;

public class Demo {

    private String name = "这是正常类中的属性";
    public void testDemo(){
        System.out.println("这是正常类类中的方法");
    }

    //成员内部类
    public class InnerDemo{
        private String name = "我是内部类的属性";
        public void testInnerDemo(){
            System.out.println("我是成员内部类的方法:"+Demo.this.name);//外部类的属性
            testDemo();//Demo.this.testDemo();
        }
    }

    //局部内部类
    public void testDemoOne(){
        String s = "abc";
        //定义一个局部内部类
        class InnerTestMethod{
            //局部内部类中使用局部变量都需要加final修饰
        }
    }
//    {
//        class InnerDemo{
//
//        }
//    }
//    public Demo(){
//        class InnerDemo{
//
//        }
//    }

    //静态内部类
    public static class InnerDemoStatic{

    }
}
