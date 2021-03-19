package io;

import java.io.*;

public class FileOutput {

    public static void main(String[] args) throws IOException {
        //路劲上该文件，new File不会报错，但是操作输入输出流会抛FileNotFountException
        File file = new File("D:\\test\\1.txt");
        //把a-z换行输出到某个文件，需要考虑是否存在的问题
        if(!file.exists()) {
            file.createNewFile();
        }
        //类似输入的几种写法都可以
//        new FileWriter()/new FileOutputStream()/new BufferedWriter()/new PrintWriter()

        //缓冲字符输出流
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//        bw.write("\n");

        //打印输出流
//        PrintWriter pw = new PrintWriter(new FileWriter(file));
        PrintWriter pw = new PrintWriter(new FileOutputStream(file));
        //快速打印a-z
        for (int i = 'a'; i <= 'z'; i++) {
            pw.println((char)i);
        }
        pw.flush();

    }
}
