package 枚举;

import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {

        //输入一个字符串 输出对应的信息
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个星期的英文单词：");
        String s = input.nextLine();
        Day day = Day.valueOf(s);//通过输入的英文单词找到对应的枚举对象
        switch(day){//1.5之前 int(byte short) char    1.6 enum    1.7String
            case monday:
                System.out.println("星期一");
                break;
            case tuesday:
                System.out.println("星期二");
                break;
            case wednesday:
                System.out.println("星期三");
                break;
            case thursday:
                System.out.println("星期四");
                break;
            case firdy:
                System.out.println("星期五");
                break;
            case saturday:
                System.out.println("星期六");
                break;
            case sunday:
                System.out.println("星期日");
                break;
            default:
                System.out.println("出现错误");
        }

    }

}
