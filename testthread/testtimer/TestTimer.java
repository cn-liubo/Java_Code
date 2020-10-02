package testthread.testtimer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

    private int count = 1;
    //属性 集合存储所有人的电话号码--账号
    private ArrayList<String> userBox = new ArrayList<String>();

    {
        userBox.add("a");
        userBox.add("b");
        userBox.add("c");
        userBox.add("d");
    }

    //设计一个方法 做点坏事 垃圾短信
    //每隔一段时间 发送一些数据
    public void test() throws ParseException {
        System.out.println("预备备，开始！");
        Timer timer = new Timer();//启动了一个小线程 做记录 每隔一段时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2020-10-02 11:58:00");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("第" + count++ + "次执行");
                for(int i = 0; i < userBox.size(); i++){
                    System.out.println("给"+userBox.get(i)+"发送了一条消息：[草泥马！！！]");
                }
                System.out.println("做了点坏事，真开心~~~");
            }
        }, date, 3000);
    }

    public static void main(String[] args){

        try {
            TestTimer testTimer = new TestTimer();
            testTimer.test();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
