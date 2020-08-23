package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        //所有的字符串中找寻满足如下规则的信息 邮政编码
        String str = "123456abc222333abc654321abc";

        //1.利用Pattern类创建一个模式 理解为一个正则表达式对象
        Pattern pattern = Pattern.compile("\\d{6}");//邮编
        //2.需要提供一个字符串
        //3.利用Pattern模式对象创建一个匹配器
        Matcher matcher = pattern.matcher(str);
        //4.找寻字符串中出现满足上述格式的字符串
        while(matcher.find()){
            System.out.println(matcher.group());//找到满足字符串格式的那一串文字
        }
    }
}
