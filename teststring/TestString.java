package teststring;

public class TestString {
    public static void main(String[] args) {
//        //String类 "abc"是对象 存储在常量区中
//        String s1 = "abc";
//        String s2 = "abc";
//        String s3 = new String("abc");
//        String s4 = new String("abc");
//        System.out.println(s1 == s2);//true
//        System.out.println(s1 == s3);//false
//        System.out.println(s3 == s4);//false
//        System.out.println(s1.equals(s2));//true  String类将继承自Object类中的equals()方法重写了
//        System.out.println(s1.equals(s3));//true  将原有比较==的方式改为比较字符值
//        System.out.println(s1.equals(s4));//true

//        byte[] value1 = new byte[]{65,97,48};
//        String str1 = new String(value1);
//        System.out.println(str1);
//
//        char[] value2 = {'A','a','0'};
//        String str2 = new String(value2);
//        System.out.println(str2);
//
//        char[] value3 = {'h','e','l','l','o'};
//        String str3 = new String(value3,1,3);
//        System.out.println(str3);


//        String str1 = "abc";
//        String str2 = "ae";
//        str1.equals(null);//默认比较地址 this==obj String重写了equals()方法，改成了比较字符串内容
//        str1.hashCode();//内存地址调用一个本地的native方法进行计算
//        System.out.println(str1.compareTo(str2));//返回值是int
//        //按照两个字符串长度较短的那个比较循环的次数
//        //挨个比较元素  str1[i] - str2[i]  循环内如果有结果
//        //如果循环过后发现所有的结果都一样 len1 - len2
//        //返回0表示两个字符串相等


//        //数组-->属性
//        //box-->size()方法
//        //String-->length()方法
//        String str1 = "abcdef";//-->123456
//        String result = "";
//        for(int i = 0; i < str1.length(); i++){
//            char c = str1.charAt(i);
//            System.out.println(c);
//        }
//        for(int i = 0; i < str1.length(); i++){
//            int value = str1.codePointAt(i);
//            System.out.println((char)value);
//        }
//        for(int i = 0; i < str1.length(); i++){
//            int value = str1.codePointAt(i);
//            result += (char)(value - 48);
//        }
//        System.out.println(result);


//        String str = "abcdef";
//        //String对象(字符串常量池) value属性char[]
//        //长度不能改变 数组地址不让改变 数组属性私有的我们操作不了
//        str = str.concat("g");
//        //创建一个新的String对象 (字符串常量池) value属性 7个
//        //将刚才那个String对象value值一次取出来 存入新对象的value属性中 将g放在后面
//        System.out.println(str);//abcdefg


//        String str = "a" + "b" + "c" + "d";//数学计算 拼接符号
//        System.out.println(str);//过程中产生了几个String对象？  字符串常量池7个
//        //1对象-->value[] a          "a"
//        //2对象-->value[] b          "b"
//        //3对象-->value[] {a,b}      "ab"
//        //4对象-->value[] c          "c"
//        //5对象-->value[] {a,b,c}    "abc"
//        //6对象-->value[] b          "d"
//        //7对象-->value[] {a,b,c,d}  "abcd"


        String str = "a";
        long time1 = System.currentTimeMillis();
        for(int i = 1; i <= 200000; i++){
            //str += "a";//每一次利用+在原来的字符串后面拼接一个新的"a"                        17818ms
            str = str.concat("a");//利用concat拼接字符 自己的value属性 频繁地创建新的小数组    13445ms
            //StringBuffer对象 拼接效率非常高
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);


    }
}
