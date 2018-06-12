package projet2k18;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * <b>Class BoutonMenu permet de créer les boutons directement avec une image et un Listener.</b>
 * <p>
 * Class surtout utilisé pour les boutons de FrameMain qui permettent de naviguer dans les différents panels 
 *  
 * </p>
 * 
 * 
 * 
 * 
 * 
 * @see Listener
 * @see FrameMain
 * 
 * 
 * @author Victor
 *
 */
public class BoutonMenu extends JButton{

	


	public BoutonMenu(ImageIcon img, int side, Listener listener){
		
		
		//permet de créer l'image et la resize directement
		ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(side, side, Image.SCALE_SMOOTH));
		//image ajouter au bouton
		this.setIcon(icon);
		//sans bordure
		this.setBorder(null);
		// getion de l'affichage : sans fond , sans bord, sans focus , changemnt du curseur + rajout de l'action sur bouton
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addActionListener( listener);
	      
	}

	// meme chose juste pas d'action
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