package 注解.annotation3;

/*
如果一个注解的属性的名字是value的话，并且只有一个属性的话，在使用的时候，该属性名可以省略
 */

public class MyAnnotationTest {

    /*//报错原因：没有指定属性的值
    @MyAnnotation
    public void dosome(){

    }*/

    @MyAnnotation(value = "hehe")
    public void dosome() {

    }
    @MyAnnotation("haha")
    public void doOther(){

    }
}
