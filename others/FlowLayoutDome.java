package liubo;

import java.awt.Button;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;

public class FlowLayoutDome extends Frame {
	
	//布局管理
	public FlowLayoutDome() {
		setLayout(new FlowLayout(FlowLayout.CENTER,2,2));
		//setLayout(new GridLayout(4,4));
		add(new TextField(24));
		add(new Button("7"));
		add(new Button("8"));
		add(new Button("9"));
		add(new Button("+"));
		
		add(new Button("4"));
		add(new Button("5"));
		add(new Button("6"));
		add(new Button("-"));
		
		add(new Button("3"));
		add(new Button("2"));
		add(new Button("1"));
		add(new Button("*"));
		
		add(new Button("+"));
		add(new Button("0"));
		add(new Button("."));
		add(new Button("="));
		
//		boolean handleEvent(Event e) {
//			if(e.id==Event.WINDOW_DESTROY) {
//				if(inAnApplet) {
//					dispose();
//					
//					return true;
//				}
//				else {
//					System.exit(0);
//				}
//			}
//			return super.handleEvent(e);
//		}
//		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowLayoutDome frm=new FlowLayoutDome();
		frm.setSize(200,200);
		frm.show();
		
	}

}
