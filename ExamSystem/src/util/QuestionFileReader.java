package util;

import domain.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class QuestionFileReader {

    //程序执行时 将文件中的题目 一次性读取出来
    private HashSet<Question> questionsBox = new HashSet<>();

    {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src//datafile//Question.txt"));
            String message = reader.readLine();
            while(message != null){
                String[] values = message.split("#");
                if(values.length == 2){//没有图片信息 只有题干和答案
                    questionsBox.add(new Question(values[0],values[1]));
                }else if(values.length == 3){//含有图片信息
                    questionsBox.add(new Question(values[0],values[1],values[2]));
                }
                message = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public HashSet<Question> getQuestionsBox() {
        return questionsBox;
    }
}
