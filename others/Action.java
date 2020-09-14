package liubo;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Action extends Applet implements ActionListener{
	Button button;
	Button b1,b2,b3,b4;
	public void init(){
		setLayout(new BorderLayout());
		
		button=new Button("Click Me");
		b1=new Button("上");
		b2=new Button("下");
		b3=new Button("左");
		b4=new Button("右");
		
		add("Center",button);
		add("North",b1);
		add("South",b2);
		add("West",b3);
		add("East",b4);
		
		button.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Toolkit.getDefaultToolkit().beep();
//		System.out.println(e.getSource().toString());
//		Button b=(Button)e.getSource();
//		b.setLabel("点我了");
//		System.out.println(e.getActionCommand());
		if(e.getActionCommand()=="登录")
		{
			button.setLabel("登录");
		}
	}
}
