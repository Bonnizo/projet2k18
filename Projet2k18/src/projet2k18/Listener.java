package projet2k18;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 
 *  <b>La class Listener permet l'utilisation des boutons avec une action.</b>
 * <p>
 * Inteface qui permet de d�clarer les actions qui sont associ�s aux boutons cr��s avec BoutonMenu
 * </p>
 * 
 * 
 * @see BoutonMenu
 * @see FrameMain
 * @author Victor
 *
 */
abstract public class Listener implements ActionListener{

	abstract public void actionPerformed(ActionEvent e);

	
}
