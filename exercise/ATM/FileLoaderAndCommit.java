package exercise.ATM;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class FileLoaderAndCommit {

    private String fileName = null;
    public FileLoaderAndCommit(String fileName){
        this.fileName = fileName;
    }

    //程序块的目的是在对象创建之前 给集合进行赋值操作
    public HashMap<String,User> loadFile(){
        HashMap<String,User> userBox = new HashMap<String,User>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            //创建一个输入流 读取真实文件的记录
            File file = new File(fileName);
            fileReader = fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String value = bufferedReader.readLine();
            while(value != null){
                //value的信息拆成三段 构建一个User对象 三个属性刚好存储 将对象存入集合中
                String[] userValue = value.split("-");
                User user = new User(userValue[0],userValue[1],Float.parseFloat(userValue[2]));
                userBox.put(user.getName(),user);//put(账号，User对象)
                value = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userBox;
    }

    //设计一个方法 目的是将集合内所有最终的数据全部写入文件中 把文件中的所有内容替换
    public void commit(HashMap<String,User> userBox){
        //创建一个字符型文件输出流
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            Iterator<String> names = userBox.keySet().iterator();
            while(names.hasNext()){
                String name = names.next();//获取集合内某一个人名
                User user = userBox.get(name);//记录一个人的真实数据
                //将user对象中的真实数据拼接成一行字符串
                //String value = user.getName()+"-"+user.getPassword()+"-"+user.getBalance();
                StringBuilder stringBuilder = new StringBuilder(user.getName());
                //stringBuilder.append(user.getName());//也可以调用无参的构造方法
                stringBuilder.append("-");
                stringBuilder.append(user.getPassword());
                stringBuilder.append("-");
                stringBuilder.append(user.getBalance());
                //字符型文件输出流将拼接好的stringBuilder写入文件
                bufferedWriter.write(new String(stringBuilder));//或者stringBuilder.toString();
                bufferedWriter.newLine();//写一个人要换行
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
