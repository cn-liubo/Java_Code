package view;

import domain.Question;
import service.QuestionService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExamFrame extends BaseFrame {

    //获取QuestionService对象
    private QuestionService service = MySpring.getBean("service.QuestionService");
    //通过service调用getPaper方法获取一套随机生成的试卷
    private ArrayList<Question> paper = service.getPaper(5);
    //创建一个用于存储学生选择的答案的容器
    private String[] answers = new String[paper.size()];

    //创建几个变量 分别控制右侧message个数
    private int number = 0;//记录当前题目序号
    private int totalCount = paper.size();//记录试题总数
    private int answerCount = 0;//记录已经回答完毕的题目数量
    private int unanswerCount = totalCount;//记录未回答的题目数量

    //创建一个线程对象 控制时间的变化
    private TimeControlThread timeControlThread = new TimeControlThread();
    //创建一个变量 用来记录时间（以分钟为单位）
    private int time = 90;



    //添加构造方法
    public ExamFrame(){
        this.init();
    }
    public ExamFrame(String title){
        super(title);
        this.init();
    }


    //添加好多属性--各种组件
    //添加三个panel区域的分割
    private JPanel mainPanel = new JPanel();//负责答题主页面展示
    private JPanel messagePanel = new JPanel();//负责右侧信息展示
    private JPanel buttonPanel = new JPanel();//负责下方按钮展示

    //添加主要答题组件
    private JTextArea examArea = new JTextArea();//考试文本域 展示题目
    private JScrollPane scrollPane = new JScrollPane(examArea);//滚动条
    //添加右侧信息的组件
    private JLabel pictureLabel = new JLabel();//展示图片信息
    private JLabel numberLabel = new JLabel("当前题号：");//提示当前的题号
    private JLabel totalCountLabel = new JLabel("题目总数：");//提示题目总数
    private JLabel answerCountLabel = new JLabel("已答题数：");//提示已答过的题目数量
    private JLabel unanswerCountLabel = new JLabel("未答题数：");//提示未答题目数量
    private JTextField numberField = new JTextField("0");//展示当前的题号
    private JTextField totalCountField = new JTextField("0");//展示题目总数
    private JTextField answerCountField = new JTextField("0");//展示已答过的题目数量
    private JTextField unanswerCountField = new JTextField("0");//提示未答题目数量
    private JLabel timeLabel = new JLabel("剩余答题时间：");//提示剩余时间
    private JLabel realTimeLabel = new JLabel("00:00:00");//倒计时真实时间

    //添加下方按钮组件
    private JButton aButton = new JButton("A");//A按钮
    private JButton bButton = new JButton("B");//B按钮
    private JButton cButton = new JButton("C");//C按钮
    private JButton dButton = new JButton("D");//D按钮
    private JButton prevButton = new JButton("上一题");//previous
    private JButton nextButton = new JButton("下一题");//next
    private JButton submitButton = new JButton("提交试卷");//提交按钮


    //方法-->属性设置 字体 背景 位置 布局 等等
    @Override
    protected void setFontAndSoOn() {
        //设置panel布局管理-->自定义
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.LIGHT_GRAY);
        messagePanel.setLayout(null);
        //设置massage区域的位置
        messagePanel.setBounds(680,10,300,550);
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        buttonPanel.setLayout(null);
        //设置button区域的位置
        buttonPanel.setBounds(16,470,650,90);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //手动设置每一个组件的位置 字体 背景
        scrollPane.setBounds(16,10,650,450);
        examArea.setFont(new Font("黑体",Font.BOLD,34));
        //展示第一道题目
        examArea.setEnabled(false);//让文本域的文字不能编辑
        //设置message区域中的每一个组件的位置 大小 颜色
        pictureLabel.setBounds(10,10,280,230);
        pictureLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //pictureLabel.setIcon(null);//展示图片信息
        numberLabel.setBounds(40,270,100,30);
        numberLabel.setFont(new Font("黑体",Font.PLAIN,20));
        numberField.setBounds(150,270,100,30);
        numberField.setFont(new Font("黑体",Font.BOLD,20));
        numberField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        numberField.setEnabled(false);
        numberField.setHorizontalAlignment(JTextField.CENTER);

        totalCountLabel.setBounds(40,310,100,30);
        totalCountLabel.setFont(new Font("黑体",Font.PLAIN,20));
        totalCountField.setBounds(150,310,100,30);
        totalCountField.setFont(new Font("黑体",Font.BOLD,20));
        totalCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        totalCountField.setEnabled(false);
        totalCountField.setHorizontalAlignment(JTextField.CENTER);

        answerCountLabel.setBounds(40,350,100,30);
        answerCountLabel.setFont(new Font("黑体",Font.PLAIN,20));
        answerCountField.setBounds(150,350,100,30);
        answerCountField.setFont(new Font("黑体",Font.BOLD,20));
        answerCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        answerCountField.setEnabled(false);
        answerCountField.setHorizontalAlignment(JTextField.CENTER);

        unanswerCountLabel.setBounds(40,390,100,30);
        unanswerCountLabel.setFont(new Font("黑体",Font.PLAIN,20));
        unanswerCountField.setBounds(150,390,100,30);
        unanswerCountField.setFont(new Font("黑体",Font.BOLD,20));
        unanswerCountField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        unanswerCountField.setEnabled(false);
        unanswerCountField.setHorizontalAlignment(JTextField.CENTER);

        timeLabel.setBounds(90,460,150,30);
        timeLabel.setFont(new Font("黑体",Font.PLAIN,20));
        timeLabel.setForeground(Color.BLUE);
        realTimeLabel.setBounds(108,490,150,30);
        realTimeLabel.setFont(new Font("黑体",Font.BOLD,20));
        realTimeLabel.setForeground(Color.BLUE);

        aButton.setBounds(40,10,120,30);
        aButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//点击按钮是箭头的光标变为手型色光标
        bButton.setBounds(190,10,120,30);
        bButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cButton.setBounds(340,10,120,30);
        cButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dButton.setBounds(490,10,120,30);
        dButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        prevButton.setBounds(40,50,100,30);
        prevButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nextButton.setBounds(510,50,100,30);
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.setBounds(275,50,100,30);
        submitButton.setForeground(Color.RED);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        //展示第一道考试题
        this.showQuestionAndPicture();
        //重新设置右侧message中组件值--用变量控制
        numberField.setText(number+1+"");
        totalCountField.setText(totalCount+"");
        answerCountField.setText(answerCount+"");
        unanswerCountField.setText(unanswerCount+"");

        realTimeLabel.setText(time+"");
    }

    //方法-->互相添加在一起
    @Override
    protected void addElement() {
        messagePanel.add(pictureLabel);
        messagePanel.add(numberLabel);
        messagePanel.add(numberField);
        messagePanel.add(totalCountLabel);
        messagePanel.add(totalCountField);
        messagePanel.add(answerCountLabel);
        messagePanel.add(answerCountField);
        messagePanel.add(unanswerCountLabel);
        messagePanel.add(unanswerCountField);
        messagePanel.add(timeLabel);
        messagePanel.add(realTimeLabel);
        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        buttonPanel.add(cButton);
        buttonPanel.add(dButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);
        mainPanel.add(scrollPane);
        mainPanel.add(messagePanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
    }

    //方法-->添加事件监听
    @Override
    protected void addListener() {
        //创建一个监听器对象 用于四个按钮
        ActionListener optionLiatener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //清除之前所有选项的按钮颜色
                ExamFrame.this.clearOptionButtonColor();
                //让被点中的按钮颜色变化一下
                JButton button = (JButton) e.getSource();//获取到哪一个按钮点击了
                //让当前的按钮颜色变化一下
                button.setBackground(Color.YELLOW);
                //将当前按钮的选项存储在answers数组中
                answers[number] = button.getText();
            }
        };

        //创建一个监听器对象用于下一个题按钮
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //先清除所有选项按钮的颜色
                ExamFrame.this.clearOptionButtonColor();
                //当前题目序号增加一个
                number++;
                //当前题目是否到达最后
                if(number == totalCount){//到达最后一道题
                    examArea.setText("全部题目已经回答完毕\n请点击提交按钮");
                    //全部题目都回答完毕 让下一题的按钮失效
                    nextButton.setEnabled(false);//不可用
                    //让全部选项按钮失效
                    ExamFrame.this.setOptionButtonEnable(false);
                }else{//还没有到最后一道 后面还有题目
                    //调用自己封装的方法显示下一题目和图片
                    ExamFrame.this.showQuestionAndPicture();
                    //修改右侧的当前题号
                    numberField.setText(number+1+"");
                }
                //修改右侧 已答题和未答题数
                answerCountField.setText(++answerCount+"");
                unanswerCountField.setText(--unanswerCount+"");
            }
        });

        //创建一个监听器对象 用于上一题按钮
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //清除所有按钮的颜色
                ExamFrame.this.clearOptionButtonColor();
                //还原四个选项的状态 变成可用
                ExamFrame.this.setOptionButtonEnable(true);//可用
                //设置下一题按钮可用
                nextButton.setEnabled(true);
                //当前题目序号减少一个
                number--;
                //如果当前题号为0，已经到达第一题 让上一题按钮禁用
                if(number == 0){
                    prevButton.setEnabled(false);
                }
                //还原之前这道题选择的是那一道选项
                ExamFrame.this.restoreButton();
                //显示题目
                ExamFrame.this.showQuestionAndPicture();
                //修改右侧题号 已答题 未答题
                numberField.setText(number+1+"");
                answerCountField.setText(--answerCount+"");
                unanswerCountField.setText(++unanswerCount+"");
            }
        });

        //创建一个监听器对象 用于提交按钮
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示一个确认框 是-0 否-1 取消-2
                int value = JOptionPane.showConfirmDialog(ExamFrame.this,"是否确认提交试卷？");
                if(value == 0) {
                    //倒计时的时间停止
                    //timeControlThread.stop();//已弃用
                    timeControlThread.stopTimeThread();//切换了线程的状态
                    //让所有按钮失效
                    ExamFrame.this.setOptionButtonEnable(false);
                    prevButton.setEnabled(false);
                    nextButton.setEnabled(false);
                    //让按钮的颜色回到本色
                    ExamFrame.this.clearOptionButtonColor();
                    //最终成绩的计算 展示在中间的文本域中
                    float score = ExamFrame.this.checkPaper();
                    examArea.setText("考试结束，您的最终成绩是：" + score);
                }
            }
        });

        //将这个监听器对象绑定在四个选项按钮上
        aButton.addActionListener(optionLiatener);
        bButton.addActionListener(optionLiatener);
        cButton.addActionListener(optionLiatener);
        dButton.addActionListener(optionLiatener);
    }

    //方法-->设置窗体自己的信息
    @Override
    protected void setFrameSelf() {
        this.setBounds(260,130,1000,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);//不想让窗体拖拽
        this.setVisible(true);//最终展示整个窗体
        timeControlThread.start();//启动自己定义的线程对象 进入就绪状态 执行时间的处理
    }



    //设计一个内部类 处理时间倒计时问题
    private class TimeControlThread extends Thread{
        private boolean flag = true;//此时正常执行线程处理

//        public void stopTimeThread(boolean flag) {
//            this.flag = flag;
//        }
        public void stopTimeThread() {
            this.flag = false;
        }

        public void run(){
            //time进行一个转化  00:00:00
            int hour = time/60;
            int minute = time%60;
            int second = 0;

            while(flag){
                //操作realTimeLabel 处理时间的显示
                StringBuilder timeString = new StringBuilder();
                //处理小时
                if(hour >= 0 && hour < 10){
                    timeString.append("0");
                }
                timeString.append(hour);
                timeString.append(":");
                //处理分钟
                if(minute >= 0 && minute < 10){
                    timeString.append("0");
                }
                timeString.append(minute);
                timeString.append(":");
                //处理秒
                if(second >= 0 && second < 10){
                    timeString.append("0");
                }
                timeString.append(second);
                //展示一下拼接以后的时间字符串
                realTimeLabel.setText(timeString.toString());

                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //改变
                if(second > 0){
                    second--;
                }else{//秒为0
                    if(minute > 0){
                        minute--;
                        second = 59;
                    }else{
                        if(hour > 0){
                            hour--;
                            minute = 59;
                            second = 59;
                        }else{
                            //System.out.println("时间截止");
                            //时间显示为红色
                            realTimeLabel.setForeground(Color.RED);
                            ExamFrame.this.setOptionButtonEnable(false);
                            prevButton.setEnabled(false);
                            nextButton.setEnabled(false);
                            //弹出一个消息框 告诉考试结束 请提交
                            JOptionPane.showMessageDialog(ExamFrame.this,"考试结束，请提交试卷");
                            break;
                        }
                    }
                }
            }
        }
    }

    //设计一个方法 负责计算最终的成绩
    private float checkPaper(){
        float score = 100;
        int size = paper.size();
        for(int i = 0; i < size; i++){
            Question question = paper.get(i);
            String realAnswer = question.getAnswer();
            if(!realAnswer.equals(answers[i])){
                score -= (100/size);
            }
        }
        return score;
    }

    //设计一个方法 负责还原上一题的选项
    private void restoreButton(){
        //获取当前题目的答案(学生选择的答案)
        String answer = answers[number];
        if(answer == null){
            return;
        }
        switch (answer){
            case "A":
                aButton.setBackground(Color.YELLOW);
                break;
            case "B":
                bButton.setBackground(Color.YELLOW);
                break;
            case "C":
                cButton.setBackground(Color.YELLOW);
                break;
            case "D":
                dButton.setBackground(Color.YELLOW);
                break;
            default:
                this.clearOptionButtonColor();

        }
    }

    //设计一个方法 让全部选项按钮失效
    private void setOptionButtonEnable(boolean key){
        aButton.setEnabled(key);
        bButton.setEnabled(key);
        cButton.setEnabled(key);
        dButton.setEnabled(key);
    }

    //设计一个方法 清除所有选项按钮颜色
    private void clearOptionButtonColor(){
        aButton.setBackground(null);
        bButton.setBackground(null);
        cButton.setBackground(null);
        dButton.setBackground(null);
    }

    //设计一个方法 用来处理图片展示
    private ImageIcon drawImage(String path){
        //通过给定的路径创建一个icon对象
        ImageIcon imageIcon = new ImageIcon(path);
        //设置imageIcon对象内的image属性
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(290,230,Image.SCALE_DEFAULT));
        //将设置好的imageIcon对象返回
        return imageIcon;
    }

    //设计一个方法 用来展示一道题目
    private void showQuestionAndPicture(){
        //从paper中获取当前的一道题目
        Question question = paper.get(number);//三个属性 题干 答案 图片路径(有可能是null)
        //获取当前question中的图片路径
        String picture = question.getPicture();//图片路径
        if(picture != null){//有图片路径信息
            //展示图片
            pictureLabel.setIcon(this.drawImage("src//img//"+picture));
        }else{//没有图片信息
            pictureLabel.setIcon(null);
        }
        //处理题目中的一个标记 <br>表示换行
        String value = question.getTitle().replace("<br>","\n   ");
        examArea.setText((number+1)+"."+value);
    }

}
