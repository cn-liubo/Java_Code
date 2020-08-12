package 练习;

import java.util.Scanner;

public class TestScanner {

    public static void main(String[] args){
        //利用数组实现用户登录
        //有小数组来充当数据库
        //利用Scanner让用户输入
        Scanner input = new Scanner(System.in);
        //input这个小人在计算机中的消息队列内等着读取
        System.out.println("请输密码：");
        String password = input.nextLine();//阻塞效果
        //有一个剩余的回车符

        //1.利用nextLine方法读取一个空的回车符
        //input.nextLine();
        //2.利用next()方法读取字符串 next方法读取方式与nextInt一样，不读取回车符 将前一个回车符跳过
        //3.将账号和密码都统一的用nextLine()来读取
        //   将String--->int
        //数据类型转化的问题
        //基本类型<--包装类-->引用类型  int--Integer    char--Character    byte--Byte    float--Float
        int value = Integer.parseInt(password);//当密码为abc时，出现NumberFormatException数字格式化异常

        System.out.println("请输入账号：");
        String name = input.nextLine();//阻塞效果

        //比较
        System.out.println("接收到了账号："+name);
        System.out.println("接受到了密码："+value);

        //   将int--->String  5 + ""
        System.out.println(5+"");//5   +连接着字符串就不是通常的加法运算了
        System.out.println(5+"5");//55
        System.out.println(5+5+"5"+5+5);//10555
    }
}

