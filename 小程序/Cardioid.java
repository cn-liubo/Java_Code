package Ð¡³ÌÐò;

//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;

import java.awt.*;
import javax.swing.JFrame;

public class Cardioid extends JFrame{
	private static final int width=500;
	private static final int height=500;
	
	private static int WINDOW_width=Toolkit.getDefaultToolkit().getScreenSize().width;
	private static int WINDOW_height=Toolkit.getDefaultToolkit().getScreenSize().height;
	
	
	public Cardioid() {
		super("I LOVE YOU");
		this.setBackground(Color.BLACK);
		this.setLocation((WINDOW_width-width)/2,(WINDOW_height-height)/2);
		this.setSize(width, height);
		this.setLayout(getLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void paint(Graphics g) {
		double x,y,r;
		Image image=this.createImage(width, height);
		Graphics pic=image.getGraphics();
		for(int i=-2;i<90;i++) {
			for(int j=-2;j<90;j++) {
				r=Math.PI/45+Math.PI/45*i*(1-Math.sin(Math.PI/45*j))*18;
				x=r*Math.cos(Math.PI/45*j)*Math.sin(Math.PI/45*i)+width/2;
				y=-r*Math.sin(Math.PI/45*j)+height/3;
				pic.setColor(Color.RED);
				pic.fillOval((int)x,(int)y,2,2);
			}
			g.drawImage(image, 0, 0, this);
		}
	}
	public static void main(String[] args) {
		new Cardioid();
	}
}