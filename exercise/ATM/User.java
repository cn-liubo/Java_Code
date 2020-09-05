package exercise.ATM;

import java.io.Serializable;

public class User implements Serializable {

    //建议除了私有属性，无参数有参数构造方法，属性对应的get，set方法
    //建议类实现一个序列化接口，添加一个序列化版本号
    private static final long serialVersionUID = 8559564588109176574L;


    //只是记录数据库中的一行的信息  账号 密码 余额

    private String name;
    private String password;
    private Float balance;

    public User(){

    }
    public User(String name, String password, Float balance){
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setBalance(Float balance){
        this.balance = balance;
    }
    public Float getBalance(){
        return this.balance;
    }
}
