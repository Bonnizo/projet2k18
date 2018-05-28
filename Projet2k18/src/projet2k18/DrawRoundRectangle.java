package projet2k18;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;

public class DrawRoundRectangle extends JComponent {
	
	public void paint(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g;

	        g2.setPaint(Color.RED);
	        g2.setStroke(new BasicStroke(2.0f));

	        double x = 50;
	        double y = 50;
	        double w = x + 250;
	        double h = y + 100;
	        g2.draw(new RoundRectangle2D.Double(x, y, w, h, 50, 50));
	    
}
}