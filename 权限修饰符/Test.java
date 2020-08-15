package 权限修饰符;

public class Test{
    public static void main(String[] args){
        //创建类的过程是在Java中描述的过程
        //创建对象
        Person p = new Person();
        //对象的引用.调用属性
        p.name = "刘博";
        p.setAge(19);
        p.sex = "男";
        System.out.println(p.name+"今年"+p.getAge()+"岁，性别是"+p.sex);
    }
}

