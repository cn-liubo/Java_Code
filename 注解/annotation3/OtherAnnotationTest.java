package 注解.annotation3;

public class OtherAnnotationTest {


    //报错了，因为属性名是name，不能省略
    //@OtherAnnotation("test")
    @OtherAnnotation(name = "test")
    public void doSome(){

    }
}
