
package liubo;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse extends Applet implements MouseListener{
	TextArea ar;
	public void init() {
		ar=new TextArea();
		add(ar);
		ar.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ar.setText("���㵽"+e.getX()+":"+e.getY());
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ar.setText("��������");
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ar.setText("����Ƴ���");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ar.setText("�������");
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ar.setText("����ɿ���");
	}
	
}
