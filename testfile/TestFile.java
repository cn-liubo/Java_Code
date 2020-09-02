package testfile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {

    public static void main(String[] args){

//        File file = new File("D://test//xyz.txt");
//        boolean b = file.delete();
//        System.out.println(b);


//        //创建一个新的file对象
//        File file = new File("D://test//aaa");
//        //在硬盘上创建一个新的文件夹
//        //boolean result = file.mkdir();//外层需要真实存在
//        file.mkdirs();//可以创建文件夹 如果外层没有也会时创建


//        //创建一个file对象
//        File file = new File("D://test//abc.txt");
//        //通过这个对象 回头在硬盘上创建文件
//        try {
//            boolean result = file.createNewFile();//编译时异常
//            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //File file1 = new File("D://test//ATMService.txt");
        //file对象 是真正的文件吗？ 不是
        //file对象 堆内存中 创建出来的一个对象空间
        //路径是看创建的对象 是否能与硬盘中真实的文件产生对应的映射关系
        //如果文件名写错 通过文件流去读取文件的内容 会产生问题
        //硬盘上的文件名字是不区分大小写 内存中file对象的变量名字区分大小写
        //文件本身的一些属性-->
//        System.out.println(file.canExecute());
//        System.out.println(file.canRead());
//        System.out.println(file.canWrite());
//        System.out.println(file.isHidden());
//        System.out.println(file.isFile());//判断当前的file是否是一个文件
//        System.out.println(file.isDirectory());//判断当前的file是否是一个目录(文件夹)
//        System.out.println(file.length());//Array.length  List.size  String.length()  File.length()
//        long l = file.length();
//        System.out.println(l);
//        long time = file.lastModified();//获取文件最后修改时间
//        Date date = new Date(time);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
//        System.out.println(sdf.format(date));
//        //file.setLastModified();//修改文件的最后一次修改的时间

//        String name = file1.getName();//获取文件名字 ATMService.txt
//        System.out.println(name);
//        String path = file1.getAbsolutePath();//获取文件的绝对路径 D:\test\ATMService.txt
//        System.out.println(path);

//        String pName = file1.getParent();//当前file的父亲名字 test
//        System.out.println(pName);//D:\test
//        File pfile = file1.getParentFile();//当前file的父亲对象
//        System.out.println(pfile.getAbsolutePath());//D:\test

//        File file = new File("D:\\test\\bbb\\innner\\InnerTest.txt");
//////        File pFile = file.getParentFile();
//////        System.out.println(pFile.getAbsolutePath());//D:\test\bbb\innner
//        File pFile = file.getParentFile();
//        while (pFile != null){
//            System.out.println(pFile.getAbsolutePath());
//            pFile = pFile.getParentFile();//再找一遍
//        }

        File file = new File("D://test//aaa");
        //数组对象为空           证明当前的file是一个文件
        //数组对象不为空         证明当前的file是一个文件夹
        //数组对象的长度不为零   证明当前的file是一个不为空的文件夹 文件夹内有东西
        //
        File[] files = file.listFiles();
        System.out.println(files.length);
        //递归算法遍历文件夹

    }
}
