package exercise.ATM;

import java.io.*;
import java.util.Iterator;

public class ATMService {

    //这个类都是负责处理业务逻辑的 需要底层数据的支持
    private ATMDAO atmdao = new ATMDAO();


    //网络银行业务
    //所有的业务方法 按照之前的优化结构设计
    //只有业务逻辑 判断 比较 计算等等
    //看不见任何数据操作  从哪查来的 存在哪

    //设计一个方法 用户登录
    public String login(String name, String password) {
        User user = atmdao.select(name);
        if(user != null && user.getPassword().equals(password)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    //设计一个业务方法 查询余额
    public Float queryBalance(String name){
        User user = atmdao.select(name);
        return user.getBalance();
    }

    //设计一个业务方法 存款 数据库中做修改某一行记录
    public void deposit(String name,Float depositMoney){
        //先将集合内的数据修改 找到一个user对象 把对象中的balance属性修改
        User user = atmdao.select(name);
        user.setBalance(user.getBalance() + depositMoney);
        atmdao.update(user);
        //将集合内所有最终的数据全部写入文件中 把文件中的所有内容替换
        //this.commit();//提交 将临时的数据永久的写入文件
    }

    //设计一个业务方法 取款 数据库中做修改某一行记录
    public void withdrawal(String name,Float withdrawalMoney){
        //先将集合内的数据修改 找到一个user对象 把对象中的balance属性修改
        User user = atmdao.select(name);
        if(user.getBalance() > withdrawalMoney){
            user.setBalance(user.getBalance() - withdrawalMoney);
            atmdao.update(user);
            //将集合内所有最终的数据全部写入文件中 把文件中的所有内容替换
            //atmdao.commit();//提交 将临时的数据永久的写入文件
        }else{
            System.out.println("对不起"+user.getName()+"，您的账户余额不足");
        }
    }

    //设计一个业务方法 转账 数据库中做修改某一行记录
    public void transfer(String outName,String inName,Float transferMoney){
        //先将集合内的数据修改 找到一个user对象 把对象中的balance属性修改
        User outUser = atmdao.select(outName);
        if(outUser.getBalance() > transferMoney){
            User inUser = atmdao.select(inName);
            if(inUser != null){//转入账户存在
                outUser.setBalance(outUser.getBalance() - transferMoney);
                inUser.setBalance(inUser.getBalance() + transferMoney);
                atmdao.update(outUser);
                atmdao.update(inUser);
                //将集合内所有最终的数据全部写入文件中 把文件中的所有内容替换
                //atmdao.commit();//提交 将临时的数据永久的写入文件
            }else{
                System.out.println("对不起，该账户不存在");
            }

        }else{
            System.out.println("对不起"+outUser.getName()+"，您的账户余额不足");
        }
    }


}
