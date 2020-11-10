package test;

import domain.Question;
import service.QuestionService;
import util.MySpring;
import view.LoginFrame;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args){
        new LoginFrame("登录窗口");

//        QuestionService service = MySpring.getBean("service.QuestionService");
//        ArrayList<Question> paper = service.getPaper(5);
//        for(int i = 0; i < paper.size(); i++){
//            Question question = paper.get(i);
//            String title = question.getTitle().replace("<br>","\n");
//            System.out.println((i+1)+"."+title);
//        }

    }
}
