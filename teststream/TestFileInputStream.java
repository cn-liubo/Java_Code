package teststream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {

    public static void main(String[] args){

//        try {
//            //创建一个字符型文件输入流 读取一个文件中的内容
//            File file = new File("D://test//ATMService.txt");
//            FileInputStream fis = new FileInputStream(file);//读取真实的文件
//
//            int code = fis.read();//读取一个字节
//            while (code != -1){
//                System.out.print((char)code);//读取的字节对应的Unicode码 0--65535  回车\r--13  换行\n--10
//                code = fis.read();
//            }
//
//        } catch (FileNotFoundException e) {//编译时异常
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        try {
//            FileInputStream fis = new FileInputStream("D://test//ATMService.txt");
//            int v = fis.available();//流管道中有多少缓存的字节  读取网络数据的时候可能有问题
//            System.out.println(v);
//
//            //创建一个空的小数组  去文件里读东西，装入数组内-->相当于返回值
//            byte[] b = new byte[5];
//
//            int count = fis.read(b);//读取到的有效字节个数
//            while(count != -1){
//                String value = new String(b,0,count);
//                //String value = new String(b);    //第一次    a b c d e
//                System.out.print(value);           //第二次    f g \r \n h
//                count = fis.read(b);               //第三次    i j k l m
//            }                                      //第四次    n \r \n o p
//                                                   //第五次    q \r \n o p 数组中之后读到的把之前读到的覆盖
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("D://test//Test.txt"));
            long l = fis.skip(5);
            System.out.println(l);//5
            int code = fis.read();
            System.out.println((char)code);//f
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fis != null) {//有可能new的时候没有找到文件，fis是空的，空的再早调用就会空指针异常
                    fis.close();//关闭的是流通道 不是file对象  关闭这件事必须要做
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
