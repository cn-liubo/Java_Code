package liubo;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dent extends Applet implements ActionListener{
	Label l1,l2,l3,l4;
	TextField t1,t2,t3,t4;
	Button b1;
	
	public void init() {
		l1=new Label("用户名");
		l2=new Label("密码");
		l3=new Label("邮箱");
		l4=new Label("电话");
		t1=new TextField(16);
		t2=new TextField(16);
		t3=new TextField(16);
		t4=new TextField(16);
		b1=new Button("登录");
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(b1);
		
		b1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if((t1.getText().equals("张三"))&&(t2.getText().equals("123456"))
				&&(t3.getText().equals("123456789"))&&(t4.getText().equals("1234567")))
		{
			System.out.println("注册成功！");
		}
		else
		{
			System.out.println("注册失败！");
		}
	}
}
