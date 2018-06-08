package projet2k18;


import java.awt.Color;  
import java.awt.Font;  
import java.awt.event.FocusAdapter;  
import java.awt.event.FocusEvent;  
import javax.swing.JTextField;  

import javax.swing.JTextField;

public class Ecriture extends JTextField {
	 Font gainFont = new Font("Tahoma", Font.PLAIN, 30);  
	 Font lostFont = new Font("Tahoma", Font.ITALIC, 30);  
	  
//	  
	  //Repris d'internet
	  public Ecriture(final String hint) {  
	  
	    setText(hint);  
	    setFont(lostFont);  
	    setForeground(Color.GRAY);  
	  
	    this.addFocusListener(new FocusAdapter() {  
	  
	      public void focusGained(FocusEvent e) {  
	        if (getText().equals(hint)) {  
	          setText("");  
	          setFont(gainFont);  
	        } else {  
	          setText(getText());  
	          setFont(gainFont);  
	        }  
	      }  
	  
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
 
