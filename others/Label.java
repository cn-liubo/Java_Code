package liubo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;

public class Label {
	JFrame frame;
	JLabel l1;
	JLabel l2;
	JTextField t1;
	
	public Label() {
		//������
		frame=new JFrame("JLabel");
		frame.setSize(800,600);//��λΪ����
		frame.setVisible(true);
		l1=new JLabel("����һ����̬�ı���");
		l2=new JLabel("<thml><a href=www.baidu.com>�ٶ�����</a></thml>");
    	t1=new JTextField("JTextFiled");
		
		
		//������
		
		frame.getContentPane().add(l1);
		frame.getContentPane().add(l2);
		
		//�¼�����
//		t1.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println(t1.getText());
//			}
//			
//		});
		l2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("cmd/c start http://www.baidu.com");
				}catch(IOException ee) {
					ee.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args)
	{
		new Label();
	}
}
