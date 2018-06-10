package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import projet2k18.PersonneInfo;
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

	//creation du contact
		private JLabel contact = new JLabel("sadsadada");
		private JLabel contact1 = new JLabel("saasdadada");
		private JLabel contact2 = new JLabel("sadsadada");
		private JLabel contact3 = new JLabel("sa23dada");
		private JLabel contact4 = new JLabel("sa23dada");
		private JLabel contact5 = new JLabel("sa23dada");

	//creation label de l'image du contact 
		private JLabel contactPhotol = new JLabel(contactPhoto);
		private JLabel contactPhotol2 = new JLabel(contactPhoto);
		private JLabel contactPhotol3= new JLabel(contactPhoto);
		private JLabel contactPhotol4= new JLabel(contactPhoto);
		private JLabel contactPhotol5= new JLabel(contactPhoto);
		private JLabel contactPhotol6= new JLabel(contactPhoto);
		
	
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



		//Personne cree
				private PersonneInfo personne;
				
				
				
				ArrayList<PersonneInfo> listContact = new ArrayList<PersonneInfo>();
	
	
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
		
		//photo modification	

		PersonneInfo test = new PersonneInfo("ewr", "SDFSD", "FDSF", "fdsf","sdfsdf");
		PersonneInfo test2 = new PersonneInfo("ewr", "SDFSD", "FDSF", "fdsf","sdfsdf");
		PersonneInfo test3 = new PersonneInfo("ewr", "SDFSD", "FDSF", "fdsf","sdfsdf");
		PersonneInfo test4 = new PersonneInfo("ewr", "SDFSD", "FDSF", "fdsf","sdfsdf");
		listContact.add(test);
		listContact.add(test2);
		listContact.add(test3);
		listContact.add(test4);
		
		
		for(int i =0; i<listContact.size(); i++) {
			
			
			
			JLabel testC = new JLabel();
			testC.setPreferredSize(new Dimension(50, 20));
			Border panelBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK);
			testC.setBorder(panelBorder);
			annuaire.setLayout(layoutContact);
			
			annuaire.add(testC);
		}
		contactPhotol.setPreferredSize(new Dimension(50, 20));
		contactPhotol2.setPreferredSize(new Dimension(50, 200));
		contactPhotol3.setPreferredSize(new Dimension(50, 200));
		contactPhotol4.setPreferredSize(new Dimension(50, 200));
		contactPhotol5.setPreferredSize(new Dimension(50, 200));
		contactPhotol.setPreferredSize(new Dimension(50, 200));
		contactPhotol.setPreferredSize(new Dimension(50, 200));
		
		//label de contact modification
		contact1.setPreferredSize(new Dimension(50, 200));
		contact2.setPreferredSize(new Dimension(50, 200));
		contact3.setPreferredSize(new Dimension(50, 200));
		contact4.setPreferredSize(new Dimension(50, 200));
		contact5.setPreferredSize(new Dimension(50, 200));
		contact3.setPreferredSize(new Dimension(50, 200));

		Border panelBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK);
		
		contact.setBorder(panelBorder);
		contact1.setBorder(panelBorder);
		contact2.setBorder(panelBorder);
		contact3.setBorder(panelBorder);
		contact4.setBorder(panelBorder);
		contact5.setBorder(panelBorder);
		
		
		
		
		
		//annuaire = contact listé dans le scroll pane
		annuaire.setBackground(Color.WHITE);		
	
		
		
		//ajout des contacts + photo à côté
		annuaire.setLayout(layoutContact);
	
		annuaire.add(contactPhotol);
		annuaire.add(contact1);
		annuaire.add(contactPhotol2);
		annuaire.add(contact2);
		annuaire.add(contactPhotol3);
		annuaire.add(contact3);
		annuaire.add(contactPhotol4);
		annuaire.add(contact4);
		annuaire.add(contactPhotol5);
		annuaire.add(contact5);
		annuaire.add(contactPhotol6);
		
		
		
		//ajout de la liste de contact sur les boutons comme ça ils sont fixes meme si il y a un scroll
		boutonContact.add(listeContacts, BorderLayout.CENTER);
		//ajout des du panel bouton 
		contactPanel.add(boutonContact, BorderLayout.NORTH);

		
		//ajouter contact list 
		
		
		
	
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
