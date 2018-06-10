package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class ContactPanel extends JPanel {

	//image des boutons 
	private ImageIcon rajouterContact = new ImageIcon("image/plus.png");
	private ImageIcon effacerContact = new ImageIcon("image/close.png");
	
	
	//image contact
	private ImageIcon contactPhoto = new ImageIcon("image/close.png");
	
	
	
	// bouton contactPanel

	private BoutonMenu plus = new BoutonMenu(rajouterContact, 40, new boutonContact());
	private BoutonMenu supprimer = new BoutonMenu(effacerContact, 30, new effacerContact());

	// panel contactPanel
	private JPanel contactPanel = new JPanel();

	
		
	
	// panel liste deroulante de contact 
	private JPanel annuaire = new JPanel();
	private JScrollPane listeContacts = new JScrollPane(annuaire);

	// panel liste bouton

	private JPanel boutonContact = new JPanel();

	

	
	
	
	// cardlayout contact
		private CardLayout cardLayout2 = new CardLayout();
		private JPanel contentPanel2 = new JPanel(cardLayout2);

		private ContactAppli contactAppli = new ContactAppli(cardLayout2, contentPanel2);
		
		
		
		
		// grid layout, agencement colonne contact + photo
		private GridLayout layoutContact = new GridLayout(0,2);
	
		
		//document contact

		//liste definitive
		ArrayList PersonneListeFinale = new ArrayList();

		
	
	public ContactPanel() {
		//couleur base
		contactPanel.setBackground(Color.WHITE);

		
		
		//panel organise cardlayout
		this.add(contentPanel2);

		
		//ajoute du panel des contacts et pour ajouter des contacts
		contentPanel2.add(contactPanel, "contactPanel");
		contentPanel2.add(contactAppli, "contactAppli");
		
	
		//panel des boutons
		boutonContact.setBackground(Color.WHITE);
		boutonContact.setPreferredSize(new Dimension(400, 670));
		boutonContact.add(plus);
		boutonContact.add(supprimer);

		
		
		//panel avec scrollbar pour liste contact
		listeContacts.setPreferredSize(new Dimension(400, 670));
		listeContacts.setBackground(Color.WHITE);
		
		
	
		
		
		
	
		

		Border panelBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK);
	
		
		
		
		
		
		
	
		
		
		//ajout de la liste de contact sur les boutons comme ça ils sont fixes meme si il y a un scroll
		boutonContact.add(listeContacts, BorderLayout.CENTER);
		//ajout des du panel bouton 
		contactPanel.add(boutonContact, BorderLayout.NORTH);

		
		//ajouter contact list 
		
		
		
		  try {
			  ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerialisationContact/contact.zer"));
			 
			  while(true)
				{
				  
				 
				   PersonneInfo p = (PersonneInfo) is.readObject();
				   System.out.println("Read name"+ p.prenom + " "+p.nom+" "+p.adresse+" "+p.telephone+" "+p.email);
				} 
	
			 
		  }
		  catch (FileNotFoundException e) {
			  
			  e.printStackTrace();
		  }catch (IOException e) {
		  e.printStackTrace();
		  
		  }catch (ClassNotFoundException e) {
			  e.printStackTrace();
		  }
		  
		
		
		
	
		listeContacts.revalidate();
	}

	class boutonContact extends Listener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactAppli");
		}
	}

	class effacerContact extends Listener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactAppli");
		}
	}
}
