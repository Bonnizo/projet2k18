package projet2k18;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder implements Border {

	
	private int radius;
	
	RoundedBorder(int radius) {
		// TODO Auto-generated method stub
		this.radius = radius;
		}
	@Override
	public Insets getBorderInsets(Component C) {
		// TODO Auto-generated method stub
	return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
		// TODO true;
	}

	@Override
	public void paintBorder(Component C, Graphics g, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
	g.drawRoundRect(x,y, width-1, height-1, radius, radius);

	}

}
