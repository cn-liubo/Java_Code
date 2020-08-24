package 工具类;

public class TestInteger {
    public static void main(String[] args) {
        Integer i1 = 10;//10自动包装成Integer类型的对象
        Integer i2 = 10;
        Integer i3 = new Integer(10);
        Integer i4 = new Integer(10);
        System.out.println(i1 == i2);//true
        System.out.println(i1 == i3);//false
        System.out.println(i3 == i4);//flase
        System.out.println(i1.equals(i2));//true
        System.out.println(i1.equals(i3));//true
        System.out.println(i3.equals(i4));//true
    }
}
