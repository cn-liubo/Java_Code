package regex;

import java.util.Scanner;

public class TestRegex {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = input.nextLine();
        //判断输入的str字符串内容是否满足什么样的格式

//        boolean result1 = str.matches("a[abc]");
//        //第一个字母必须是a，第二个字母是abc其中的一个
//        System.out.println(result1);

//        boolean result2 = str.matches("a[^abc]");
//        //第一个字母必须是a，第二个字母是非abc任意的其他的一个
//        System.out.println(result2);

//        boolean result3 = str.matches("a[a-zA-Z]");
//        //第一个字母必须是a，第二个字母是任意范围之内的一个字母
//        System.out.println(result3);

//        boolean result4 = str.matches("[a-z&&[^bc]]");
//        //a-z都可以，并且不能是b和c
//        System.out.println(result4);

//        boolean result5 = str.matches(".[a-zA-Z]");
//        //第一个任意一个字符，第二个字母是任意范围之内的一个字母
//        System.out.println(result5);

//        boolean result6 = str.matches("a[abc]?");
//        //第一个字母必须是a，第二个字母是abc其中的一个出现的次数是一次或零次
//        System.out.println(result6);

        boolean result6 = str.matches("\\d{6}");//前一个\是转义字符，后面的是定义好的符号
        //第一个字母必须是a，第二个字母是abc其中的一个出现的次数是一次或零次
        System.out.println(result6);
    }
}
