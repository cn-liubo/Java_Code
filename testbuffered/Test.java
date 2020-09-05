package testbuffered;

import java.io.*;

public class Test {

//    //设计一个方法 用来用户登录认证
//    public String login(String username,String password){
//        //真实的名字和密码，永久存在数据库中
//        //文件我们采取.txt形式的纯文本 文本的内容，以行为单位，每一行记录一个人的信息
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("D://test//User.txt"));
//            String user = br.readLine();//user表示一行记录 记录着账号和密码
//            while(user != null){
//                //将user的信息按照-拆开，分别于方法的参数比较
//                String[] value = user.split("-");
//                if(value[0].equals(username)){
//                    if(value[1].equals(password)){
//                        return "登录成功";
//                    }
//                    break;
//                }
//                user = br.readLine();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "用户名或密码错误";
//    }

    public static void main(String[] args) {
//        ATMService t = new ATMService();
//        String result = t.login("张三","123");
//        System.out.println(result);


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D://test//User.txt",true));
            bw.newLine();//换行
            bw.write("王五-888");
            bw.flush();
            System.out.println("添加成功");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
