package 枚举;

public class TestRunTime {
    public static void main(String[] args) {

        //什么情况下无法通过new创建对象
        //1.抽象类或者接口  2.没有无参数的构造方法  3.构造方法私有(单例模式)

        Runtime r = Runtime.getRuntime();
        long max = r.maxMemory();
        long total = r.totalMemory();
        long free = r.freeMemory();
        System.out.println(max);//字节byte
        System.out.println(total);
        System.out.println(free);
    }
}
