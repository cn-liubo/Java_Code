package teststring;

public class TestString1 {

    public static void main(String[] args){

//        String str = "abcdefg";
//        //判断此字符串中是否含有a
//        boolean b = str.contains("ab");
//        System.out.println(b);

//        String str = "Java基础教程.java";
//        System.out.println(str.endsWith(".java"));

//        String str = "abcdefg";
//        byte[] b = str.getBytes();
//        for(int v: b){
//            System.out.println(v);
//        }
//        char[] c = str.toCharArray();
//        for(int v: c){
//            System.out.println(v);
//        }
        String str = "我爱你中国";
        char[] c = str.toCharArray();
        for(int v:c){
            System.out.println(v);
        }
        byte[] b = str.getBytes();
        for(int v:b){
            System.out.println(v);
        }

//        String str = "abcdefgabc";
//        int index = str.indexOf("b");
//        System.out.println(index);
//        System.out.println(str.indexOf("b",3));//8
//        //不论从哪开始寻找  返回的index都是相对于整个String的
//        str.indexOf(98,3);
//
//        System.out.println(str.lastIndexOf("b"));//8


//        String str = "a";//String str = null;
//        boolean b = str.isEmpty();//NullPointerException
//        System.out.println(b);

//        String str = "某某很帅气某某很帅气某某很帅气";
//        str = str.replace('帅','骚');
//        System.out.println(str);
//        str = str.replace("骚气","美丽");
//        System.out.println(str);

//        String str = "a-b-c-d";
//        String[] value = str.split("-",2);
//        for(String v:value){
//            System.out.println(v);
//        }

//        String str = "abcdef";
//        str = str.toUpperCase();
//        System.out.println(str);
//        str = str.toLowerCase();
//        System.out.println(str);

//        String str = " abcdef  ";
//        str = str.trim();
//        System.out.println(str.equals("abcdef"));

//        String str1 = "abc";
//        String str2 = "ABC";
//        System.out.println(str1.equals(str2));//false
//        System.out.println(str1.equalsIgnoreCase(str2));//true  忽略大小写
//        System.out.println(str1.compareTo(str2));//32
//        System.out.println(str1.compareToIgnoreCase(str2));//0  忽略大小写
    }

}
