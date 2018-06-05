package projet2k18;




import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;

public class ContactPersonne extends JPanel{	
   
	
    //test
	//création bouton
	JButton boutonEnregistrer = new JButton("Enregistrer");
	JButton boutonQuitter = new JButton("Annuler");
	
	//création de textField avec indice

	
	

	public ContactPersonne() {
		
		
			
		   
		    
		    //Instanciation d'un objet JPanel contact
		    JPanel pan1 = new JPanel();
		    pan1.setBackground(SystemColor.activeCaption);
		    pan1.setBounds(134, 0, 244, 354);
		    
		    
		    //Instanciation d'un objet JPanel bouton
		    JPanel pan2 = new JPanel();
		    pan2.setBackground(SystemColor.control);
		    pan2.setBounds(0, 405, 378, 39);
		   
		   
		   
		    //ajout jpanel
		    this.add(pan1);
		    this.add(pan2);
		    pan1.setLayout(null);
		    txt_nom.setBounds(41, 28, 184, 32);
		    txt_nom.setAlignmentX(Component.LEFT_ALIGNMENT);
		    
		     //ajout textField
		    
		    pan1.add(txt_nom);
		    txt_prenom.setBounds(41, 76, 184, 32);
		    txt_prenom.setAlignmentX(Component.LEFT_ALIGNMENT);
		    txt_prenom.setHorizontalAlignment(SwingConstants.LEFT);
		    pan1.add(txt_prenom);
		    txt_adresse.setBounds(41, 124, 184, 32);
		    txt_adresse.setAlignmentX(Component.LEFT_ALIGNMENT);
		    pan1.add(txt_adresse);
		    txt_telephone.setBounds(41, 172, 184, 32);
		    txt_telephone.setAlignmentX(Component.LEFT_ALIGNMENT);
		    pan1.add(txt_telephone);
		    txt_email.setBounds(41, 220, 184, 32);
		    txt_email.setAlignmentX(Component.LEFT_ALIGNMENT);
		    pan1.add(txt_email);
		    txt_anniversaire.setBounds(41, 268, 184, 32);
		    txt_anniversaire.setAlignmentX(Component.LEFT_ALIGNMENT);
		    pan1.add(txt_anniversaire);
		  
		    
		    
		    
		    //ajout bouton
		    pan2.add(boutonEnregistrer, BorderLayout.NORTH);
		    pan2.add(boutonQuitter, BorderLayout.NORTH);
		    PhotoProfil.setBackground(SystemColor.inactiveCaptionBorder);
		    PhotoProfil.setHorizontalAlignment(SwingConstants.CENTER);
		   
		    
		  //Quand on clique sur le label, on peut mettre une photo
		    
		    PhotoProfil.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent arg0) {
		    	}
		    });
		    PhotoProfil.setBounds(15, 16, 89, 119);
		    
		  this.add(PhotoProfil);
		    
		    
		    
		    //On prévient notre JFrame que notre JPanel sera son content pane
		                  
		   
		
			
	
	
	
	
}	

}
