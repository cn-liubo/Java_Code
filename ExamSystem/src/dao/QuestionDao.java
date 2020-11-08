package dao;

import domain.Question;
import util.MySpring;
import util.QuestionFileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class QuestionDao {

    //获取缓存对象
    private QuestionFileReader reader = MySpring.getBean("util.QuestionFileReader");
    //将缓存中的集合临时改为list集合 为了随机找元素的时候存在位置
    private ArrayList<Question> questionBank = new ArrayList<>(reader.getQuestionsBox());

    //负责读文件 随机生成一套试卷 题库10道题目，生成5道
    // 参数 5道题目  返回值 ArrayList<QuestionService>
    public ArrayList<Question> getPaper(int count){
        HashSet<Question> paper = new HashSet<>();//用来存储最终的试卷题目
        while(paper.size() != count){
            //Math.random();  Random
            Random random = new Random();//随机数对象  0--9
            int index = random.nextInt(this.questionBank.size());//随机产生的一个题目索引位置 [0,10)
            paper.add(this.questionBank.get(index));
        }

        return new ArrayList<Question>(paper);

//        //创建一个文件输入流 读取文件(题库)
//        BufferedReader reader = null;
//        try {
//             reader = new BufferedReader(new FileReader("src//datafile//QuestionService.txt"));
//             String message = reader.readLine();
//            //解析读取到的题目 创建一个Question对象
//            //问题 从头读取 不会出现重复 但每一个人的试卷都一样--随机
//            //问题 读取性能很慢 最好携带缓存机制
//
////            while(message != null){
////                String[] values = message.split("#");
////                QuestionService question = new QuestionService(values[0],values[1]);
////                //让抽取的题目没有重复-->HashSet(equals hashCode) TreeSet(compareTo)
////                paper.add(question);
////                if(paper.size() != 5){
////                    message = reader.readLine();
////                }
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

}
