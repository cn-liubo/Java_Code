package 注解.annotation7;

//自定义异常
public class HasNotIdPropertyException extends Exception{
    public HasNotIdPropertyException(){

    }

    public HasNotIdPropertyException(String message) {
        super(message);
    }
}
