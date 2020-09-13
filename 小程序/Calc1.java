package С����;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc1 extends JFrame implements ActionListener{
	String[] KEYS= {"1","2","3","+","4","5","6","-","7","8","9","*","0",".","/","="};
	JButton keys[]=new JButton[KEYS.length];
	JButton jbClean=new JButton("clean");
	JTextField resultText=new JTextField("0",10);
	
	//��־ �û������Ƿ����������ʽ�ĵ�һ�����֣��������������ĵ�һ������
	private boolean firstDigit=true;
	//������м���
	private double resultNum=0.0;
	//��ǰ����������
	private String operator="=";
	//�����Ƿ�Ϸ�
	private boolean operateValidFlag=true;
	
	public Calc1() {
		init();
		//���ü������ı�����ɫ
		this.setBackground(Color.LIGHT_GRAY);
		this.setTitle("������");
		//����Ļ(500,300)���괦��ʾ������
		this.setLocation(500,300);
		//�����޸� �������Ĵ�С
		this.setResizable(true);
		//���ÿɼ�
		this.setVisible(true);
		//ʹ�������и��������С����
		this.pack();
	}
	
	private void init() {
		//�ı����е�����Ϊ���Ҷ��뷽ʽ
		resultText.setHorizontalAlignment(JTextField.RIGHT);
		//�������޸Ľ���ı���
		resultText.setEditable(false);
		//�����ı��򱳾���ɫΪ��ɫ
		resultText.setBackground(Color.WHITE);
		
		JPanel toppanel=new JPanel();
		toppanel.add(resultText);
		jbClean.setForeground(Color.RED);
		toppanel.add(jbClean);
		
		JPanel calckeysPanel=new JPanel();
		calckeysPanel.setLayout(new GridLayout(4,4));
		for(int i=0;i<KEYS.length;i++) {
			keys[i]=new JButton(KEYS[i]);
			calckeysPanel.add(keys[i]);
			keys[i].setForeground(Color.BLUE);
		}
		//���ü���
		for(int i=0;i<KEYS.length;i++) {
			keys[i].addActionListener(this);
		}
		    jbClean.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(toppanel,BorderLayout.NORTH);
		this.add(calckeysPanel,BorderLayout.CENTER);
	}
	
	//ʱ�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//��ȡ�¼�Դ�ı�ǩ
		String label=e.getActionCommand();
		if("0123456789.".indexOf(label)>=0) {
			//�û�����ʨ�Ӽ�����С�����
			handleNumber(label);
			
		}else if(label=="clean"){
			//�û������������
			resultText.setText("");
		}
		else {
			//�û��������������
			handleOperator(label);
		}
	}
	
	//�������ּ������µ��¼�
	private void handleNumber(String key) {
		// TODO Auto-generated method stub
		if(firstDigit) {
			resultText.setText(key);
		}else if((key.equals("."))&&(resultText.getText().indexOf(".")<0)){
			//�������С���㣬����֮ǰû��С���㣬��С���㸽�ڽ���ı���ĺ���
			resultText.setText(resultText.getText()+".");
		}else if(!key.equals(".")) {
			//�������Ĳ���С���㣬�����ָ��ڽ���ı���ĺ���
			resultText.setText(resultText.getText()+key);
		}
		//�Ժ�����϶����� ��һ��������
		firstDigit=false;
	}

	//��������������µ��¼�
	private void handleOperator(String key) {
		// TODO Auto-generated method stub
		if(operator.equals("/")) {
			//��������
			//�����ǰ����ı����е�ֵ=0
			if(getNumberFormText()==0.0) {
				//�������Ϸ�
				operateValidFlag=false;
				resultText.setText("��������Ϊ��");
			}else {
				resultNum/=getNumberFormText();
			}
		}else if(operator.equals("+")) {
			//�ӷ�����
			resultNum+=getNumberFormText();
		}else if(operator.equals("-")) {
			//��������
			resultNum-=getNumberFormText();
		}else if(operator.equals("*")) {
			//�˷�����
			resultNum*=getNumberFormText();
		}else if(operator.equalsIgnoreCase("/")) {
			//��������
			resultNum=getNumberFormText();
		}else if(operator.equals("=")) {
			//��ֵ����
			resultNum=getNumberFormText();
		}
		if(operateValidFlag) {
			//˫���ȸ�����������
			long t1;
			double t2;
			t1=(long)resultNum;
			t2=resultNum-t1;
			if(t2==0) {
				resultText.setText(String.valueOf(t1));
			}else {
				resultText.setText(String.valueOf(resultNum));
			}
		}
		//����������û����İ�ť
		operator=key;
		firstDigit=true;
		operateValidFlag=true;
	}
	
	//�ӽ���ı����л�ȡ����
	private double getNumberFormText() {
		// TODO Auto-generated method stub
		double result=0;
		try {
			result=Double.valueOf(resultText.getText()).doubleValue();
		}catch(NumberFormatException e) {
			
		}
		return result;
	}
	public static void main(String[] args) {
		new Calc1();
	}

	

}
