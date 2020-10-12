package 注解.annotation7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表示这个注解只能出现在类上面
@Target(ElementType.TYPE)
//表示该注解可以被反射机制读取到
@Retention(RetentionPolicy.RUNTIME)
public @interface MustHasIdPropertyAnnotation {

}