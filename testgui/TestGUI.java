package testgui;

import javax.swing.*;

@SuppressWarnings("all")
public class TestGUI {

    public static void main(String[] args){
        //jFrame 最大的窗体  管理方式边界式  中 东 西 南 北  BorderLayout
        //JMenuBar 菜单条上面  jFrame.setJMenuBar(jMenuBar);
        //JPanel 面板 可以有多个  管理方式流式 居中  FlowLayout
        //

        //创建一个窗体
        JFrame jFrame = new JFrame();
        //创建一个面板
        JPanel jPanel = new JPanel();

        //创建一个标签
        JLabel userLabel = new JLabel("账户：");
        JLabel passLabel = new JLabel("密码：");
        //创建一个文本框
        JTextField jTextField = new JTextField(20);
        //密码框
        JPasswordField jPasswordField = new JPasswordField(20);
        //创建一个按钮对象
        JButton jButton = new JButton("登录");
        //jButton.setText("按钮");

        //创建复选框
        JCheckBox jCheckBox1 = new JCheckBox("抽烟");
        JCheckBox jCheckBox2 = new JCheckBox("喝酒");
        JCheckBox jCheckBox3 = new JCheckBox("烫头");

        //创建单选按钮
        JRadioButton jRadioButton1 = new JRadioButton("男");
        JRadioButton jRadioButton2 = new JRadioButton("女");
        //将两个单选按钮添加在一个组里面
        ButtonGroup buttonGroup = new ButtonGroup();//组本身不是组件
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);

        //创建文本域
        JTextArea jTextArea = new JTextArea(5,20);
        //滚动条
        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        //菜单条  JMenuBar
        //菜单    JMenu
        //菜单项  JMenuItem
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        JMenuItem jMenuItem = new JMenuItem("New");

        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);


        //将按钮添加到窗体内
        jPanel.add(userLabel);
        jPanel.add(jTextField);
        jPanel.add(passLabel);
        jPanel.add(jPasswordField);
        jPanel.add(jButton);
        jPanel.add(jCheckBox1);
        jPanel.add(jCheckBox2);
        jPanel.add(jCheckBox3);
        jPanel.add(jRadioButton1);
        jPanel.add(jRadioButton2);
        jPanel.add(jScrollPane);

        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);

        //设置不可以拖拽大小
        //jFrame.setResizable(false);

        //设置窗体出现时的位置和自身的宽高
        jFrame.setBounds(500,250,300,150);
        //设置窗体的title
        jFrame.setTitle("这是我的第一个窗体");//也可以在new的时候传参

        //设置窗体的状态显示
        jFrame.setVisible(true);
        //设置点击关闭按钮 窗体执行完毕
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
