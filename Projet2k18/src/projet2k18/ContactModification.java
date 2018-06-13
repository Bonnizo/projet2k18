package projet2k18;





import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.xml.bind.Marshaller.Listener;


/**
 * 
 * 
 * 
 *  <b>ContactAppli permet de crer le contact qui sera ensuite rajouter aux autres dans ContactPanel.</b>
 * <p>
 * Les infos des contacts sont sérializés et récupérer sur ContactPanel dans SerialisationContact
 * </p>
 * 
 * 
 * 
 * 
 * @see ContactPanel
 *
 * @author Nathan
 * @author Victor
 * 
 *
 */
	public class ContactModification extends JPanel {

	
	// panel contact
	private JPanel contactPanel = new JPanel();
	private JPanel infoPanel = new JPanel();
	private JPanel boutonPanel = new JPanel();
	private JPanel imgPanel = new JPanel();
	private JPanel espacePanel1 = new JPanel();
	private JPanel espacePanel2 = new JPanel();

	
	//image 
	
	
	// Texfield
	public JTextField prenom = new JTextField("prenom");
	private JTextField nom = new JTextField("nom");
	private JTextField telephone = new JTextField("telephone");
	private JTextField adresse = new JTextField("adresse");
	private JTextField email = new JTextField("email");
	
	
	private Calendar now = Calendar.getInstance();
	DateFormat hhmm = new SimpleDateFormat("HH:mm");

	// image
	ImageIcon back = new ImageIcon("image/back.png");
	ImageIcon ok = new ImageIcon("image/correct.png");

	// bouton
	private BoutonMenu annuler = new BoutonMenu(back, 40);
	private BoutonMenu correct = new BoutonMenu(ok, 40);

	// layout
	private GridLayout grille = new GridLayout(0, 1, 20, 20);
	private FlowLayout boutonPlacer = new FlowLayout(100, 100, 80);
	private BorderLayout centre = new BorderLayout();

	// cardlayout
	private CardLayout cardLayout2;
	private JPanel contentPanel2;

	// Création des contacts
	// liste utilisée pour la serialization
	public ArrayList<PersonneInfo> PersonneListe = new ArrayList<PersonneInfo>();
	private PersonneInfo person;
	
	public ContactModification(CardLayout cardLayout2, JPanel contentPanel2, String filename) {
		this.cardLayout2 = cardLayout2;
		this.contentPanel2 = contentPanel2;
		// caractristiques page

		setLayout(centre);
		setBackground(Color.WHITE);

		// taille panel dans le container

		infoPanel.setPreferredSize(new Dimension(150, 470));

		boutonPanel.setPreferredSize(new Dimension(300, 140));

		imgPanel.setPreferredSize(new Dimension(100, 100));

		espacePanel1.setPreferredSize(new Dimension(10, 500));
		espacePanel2.setPreferredSize(new Dimension(400, 30));

		// bordure label dans panel

		Border panelBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);

		infoPanel.add(prenom);
		prenom.setBorder(panelBorder);
		infoPanel.add(nom);
		nom.setBorder(panelBorder);
		infoPanel.add(telephone);
		telephone.setBorder(panelBorder);
		infoPanel.add(adresse);
		adresse.setBorder(panelBorder);
		infoPanel.add(email);
		email.setBorder(panelBorder);

		boutonPanel.add(annuler);
		boutonPanel.add(correct);

		// layout des 2 panels info + bouton
		infoPanel.setLayout(grille);
		boutonPanel.setLayout(boutonPlacer);

		// transparent panel
		infoPanel.setOpaque(false);
		boutonPanel.setOpaque(false);
		imgPanel.setOpaque(false);
		espacePanel1.setOpaque(false);
		espacePanel2.setOpaque(false);

		// rajouter panel
		add(infoPanel, BorderLayout.CENTER);
		add(boutonPanel, BorderLayout.SOUTH);
		add(imgPanel, BorderLayout.WEST);
		add(espacePanel1, BorderLayout.EAST);
		add(espacePanel2, BorderLayout.NORTH);

	
	/*File folder = new File("SerialisationContact");
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
	}*/
		
		try {
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(in);
			try {
				PersonneInfo temp = (PersonneInfo)ois.readObject();
				person = temp;
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				person = (PersonneInfo)ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ois.close();
		} catch (IOException e) {
			// …
		}
	
	/*for (int i = 0; i < listPerson.length; i++) {
	
		String prenomC = listPerson[i].getPrenom().toString();
		String nomC = listPerson[i].getNom().toString();
		String telephoneC = listPerson[i].getTelephone().toString();
		String adresseC = listPerson[i].getAdresse().toString();
		String emailC = listPerson[i].getEmail().toString();
	
	
		prenom.setText(prenomC);
		nom.setText(nomC);
		telephone.setText(telephoneC);
		adresse.setText(adresseC);
		email.setText(emailC);
	
	}*/
		String prenomC = person.getPrenom().toString();
		String nomC = person.getNom().toString();
		String telephoneC = person.getTelephone().toString();
		String adresseC = person.getAdresse().toString();
		String emailC = person.getEmail().toString();
	
	
		prenom.setText(prenomC);
		nom.setText(nomC);
		telephone.setText(telephoneC);
		adresse.setText(adresseC);
		email.setText(emailC);
	}
	class AjouterContact extends Listener {
		public void actionPerformed(ActionEvent e) {
			
			PersonneInfo person = new PersonneInfo(prenom.getText(), nom.getText(), telephone.getText(), adresse.getText(), email.getText());
			try {
				FileOutputStream out = new FileOutputStream("SerialisationContact/Contact" + prenom.getText() + "_" + nom.getText()+ now.getTimeInMillis()+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(out);
				oos.writeObject(person);

				oos.close();
			} catch (IOException f) {
				// …
			}
			
			cardLayout2.show(contentPanel2, "contactPanel");
		}
	}

	class RetourContact extends Listener {
	
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactPanel");
			// prenom.setText(prenomDefaut.getText());
			

		}
	}
	
	}
