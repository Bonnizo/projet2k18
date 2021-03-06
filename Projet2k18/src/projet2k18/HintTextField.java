package projet2k18;

import java.awt.Color;  
import java.awt.Font;  
import java.awt.event.FocusAdapter;  
import java.awt.event.FocusEvent;  
import javax.swing.JTextField;  
  
/**
 * 
 *  <b>HintTextField permet de cr�er des indices pr�d�finis qui disparaissent quand on rempli les labels o� ils sont utilis�s </b>
 * <p>
 * Les infos des contacts doivent �tre rempli dans ContactAppli, c'est pourquoi on a trouv� int�ressant de laisser un indice pour savoir quelles infos 
 * ils doivent remplir.
 * </p>
 * 
 * 
 * 
 * 
 * @see ContactAppli
 * @author Victor
 *
 */
public class HintTextField extends JTextField {  
  
	
	
	//differente ecriture
  Font ecriture1 = new Font("Tahoma", Font.PLAIN, 19);  
  Font ecriture2 = new Font("Tahoma", Font.ITALIC, 19);  
  
  
  //declaration des textfield avec indice
  public HintTextField(final String hint) {  
  
	  
	  //indice cr�� avec �criture 2
    setText(hint);  
    setFont(ecriture2);  
    setForeground(Color.GRAY);  
  
    
    //des qu'on utilise le textfield 
    this.addFocusListener(new FocusAdapter() {  
  
    	
    	//en fonction de si on un du text ou pas disparition de lindice
      @Override  
      public void focusGained(FocusEvent e) {  
        if (getText().equals(hint)) {  
          setText("");  
          setFont(ecriture1);  
        } else {  
          setText(getText());  
          setFont(ecriture1);  
        }  
      }  
  //des qu'on change de case si on garde le m�me indice avec couleur si aucun mot ecrit sinon afficher text noir
      @Override  
      public void focusLost(FocusEvent e) {  
        if (getText().equals(hint)|| getText().length()==0) {  
          setText(hint);  
          setFont(ecriture2);  
          setForeground(Color.GRAY);  
        } else {  
          setText(getText());  
          setFont(ecriture1);  
          setForeground(Color.BLACK);  
        }  
      }  
    });  
  
  }  
}  