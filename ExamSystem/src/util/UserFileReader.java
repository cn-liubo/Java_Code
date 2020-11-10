package util;

import domain.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//这个类的目的是 增加一个缓存机制
//程序启动的时候将User.txt文件中的所有信息 一次性读出来
//以后做查询就可以直接读缓存中的数据 提高读取的性能
public class UserFileReader {

    //创建一个集合 --> 充当缓存
    private static HashMap<String, User> userBox = new HashMap<>();//static保证集合是唯一的

    public static User getUser(String account){
        return userBox.get(account);
    }

    //在当前类加载的时候先执行
    //static为了让类加载的时候就要加载块
    static{
        BufferedReader bufferedReader = null;
        try {
             bufferedReader = new BufferedReader(new FileReader("src//datafile//User.txt"));
            String user = bufferedReader.readLine();//每一个读取文件中的一行记录
            while(user != null){
                String[] values = user.split("-");
                userBox.put(values[0],new User(values[0],values[1]));
                user = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
