package 特征修饰符;

public class Test {
    public static void main(String[] args) {
        SingTon s1 = SingTon.getSingTon();
        SingTon s2 = SingTon.getSingTon();
        System.out.println(s1 == s2);//true  比较地址
        System.out.println(s1.equals(s2));//true  Object类继承过来的  默认比较地址
        System.out.println(s1);//类全名@hashCode---->16进制的整数
        System.out.println(s2);
    }

}
