package liubo;

import java.awt.*;
import java.applet.Applet;

public class javaExample extends Applet {
	String a="Hello Java";
	public void paint(Graphics g)
	{
		g.drawString(a,100,100);
	}
}
/*import java.applet.Applet;
import java.awt.Graphics;

public class Java extends Applet {
	String a="Hello Java";
	public void paint(Graphics g)
	{
		g.drawString(a,100,100);
	}
}*/