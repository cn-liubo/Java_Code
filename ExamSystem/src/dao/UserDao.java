package dao;

import domain.User;
import util.UserFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//持久层  数据的持久化
//只负责数据的读写  不负责处理逻辑
//现阶段看到的方法内部，通常都是I/O
//以后这个层次的方法看到的内部代码都是JDBC
public class UserDao {

    //缓存--虚拟机(内存中)--存储文件中的所有信息



    //负责查询一个人的信息
    // 参数 账号  返回值domain
    public User select(String account){

        return UserFileReader.getUser(account);
    }
}
