package 练习;

import java.util.ArrayList;

public class Teacher {

    //方法 负责批卷子
    //参数 学生作答的所有选项  真实的的试卷 跟学生随机的那套一致
    //返回值 成绩
    public int checkPaper(ArrayList<Question> paper,String[] answers){
        System.out.println("老师正在批阅试卷，请耐心等待。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int score = 0;
        for(int i = 0; i < paper.size(); i++){
            Question question = paper.get(i);
            if(question.getAnswer().equalsIgnoreCase(answers[i])) {
                score += 100/paper.size(); //100/paper.size()
            }
        }
        return score;
    }
}
