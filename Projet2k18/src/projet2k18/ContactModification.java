package projet2k18;





import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import AppliGallery.DiapoPanel;


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
	ImageIcon del = new ImageIcon("image/delete.png");
	// bouton
	private BoutonMenu annuler = new BoutonMenu(back, 40);
	private BoutonMenu correct = new BoutonMenu(ok, 40);
	private BoutonMenu delete = new BoutonMenu(del, 40);
	// layout
	private GridLayout grille = new GridLayout(0, 1, 20, 20);
	private FlowLayout boutonPlacer = new FlowLayout(100, 72, 70);
	private BorderLayout centre = new BorderLayout();
	private String filename;
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
		this.filename = filename;
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
		boutonPanel.add(delete);
		
		annuler.addActionListener(new RetourContact());
		correct.addActionListener(new AjouterContactModif());
		delete.addActionListener(new EffacerContact());
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


		
		try {
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(in);
			try {
				PersonneInfo temp = (PersonneInfo)ois.readObject();
				person = temp;
				temp = null;
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			}
			ois.close();
			in.close();
		} catch (IOException e) {
			// …
		}
	
	
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
	
	//effacer no ok
	class EffacerContact implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			prenom.setText("null");
			nom.setText("null");
			telephone.setText("null");
			adresse.setText("null");
			email.setText("null");
			
			
			System.out.println(person);
				
				
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
	
	
	
	//modifier ok
	class AjouterContactModif implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			
			PersonneInfo person = new PersonneInfo(prenom.getText(), nom.getText(), telephone.getText(), adresse.getText(), email.getText());
			try {
				FileOutputStream out = new FileOutputStream(filename);
				//FileOutputStream out = new FileOutputStream("SerialisationContact/Contact" + prenom.getText() + "_" + nom.getText()+ now.getTimeInMillis()+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(out);
				oos.writeObject(person);

				oos.close();
			} catch (IOException f) {
				// …
			}
			
			ContactPanel cPanel = new ContactPanel();
	    	contentPanel2.add(cPanel, "conatct");
	    	cardLayout2.show(contentPanel2, "conatct");
			//cardLayout2.show(contentPanel2, "contactPanel");
			
			
		}
	}

	
	//annuler ok
	class RetourContact implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactPanel");
			// prenom.setText(prenomDefaut.getText());
			

		}
	}
	
	}
