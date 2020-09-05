package exercise;

import java.io.*;

public class OperateFile {

//    //设计一个方法  文件的复制
//    public void copyFile(File file,String path){//当做file是一个文件  C;//Test1.txt
//
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try {
//            //创建一个输入流
//             fis = new FileInputStream(file);
//            //创建一个新的file对象
//            File newFile = new File(path+"//"+file.getName());
//            fos = new FileOutputStream(newFile);
//            //读取文件中的信息
//            byte[] b = new byte[1024];//通常创建的数组 1kb--8kb之间
//            int count = fis.read(b);
//
//            while(count != -1) {
//                fos.write(b,0,count);//将读取到的有效字节写入
//                fos.flush();
//                count = fis.read(b);
//            }
//            System.out.println("复制完毕");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            //关闭
//            try {
//                if(fis != null) {
//                    fis.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(fos != null) {
//                    fos.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    //设计一个方法  文件的复制加密
//    public void jiaMiFile(File file,String path){//当做file是一个文件  C;//Test1.txt
//
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try {
//            //创建一个输入流
//            fis = new FileInputStream(file);
//            //创建一个新的file对象
//            File newFile = new File(path+"//"+file.getName());
//            fos = new FileOutputStream(newFile);
//            //读取文件中的信息
//            byte[] b = new byte[1024];//通常创建的数组 1kb--8kb之间
//            int count = fis.read(b);
//
//            while(count != -1) {
//                //做点手脚  将每一次数组的前两个元素位置互换
//                byte temp = b[0];
//                b[0] = b[1];
//                b[1] = temp;
//
//                fos.write(b,0,count);//将读取到的有效字节写入
//                fos.flush();
//                count = fis.read(b);
//            }
//            System.out.println("加密完毕");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            //关闭
//            try {
//                if(fis != null) {
//                    fis.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(fos != null) {
//                    fos.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    //设计一个方法  文件夹的复制
    public void superCopyFile(File file,String newPath){//file可以是文件，也可以是文件夹
        //判断当前传递进来的file是个文件还是文件夹  isFile()    isDirectory()   listFiles()
        File[] files = file.listFiles();//获取当前传递进来的file对象所有子元素

        //获取file的绝对路径 拼串的方式获取新文件的名字
        String oldFilePath = file.getAbsolutePath();
        String newFilePath = newPath + oldFilePath.split(":")[1];
        //创建一个新的file对象
        File newFile = new File(newFilePath);

        if(files != null){//file是一个文件夹 才有数组对象

            //通过新的file对象操作 在 硬盘上创建一个新的文件夹
            newFile.mkdir();
            System.out.println(newFile.getName()+"文件夹复制完毕");
            //里面的元素
            if(files.length != 0){
                for(File f:files){
                    this.superCopyFile(f,newPath);
                }
            }
        }else{//file是一个文件 文件是没有子元素
            //创建两个文件流 分别读取旧的file和写入新的newFile
            FileInputStream fis = null;
            FileOutputStream fos = null;

            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newFile);
                byte[] b = new byte[1024];
                int count = fis.read(b);//有效的字节个数
                while(count != -1){
                    fos.write(b,0,count);
                    fos.flush();
                    count = fis.read(b);//需要再读一遍
                }
                System.out.println(newFile.getName()+"文件复制完毕");
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args){

        OperateFile of = new OperateFile();
        //of.copyFile(new File("C://Test2.txt"),"D://test");

//        //这种加密方式需要解密的话，要把已加密的文件在加密一次
//        of.jiaMiFile(new File("C:\\Users\\39458\\Desktop\\03-JDK14新特性\\Code.rar"),"D://test");



    }
}
