package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * 
 *  <b>ContactPanel permet de creer la liste de contact pour le smartphone.</b>
 * <p>
 * On récupère depuis la classe ContactAppli les différents contact sérializer afin de les deserializer ici et créer un fichier de contact
 * 
 * </p>
 * 
 * 
 * 
 * 
 * 
 * @see ContactAppli
 * @author Victor
 * @author Nathan
 */
public class ContactPanel extends JPanel {
	
	
	

	// image des boutons
	private ImageIcon rajouterContact = new ImageIcon("image/plus.png");
	
	// image contact
	private ImageIcon contactPhoto = new ImageIcon("image/close.png");

	// bouton contactPanel

	private BoutonMenu plus = new BoutonMenu(rajouterContact, 40, new boutonContact());



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
	private ContactModification contactModification = new ContactModification(cardLayout2, contentPanel2);

	// grid layout, agencement colonne contact + photo
	private GridLayout layoutContact = new GridLayout(0, 1);

	// taille 
	private int size = 0;

	// liste definitive
	/*ArrayList<PersonneInfo> enCours = new ArrayList<PersonneInfo>();
	ArrayList<PersonneInfo> finale = new ArrayList<PersonneInfo>();*/
	private PersonneInfo[] listPerson;

	public ContactPanel() {
		// couleur base
		contactPanel.setBackground(Color.WHITE);
		annuaire.setLayout(layoutContact);

		// panel organise cardlayout
		this.add(contentPanel2);

		// ajoute du panel des contacts et pour ajouter des contacts
		contentPanel2.add(contactPanel, "contactPanel");
		contentPanel2.add(contactAppli, "contactAppli");
		contentPanel2.add(contactModification, "contactModif");
		// panel des boutons
		boutonContact.setBackground(Color.WHITE);
		boutonContact.setPreferredSize(new Dimension(400, 670));
		boutonContact.add(plus);
	

		// panel avec scrollbar pour liste contact
		listeContacts.setPreferredSize(new Dimension(400, 670));
		listeContacts.setBackground(Color.WHITE);
		listeContacts.getVerticalScrollBar().setUnitIncrement(16);

		Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);

		// ajout de la liste de contact sur les boutons comme ça ils sont fixes meme si
		// il y a un scroll
		boutonContact.add(listeContacts, BorderLayout.CENTER);
		// ajout des du panel bouton
		contactPanel.add(boutonContact, BorderLayout.NORTH);
		
		File folder = new File("SerialisationContact");
		File[] listOfFiles = folder.listFiles();
		
		listPerson = new PersonneInfo[listOfFiles.length];
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println(listOfFiles[i]);
				try {
					FileInputStream in = new FileInputStream(listOfFiles[i]);
					ObjectInputStream ois = new ObjectInputStream(in);
					try {
						PersonneInfo temp = (PersonneInfo)ois.readObject();
						listPerson[i] = temp;
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						listPerson[i] = (PersonneInfo)ois.readObject();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ois.close();
				} catch (IOException e) {
					// …
				}
				
			}
		}
		
		for (int i = 0; i < listPerson.length; i++) {
			
			Font myFont = new Font ("Courier New", 1, 15);
			
			String texte = "<html> "+listPerson[i].getPrenom()  +"<br>"+ listPerson[i].getNom() +"<br>"+ listPerson[i].getTelephone() +"<br>"+
					 listPerson[i].getAdresse() +" <br>" +  listPerson[i].getEmail()+ "</htlm>";
			
	    	
			
			JLabel labelContact = new JLabel(texte,SwingConstants.CENTER);
			labelContact.setFont(myFont);
			
			
			labelContact.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {

			    	cardLayout2.show(contentPanel2, "contactModif");
			    	
			    
			  
			    }
			});
			
			
			
			
			
			
			ImageIcon profile = new ImageIcon("image/profile.png");
			
			BoutonMenu profil = new BoutonMenu(profile, 40);
			
			
			JPanel panelContact = new JPanel();
			labelContact.setSize(300,100);
			
			
			panelContact.setLayout(new FlowLayout(0,30,100));
			panelContact.setSize(new Dimension(400, 200));
			panelContact.setBorder(border);
			panelContact.setBackground(Color.WHITE);
			
			panelContact.add(profil);
			panelContact.add(labelContact);
			
			
			
			annuaire.add(panelContact);
		}

		annuaire.setBackground(Color.WHITE);
	
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
	}
		
		

	}
	
