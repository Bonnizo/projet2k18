package Jeu;


import java.awt.Color;  
import java.awt.Font;  
import java.awt.event.FocusAdapter;  
import java.awt.event.FocusEvent;  
import javax.swing.JTextField;  

import javax.swing.JTextField;

/**
 * Permet d'afficher du text en gris claire dans les JTextField contenant les noms des joeurs 
 * et lorsque nous cliquons dessus s'efface 
 * @author Zaychenko
 *
 */
public class Ecriture extends JTextField {
	 Font gainFont = new Font("Tahoma", Font.PLAIN, 30);  
	 Font lostFont = new Font("Tahoma", Font.ITALIC, 30);  
	  
	 /**
	  * Veille lorsque nous cliquons sur le JTextField efface le contenu pour y écrir les deux noms
	  * @param hint
	  */
	  //Repris d'internet
	  public Ecriture(final String hint) {  
	  
	    setText(hint);  
	    setFont(lostFont);  
	    setForeground(Color.GRAY);  
	  
	    this.addFocusListener(new FocusAdapter() {  
	  
	    	/** 
	    	 * Efface le contenu par défaut
	    	 */
	      public void focusGained(FocusEvent e) {  
	        if (getText().equals(hint)) {  
	          setText("");  
	          setFont(gainFont);  
	        } else {  
	          setText(getText());  
	          setFont(gainFont);  
	        }  
	      }  
	      
	      /**
	       * change la couleur du gris au noir quand nous écrivons quelque chose.
	       */
	      public void focusLost(FocusEvent e) {  
	        if (getText().equals(hint)|| getText().length()==0) {  
	          setText(hint);  
	          setFont(lostFont);  
	          setForeground(Color.GRAY);  
	        } else {  
	          setText(getText());  
	          setFont(gainFont);  
	          setForeground(Color.BLACK);  
	        }  
	      }  
	    });  
	  
	  }  
}
 
