package liubo;

import java.awt.*;
import java.applet.*;

public class SimpleApplet extends Applet{
	
	static int counter=0;
	
	public void paint(Graphics g) {
		
		counter++;
		g.setColor(Color.green);
		g.drawRect(10,10,200,200);
		g.draw3DRect(0,1,300,300,true);
		System.out.println("÷ÿªÊ¡À"+counter);
		
		
		
		
	}
}
