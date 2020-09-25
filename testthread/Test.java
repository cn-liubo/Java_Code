package testthread;

public class Test {

    public static void main(String[] args){
//        //创建一个线程对象
//        RunMan r1 = new RunMan("苏炳添");
//        RunMan r2 = new RunMan("博尔特");
//        RunMan r3 = new RunMan("加特林");
//        //调用start方法，让线程进入就绪状态
//        r1.start();//从Thread类中继承过来的方法
//        r2.start();
//        r3.start();


        int[][] array = new int[7][];
        Integer a = 1000;
        Integer b = 1000;
        Integer c = new Integer(1000);
        Integer d = new Integer(1000);
        System.out.println(a == b);//true  false
        System.out.println(a == c);//false
        System.out.println(c == d);//false
        System.out.println(a.equals(b));//true
        System.out.println(a.equals(c));//true
        System.out.println(c.equals(d));//true
    }
}
