package 注解.annotation;

/*
1.注解，或者叫做注释类型，英文单词是：Annotation
2.注解Annotation是一种引用数据类型，编译之后也是生成xxx.class文件
3.怎么自定义注解吗？语法格式
    [修饰符列表] @interface 注解类类名{

    }
4.注解怎么使用，用在什么地方？
    注解使用时的语法格式是： @注解类型名
    注解可以出现在类上、属性上、方法上、变量上等...，注解还可以出现在注解类型上。

 */
@MyAnnotation
public class AnnotationTest01 {

    @MyAnnotation
    private int no;
    @MyAnnotation
    public AnnotationTest01(){

    }
    @MyAnnotation
    public static void m1(){
        @MyAnnotation
                int i = 10;

    }
    @MyAnnotation
    public void m2(@MyAnnotation
                   String name,
                   @OtherAnnotation
                   int k){

    }
}
@MyAnnotation
interface MyInteface{

}
@MyAnnotation
enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}
