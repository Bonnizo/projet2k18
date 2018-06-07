package projet2k18;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class BoutonApp extends JButton{

	
	
	
	private BufferedImage image;

	
	private String file;
	
	

	public BoutonApp(String file) {
	this.file=file;
		//image 
		 try {
		        image = ImageIO.read(new File(file));
		    } catch (IOException e) {
		       setBackground(Color.WHITE);
		    }
		 
		 //taille
		setPreferredSize(new Dimension(80, 80));
		//bord rond
		setBorder(new RoundedBorder(20));
		//transparent
		setContentAreaFilled(false);
		
		
		
		
		
	}
	//placement image + dessin
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 5, 0, null);
	}
}
