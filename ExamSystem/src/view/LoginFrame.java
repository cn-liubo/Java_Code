package view;

import service.UserService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends BaseFrame {

    public LoginFrame(){
        this.init();
    }
    public LoginFrame(String title){
        super(title);
        this.init();
    }



    //创建一个面板
    private JPanel jPanel = new JPanel();
    //创建title显示标题
    private JLabel titleLabel = new JLabel("在 线 考 试 系 统");
    //创建账号和密码的标题
    private JLabel accountLabel = new JLabel("账 号：");
    private JLabel passwordLabel = new JLabel("密 码：");
    //创建输入账号和密码的文本框和密码框
    private JTextField accountFile = new JTextField();
    private JPasswordField passwordFiled = new JPasswordField();
    //创建两个按钮
    private JButton loginButton = new JButton("登 录");
    private JButton exitButton = new JButton("退 出");

    //设置每一个组件的位置 大小 字体 布局等等
    protected void setFontAndSoOn(){
        //设置组件的位置---布局管理
        jPanel.setLayout(null);//设置jPanel的布局管理方式为自定义方式
        jPanel.setBackground(Color.WHITE);

        //设置标题组件的位置
        titleLabel.setBounds(120,40,340,35);
        //设置标题组件的字体大小
        titleLabel.setFont(new Font("黑体",Font.BOLD,34));
        //设置用户名label位置和字体大小
        accountLabel.setBounds(94,124,90,30);
        accountLabel.setFont(new Font("黑体",Font.BOLD,24));
        //设置用户名filed位置和字体大小
        accountFile.setBounds(204,124,260,30);
        accountFile.setFont(new Font("黑体",Font.BOLD,24));
        //设置密码label位置和字体大小
        passwordLabel.setBounds(94,174,90,30);
        passwordLabel.setFont(new Font("黑体",Font.BOLD,24));
        //设置密码filed位置和字体大小
        passwordFiled.setBounds(204,174,260,30);
        passwordFiled.setFont(new Font("黑体",Font.BOLD,24));
        //设置登录按钮的位置和字体大小
        loginButton.setBounds(154,232,100,30);
        loginButton.setFont(new Font("黑体",Font.BOLD,22));
        //设置退出按钮的位置和字体大小
        exitButton.setBounds(304,232,100,30);
        exitButton.setFont(new Font("黑体",Font.BOLD,22));
    }

    //将所有的组件添加在窗体上
    protected void addElement(){
        //将所有的组件添加至窗体上
        jPanel.add(titleLabel);
        jPanel.add(accountLabel);
        jPanel.add(accountFile);
        jPanel.add(passwordLabel);
        jPanel.add(passwordFiled);
        jPanel.add(loginButton);
        jPanel.add(exitButton);
        this.add(jPanel);
    }

    //绑定事件监听
    protected void addListener(){
        //绑定事件监听器
        //无法new？  构造方法私有的  构造方法公有的但是没有无参的  抽象类或接口
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("你点我干嘛呀？");

                //获取用户输入的账号和密码
                //  从登录窗口的组件内获取  文本框  密码框
                String account = accountFile.getText();
                char[] value = passwordFiled.getPassword();
                String password = new String(value);
                //调用之前Service层的登录方法
                UserService service = MySpring.getBean("service.UserService");
                String result = service.login(account,password);
                //判定最终的结果
                if(result.equals("登录成功")){
                    LoginFrame.this.setVisible(false);//将登录窗口隐藏
                    //弹出新的考试界面
                    //System.out.println(result);
                    new ExamFrame("考试窗口");

                }else{
                    //弹出一个警告框 告诉登录失败
                    //System.out.println(result);
                    JOptionPane.showMessageDialog(LoginFrame.this,result);
                    //设置文本框和密码框的值为空
                    accountFile.setText("");
                    passwordFiled.setText("");
                }
            }
        };
        loginButton.addActionListener(actionListener);//观察者模式
    }

    //设置窗体自身的属性
    protected void setFrameSelf(){
        //设置窗体起始位置和大小
        this.setBounds(600,280,560,340);
        //设置点击关闭退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体大小不可拖拽
        this.setResizable(false);
        //设置窗体显示状态
        this.setVisible(true);
    }


}
