package liubo;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.*;

public class LabelDemo extends Applet implements ActionListener{
	JFrame frame;//����
	JLabel l1;
	JTextField f1;
	JLabel l3;
	JTextField f3;
	JLabel l2;
	JTextField f2;
	JLabel l4;
	JTextField f4;
	JLabel l5;
	JTextField f5;
	Button s1;
	public LabelDemo() {
		//1.������
		frame =new JFrame("JLabel Demo");
		l1=new JLabel("�û�����");
		f1=new JTextField(12);
		l2=new JLabel("���룺");
		f2=new JTextField(12);
		l3=new JLabel("�Ա�");
		f3=new JTextField(5);
		l4=new JLabel("���䣺");
		f4=new JTextField(24);
		l5=new JLabel("�ֻ��ţ�");
		f5=new JTextField(24);
		setLayout(new BorderLayout());
		s1=new Button("��¼");
		//2.���ù�����
		frame.setLayout(new GridLayout(0,2));
//   	frame.setFont(newFont("Helvetica",Font.PLAIN,14));
		frame.add(l1);
		frame.add(f1);
		frame.add(l2);
		frame.add(f2);
		frame.add(l3);
		frame.add(f3);
		frame.add(l4);
		frame.add(f4);
		frame.add(l5);
		frame.add(f5);
		frame.add("South",s1);
		
		s1.addActionListener(this);
		frame.setSize(300, 300);
		frame.setVisible(true);
}
//	private Font newFont(String string, int plain, int i) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public void actionPerformed(ActionEvent e) {	
		if(f1.getText().equals("����")&&(f2.getText().equals("123456"))&&(f3.getText().equals("��"))&&(f4.getText().equals("394585940@qq.com"))&&(f5.getText().equals("13659278771"))) {
		System.out.println("��¼�ɹ�");
	}
	else
	System.out.println("��¼ʧ��");
}
public static void main(String[] args){
	new LabelDemo();
}
}

