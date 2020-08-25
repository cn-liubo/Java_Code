package teststring;

public class TestStringBuilder {

    public static void main(String[] args){
//        //无参数的构造方法  构建一个默认长度16个空间的对象 char[]
//        StringBuilder stringBuilder = new StringBuilder();
//
//        //可以利用给定的参数  构建一个自定义长度空间的对象 char[]
//        StringBuilder stringBuilder1 = new StringBuilder(20);
//
//        //利用带String参数的构造方法  默认数组长度字符串长度 + 16个
//        StringBuilder stringBuilder2 = new StringBuilder("abc");


//        String str = "a";
//        long time1 = System.currentTimeMillis();
//        for(int i = 1; i <= 200000; i++){
//            str += "a";//20309ms
//            //str = str.concat("a");//12163ms
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2 - time1);
//        StringBuilder stringBuilder = new StringBuilder("a");
//        long time1 = System.currentTimeMillis();
//        for(int i = 1; i < 200000; i++){
//            stringBuilder.append("a");//9ms
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2 - time1);


//        StringBuilder stringBuilder = new StringBuilder("abcdefg");//7+16 capacity
//        System.out.println(stringBuilder.capacity());//底层那个数组的容量  23
//        System.out.println(stringBuilder.length());//数组的有效元素的个数  7

        StringBuilder stringBuilder = new StringBuilder("abcdefg");
//        String str = stringBuilder.substring(2,5);//从2索引开始5索引结束
//        System.out.println(str);//cde
//        stringBuilder.delete(2,5);
//        System.out.println(stringBuilder);//abfg
//        stringBuilder.deleteCharAt(2);
//        System.out.println(stringBuilder);//abdefg

//        stringBuilder.append("m");
//        System.out.println(stringBuilder);//abcdefgm
//        stringBuilder.insert(1,"n");
//        System.out.println(stringBuilder);//anbcdefgm

//        stringBuilder.replace(2,5,"zzt");
//        System.out.println(stringBuilder);//abzztfg

//        stringBuilder.reverse();
//        System.out.println(stringBuilder);//gfedcba

//        stringBuilder.setCharAt(2,'z');
//        System.out.println(stringBuilder);//abzdefg

//        System.out.println(stringBuilder.length());//7
//        System.out.println(stringBuilder.capacity());//23
//        stringBuilder.setLength(20);
//        System.out.println(stringBuilder.length());//20
//        System.out.println(stringBuilder.capacity());//23

//        stringBuilder.toString();//将一个StringBuilder对象转化成String对象

        System.out.println(stringBuilder.length());//7
        System.out.println(stringBuilder.capacity());//23
        stringBuilder.trimToSize();
        System.out.println(stringBuilder.length());//7
        System.out.println(stringBuilder.capacity());//7

    }

}
