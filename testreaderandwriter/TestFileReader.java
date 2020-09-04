package testreaderandwriter;

import java.io.*;

//                 字符型文件输入流-->纯文本的文件
public class TestFileReader {

    public static void main(String[] args){

//        char c = '我';
//        System.out.println((int)c);

        //字符型文件输入流
        File file = new File("D://test//Test2.txt");
        try {
            FileReader fr = new FileReader(file);

//            int code = fr.read();
//            System.out.println(code);

            char[] c = new char[1024];
            int count = fr.read(c);
            while(count != -1){
                System.out.print(new String(c,0,count));
                count = fr.read(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        //演示字节型文件输入流  读取中文可能会产生问题
//        //字节流好处在于什么类型的文件都可以处理 不好处在于处理纯文本的文件可能会产生乱码的问题
//        try {
//            FileInputStream fis = new FileInputStream("D://test//Test2.txt");
//            int code  = fis.read();
//            System.out.println(code);//读汉字是会发生错误
//
//            byte[] b = new byte[5];
//            int count = fis.read(b);//只能读8bit，而汉字占16bit 我abc  def
//            while(count != -1){
//                System.out.print(new String(b,0,count,"UTF-8"));
//                count = fis.read(b);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
