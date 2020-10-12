package 注解.annotation4;

public class OtherAnnotationTest {

    @OtherAnnotation(age = 25, email = {"zhangsan@123.comm", "zhangsan@souhu.com"}, seasonArray = Season.SPRING)
    public void doSome(){

    }

    //如果数组中只有1个元素：大括号可以省略
    @OtherAnnotation(age = 25, email = "zhangsan@123.comm", seasonArray = {Season.SPRING, Season.SUMMER})
    public void doOther(){

    }
}
