package lesson3;

public class MethodArgument {

    //int i = 方法调用传入的值
    public static void suiBian(int i) {//suiBain方法栈帧
        i = 1;
    }
    public static void suiBian(User user) {
        //注释，和不注释，结果是u局部变量指向不同的堆对象
//        user = new User();
        user.username = "李四";
    }

    //main线程，执行main方法（栈帧）
    public static void main(String[] args) {
        int i = 0;
        suiBian(i);//产生方法调用
        System.out.println(i);

        User user = new User();
        user.username = "张三";
        suiBian(user);
        System.out.println(user.username);
    }

    private static class User {
        private String username;
    }
}
