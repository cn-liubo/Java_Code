package testbuffered;

import java.io.*;

public class TestBufferedReader {

    public static void main(String[] args){


        try {
            //创建一个字符形式的缓冲流   输入流  读取文件
            FileReader fr = new FileReader("D://test//User.txt");
            BufferedReader br = new BufferedReader(fr);

            String value = br.readLine();//读取文件中的一行的信息
            while(value != null){
                System.out.println(value);
                value = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            //创建字符输入流
//            File file = new File("D://test//Test2.txt");
//            FileReader fr = new FileReader(file);
//            BufferedReader br = new BufferedReader(fr);
//            int count = br.read();
//            while(count != -1){
//                System.out.print((char)count);
//                count = br.read();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
