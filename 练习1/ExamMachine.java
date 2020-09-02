package 练习;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ExamMachine {

    //属性  记录学生的账号和密码
    private HashMap<String,String> userBox = new HashMap<String,String>();
    {
        userBox.put("张三","123");
        userBox.put("李四","666");
        userBox.put("王五","888");
    }

    //属性--题库 好多个Question类型的对象 每一个对象是一道题目
    // Set集合 如果题目进行扩充 产生重复题目可以自动去掉了
    // hash集合遵循的规则 equals()和hashCode()方法
    private HashSet<Question> questionsBank = new HashSet<Question>();
    //利用块初始化hashSet集合内的题目对象
    {
        questionsBank.add(new Question("以下选项哪个是Java基本数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionsBank.add(new Question("以下选项哪个不是Java基本数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.double","A"));
        questionsBank.add(new Question("以下选项哪个是Java引用数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.char","A"));
        questionsBank.add(new Question("以下选项哪个不是Java引用数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionsBank.add(new Question("以下选项哪个是java.util包中的类?\n\tA.String\n\tB.Integer\n\tC.Scanner\n\tD.Math","C"));
        questionsBank.add(new Question("以下选项哪个不是java.util包中的类?\n\tA.Date\n\tB.Integer\n\tC.Calendar\n\tD.Random","B"));
        questionsBank.add(new Question("以下选项哪个不是String类中的方法?\n\tA.compareTo\n\tB.append\n\tC.substring\n\tD.concat","B"));
        questionsBank.add(new Question("以下选项哪个是String类中的方法?\n\tA.append\n\tB.delete\n\tC.insert\n\tD.concat","D"));
        questionsBank.add(new Question("以下选项哪个不是接口中属性的修饰符?\n\tA.public\n\tB.static\n\tC.final\n\tD.abstract","D"));
        questionsBank.add(new Question("以下选项哪个不是Set集合中的方法?\n\tA.set\n\tB.add\n\tC.remove\n\tD.iterator","A"));
    }

    //设计一个方法 随机生成试卷
    // 参数 确定试卷5道题，则不用    返回值  试卷集合ArrayList<Question>
    public ArrayList<Question> getPaper(){
        System.out.println("考试机正在随机生成试卷，请耐心等待！");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //随机抽取试卷的时候  试卷的题目应该是不重复的  Set存-->arrayList
        HashSet<Question> paper = new HashSet<Question>();//试卷
        //产生一个随机序号 去找寻题目  题库是一个set集合没有序号--题库-->ArrayList
        ArrayList<Question> questionBank = new ArrayList<Question>(this.questionsBank);
        //随机抽题
        while(paper.size() != 5) {
            int index = new Random().nextInt(this.questionsBank.size());//[0-10)
            Question question = questionBank.get(index);
            paper.add(question);
        }
        return new ArrayList<Question>(paper);
    }

    //考试机还有一个登录方法
    public String login(String username,String password){
        String realPassWord = this.userBox.get(username);
        if(realPassWord != null && realPassWord.equals(password)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }

}
