package testobjectstream;

import java.io.*;

public class TestObjectStream {

    public static void main(String[] args){

//        //将对象直接记录在文件中 永久性保存  对象的持久化 对象的序列化
//        Person p1 = new Person("张三",18);
//        //对象输出流
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream("D://test//Person.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//            oos.writeObject(p1);
//            oos.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //需要一个对象输入流
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://test//Person.txt"));

            Person p = (Person) ois.readObject();
            System.out.println(p);
            p.eat();
            //通过循环方式读取所有的对象，会出现EOFException说明没有对象
            //通常会将所有记录的对象存在一个集合里

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
