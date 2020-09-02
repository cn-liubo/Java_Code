package 集合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LoginService {

    //设计一个方法 用来登录认证  一维数组
//    private String[] userBox = new String[]{"张三","李四","王五"};
//    private int[] passwordBox = new int[]{123,666,888};
//
//    public String loginForArray(String name,String password){
//
//        for(int i = 0; i < userBox.length; i++){
//            if(userBox[i].equals(name)){
//                if(passwordBox[i] == Integer.parseInt(password)){
//                    return "登录成功";
//                }
//                break;
//            }
//        }
//        return "用户名或密码错误";
//    }

    //设计一个方法 同来登录认证--ArrayList
//    private ArrayList<String> userBox = new ArrayList<>();
//    {
//        userBox.add("张三-123");
//        userBox.add("李四-666");
//        userBox.add("王五-888");
//    }
//    public String loginForList(String name,String password){
//        for(int i = 0; i < userBox.size(); i++){
//            String[] value = userBox.get(i).split("-");//一个人的信息
//            if(value[0].equals(name)){
//                if(value[1].equals(password)){
//                    return "登录成功";
//                }
//                break;
//            }
//        }
//        return "登录失败";
//    }

//    //设计一个方法 同来登录认证--Set
//    private HashSet<String> userBox = new HashSet<>();
//    {
//        userBox.add("张三-123");
//        userBox.add("李四-666");
//        userBox.add("王五-888");
//    }
//    public String loginForSet(String name,String password){
//        Iterator<String> it = userBox.iterator();
//        while(it.hasNext()){
//            String[] value = it.next().split("-");
//            if(value[0].equals(name)){
//                if(value[1].equals(password)){
//                    return "登录成功";
//                }
//                break;
//            }
//        }
//        return "登录失败";
//    }

    //设计一个方法 同来登录认证--Map
    private HashMap<String,Integer> userBox = new HashMap<>();
    {
        userBox.put("张三",123);
        userBox.put("李四",666);
        userBox.put("王五",888);
    }
    public String loginForMap(String name,String password){
        Integer realPassWord = userBox.get(name);
        if(realPassWord != null){//用户名存在
            if(realPassWord.equals(Integer.parseInt(password))){
                return "登录成功";
            }
        }
        return "登录失败";
    }
}
