package 特征修饰符.接口;

public interface TestInterface {

    public static final String name = "小刘";//默认存在 public static final
    default void test(){}//1.8版本以后出现default修饰方法

    public void testOne();//只定义规则 不描述具体过程
}
