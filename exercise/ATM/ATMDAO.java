package exercise.ATM;

import java.util.HashMap;

public class ATMDAO {//Data Access Object数据传输对象

    //DAO作为一个层次--持久层  操作数据 读写数据
    //DAO中还有一个 负责加载文件 更新文件数据
    private FileLoaderAndCommit fileLoaderAndCommit = new FileLoaderAndCommit("src//exercise//ATM//User.txt");

    //发现登录的方法 每一次调用都需要创建流管道 读取文件的信息
    //内存中操作登录的业务 文件不在一个地方 认为读取的速度很慢
    //解决方案 创建一个map集合充当缓存 将文件的全部数据读出来 读一次
    //一行记录 创建一个对象存起来 一个人就是一个对象 三个属性
    //集合除了可以充当缓存 增强执行性能外 还能用来做记录的修改
    private HashMap<String, User> userBox = fileLoaderAndCommit.loadFile();



    //设计一个方法 目的是为了我的所有业务服务
    //参数 账号名   返回值 User对象
    public User select(String name){
        return userBox.get(name);
    }
    //设计一个方法 目的是为了将某一个修改完毕的对象存入集合
    public void update(User user){
        userBox.put(user.getName(),user);
        fileLoaderAndCommit.commit(userBox);
    }

}
