package 练习;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        //创建考试机
        ExamMachine machine = new ExamMachine();//调用构造方法时，块默认执行
        //创建学生对象 考试
        Scanner input = new Scanner(System.in);
        System.out.println("**欢迎进入考试系统！**");
        System.out.println("请输入用户名");
        String username = input.nextLine();
        System.out.println("请输入密码");
        String password = input.nextLine();
        Student student = new Student(username, password);
        String result = machine.login(student.getUsername(),student.getPassword());
        if(result.equals("登录成功")) {
            System.out.println("登录成功\n"+student.getUsername()+"开始考试，请认真作答，不要作弊");
            ArrayList<Question> paper = machine.getPaper();//考试机随机抽取一套试卷
            String[] answers = student.exam(paper);//学生考试
            Teacher teacher = new Teacher();
            int score = teacher.checkPaper(paper,answers);
            System.out.println(student.getUsername()+"最终的成绩是："+score);
        }


//        Question question = new Question("1.如下选项那个不是Java基本数据类型？\n\tA.String\n\tB.char\n\tC.int\n\tD.double","A");
//        System.out.println(question.getTitle());
        //题干 答案 两个字符串 需要存储在一起 变成一个完整的题目
        //String[2] {"title","answer"}
        //String  "title-answer"
        //ArrayList<String[]>
        //HashMap<title,answer>
        //面向对象的编程思想 -- 一道题目当做一个对象？title属性 answer属性
    }
}
