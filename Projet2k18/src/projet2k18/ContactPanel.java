package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
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
import projet2k18.GalleryPanel.SelectImage;

/**
 * 
 *  <b>ContactPanel permet de creer la liste de contact pour le smartphone.</b>
 * <p>
 * On récupère depuis la classe ContactAppli les différents contact sérializer afin de les deserializer ici et créer un fichier de contact
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
	private ImageIcon effacerContact = new ImageIcon("image/close.png");

	// image contact
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
	private GridLayout layoutContact = new GridLayout(0, 1);

	// document contact

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

		// panel des boutons
		boutonContact.setBackground(Color.WHITE);
		boutonContact.setPreferredSize(new Dimension(400, 670));
		boutonContact.add(plus);
		boutonContact.add(supprimer);

		// panel avec scrollbar pour liste contact
		listeContacts.setPreferredSize(new Dimension(400, 670));
		listeContacts.setBackground(Color.WHITE);
		listeContacts.getVerticalScrollBar().setUnitIncrement(16);

		Border panelBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK);

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
			
			JLabel test = new JLabel(
					listPerson[i].getPrenom() + " " + listPerson[i].getNom() + " " + listPerson[i].getTelephone() + " "
							+ listPerson[i].getAdresse() + " " + listPerson[i].getEmail() + " ");
			test.setPreferredSize(new Dimension(300, 400 ));
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

		

	}

	class effacerContact extends Listener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactAppli");
		}
	}
}
