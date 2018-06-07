package projet2k18;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class BoutonNav extends JButton{

	
	private BufferedImage image;

	
	private String file;
	
	

	public BoutonNav(String file) {
		this.file=file;
		//image
		 try {
		        image = ImageIO.read(new File(file));
		    } catch (IOException e) {
		    	 setBackground(Color.WHITE);
		    }
		 
		 //taille
		setPreferredSize(new Dimension(42, 42));
		
		//transparent
		setContentAreaFilled(false);
		
		//no bord
		setBorderPainted(false);
		
		//pas de focus sur le bouton
		setFocusable(false);
		
		
		
	}
	//placement image + dessin
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null);
	}
}
