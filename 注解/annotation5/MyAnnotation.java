package 注解.annotation5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//只允许该注解可以标注类、方法
@Target({ElementType.TYPE , ElementType.METHOD})

//希望这个注解可以被反射
@Retention(RetentionPolicy.RUNTIME)

/*@Retention(RetentionPolicy.SOURCE)：表示该注解只被保留在java源文件中。
@Retention(RetentionPolicy.CLASS)：表示该注解被保存在class文件中。
@Retention(RetentionPolicy.RUNTIME)：表示该注解被保存在class文件中，并且可以被反射机制所读取。*/

public @interface MyAnnotation {


    String value() default "北京大兴区";

}
