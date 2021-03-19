package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFile {

    public static void main(String[] args) {
        File dir = new File("D:\\test\\resources");
        List<File> files = listDir(dir);
        //jdk1.8集合框架使用stream操作，可以使用lambda表达式
        files.stream()//集合的stream操作，提供更多的功能，效率也很高
//                .filter()//过滤
                .map(f -> {
                    return f.getName();
                })//把集合中的元素映射为另一种类型
//                .collect()//进行流操作重新返回
                .forEach(System.out :: println);
    }

    public static List<File> listDir(File dir) {
        List<File> list = new ArrayList<>();
        if(dir.isFile()) {//效率不太好的地方：如果是文件，返回一个list只存放一个元素
            list.add(dir);
        } else if(dir.isDirectory()) {
            File[] children = dir.listFiles();
            if(children != null) {
                for(File file : children) {
                    List<File> files = listDir(file);
                    list.addAll(files);
                }
            }
        }
        return list;
    }

    public static List<File> listDir2(File dir) {
        List<File> list = new ArrayList<>();
        if(dir.isDirectory()) {
            //获取目录下一级的子文件、子文件夹
            File[] children = dir.listFiles();
            if(children != null) {
                for(File file : children) {
                    //返回的文件不包含文件夹
//                    if(file.isDirectory()) {//如果是子文件夹，递归调用获取
//                        list.addAll(listDir2(file));
//                    } else {
//                        list.add(file);
//                    }
                    //如果是要包含
                    list.add(file);
                    if(file.isDirectory()) {
                        list.addAll(listDir2(file));
                    }
                }
            }
        }
        return list;
    }
}
