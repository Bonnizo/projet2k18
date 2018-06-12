package projet2k18;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonMenu extends JButton{

	


	public BoutonMenu(ImageIcon img, int side, Listener listener){
		
		ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(side, side, Image.SCALE_SMOOTH));
		this.setIcon(icon);
		this.setBorder(null);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addActionListener( listener);
	      
	}

	
public BoutonMenu(ImageIcon img, int side){
		
		ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(side, side, Image.SCALE_SMOOTH));
		this.setIcon(icon);
		this.setBorder(null);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
	}

}