package 练习.ArrayBox;

public class ArrayBoxIndexOutOfBoundsException extends RuntimeException{
    //想要描述一个类是一个(我们自己的异常 is a 异常)异常
    //继承extends 泛化(实现接口)implements
    public ArrayBoxIndexOutOfBoundsException(){

    }
    public ArrayBoxIndexOutOfBoundsException(String msg){
        super(msg);//msg提供给父类
    }
}
