package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import projet2k18.ContactAppli;
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
		private GridLayout layoutContact = new GridLayout(0,1);
	
		
		//document contact
		
		//liste definitive
	 ArrayList <PersonneInfo> enCours = new ArrayList <PersonneInfo>();
	 ArrayList <PersonneInfo> finale = new ArrayList <PersonneInfo>();
		
	 
	
		
	public ContactPanel() {
		//couleur base
		contactPanel.setBackground(Color.WHITE);
		annuaire.setLayout(layoutContact);
		
		
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

		PersonneInfo info1 =new PersonneInfo(null,null,null,null,null);
		ContactAppli.infoTransfert(info1);
		PersonneInfo info2 =new PersonneInfo("bw333blba","blablba","blablba","blablba","blablba");
		PersonneInfo info3 =new PersonneInfo("bw333blba","blablba","blablba","blablba","blablba");
		PersonneInfo info4 =new PersonneInfo("bw333blba","blablba","blablba","blablba","blablba");
		PersonneInfo info5 =new PersonneInfo("bw333blba","blablba","blablba","blablba","blablba");
		enCours.add(info1);
		enCours.add(info2);	
		enCours.add(info3);
		enCours.add(info4);
		enCours.add(info5);	
		try {
			 FileOutputStream out = new FileOutputStream("Contact.ser" );
			 ObjectOutputStream oos = new ObjectOutputStream( out );
			for(int i = 0; i<enCours.size();i++) {
			 oos.writeObject(enCours.get(i) );}
			
			 oos.close();
			} catch(IOException f) {
			 // … 
	}
		try {
			 FileInputStream in = new FileInputStream("Contact.ser" );
			 ObjectInputStream ois = new ObjectInputStream( in );
			
			 for (int i = 0; i<enCours.size();i++) {
			 PersonneInfo d = (PersonneInfo) ois.readObject();
			 finale.add(d);
			 }
			 ois.close();
			} catch(IOException e) {
			 // …
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		for(int i =0 ; i<finale.size(); i++) {
		JLabel test = new JLabel(finale.get(i).getPrenom()+" "+finale.get(i).getNom()+" "+finale.get(i).getTelephone()+" "+finale.get(i).getAdresse()+" "+finale.get(i).getEmail()+" ");
		test.setPreferredSize(new Dimension(300,400));
		annuaire.add(test);
		}
		
		
		
		listeContacts.repaint();
		listeContacts.revalidate();
		annuaire.repaint();
		annuaire.revalidate();
		
	}
	
	

	class boutonContact extends Listener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactAppli");
			
			
		}
		public void actionPerformed2(ActionEvent f) {
			PersonneInfo info5 =new PersonneInfo("bw344444","blablba","blablba","blablba","blablba");
			enCours.add(info5);
			
			
		}
		
		
	}

	class effacerContact extends Listener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactAppli");
		}
	}
}
