
package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.synth.SynthSeparatorUI;

import projet2k18.FrameMain.boutonContact;
import projet2k18.PersonneInfo;

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
 * @author Victor
 * @author Nathan
 * @author Victor
 *
 */
public class ContactAppli extends JPanel {

	// panel contact
	private JPanel contactPanel = new JPanel();
	private JPanel infoPanel = new JPanel();
	private JPanel boutonPanel = new JPanel();
	private JPanel imgPanel = new JPanel();
	private JPanel espacePanel1 = new JPanel();
	private JPanel espacePanel2 = new JPanel();

	// Texfield
	private static HintTextField prenom = new HintTextField("prenom");
	private static HintTextField nom = new HintTextField("nom");
	private static HintTextField telephone = new HintTextField("telephone");
	private static HintTextField adresse = new HintTextField("adresse");
	private static HintTextField email = new HintTextField("email");

	private Calendar now = Calendar.getInstance();
	DateFormat hhmm = new SimpleDateFormat("HH:mm");

	// image
	ImageIcon back = new ImageIcon("image/back.png");
	ImageIcon ok = new ImageIcon("image/correct.png");

	// bouton
	private BoutonMenu annuler = new BoutonMenu(back, 40, new RetourContact());
	private BoutonMenu correct = new BoutonMenu(ok, 40, new AjouterContact());

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

	public ContactAppli(CardLayout cardLayout2, JPanel contentPanel2) {
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
		
		
		

	}

	class AjouterContact extends Listener {
		public void actionPerformed(ActionEvent e) {
			PersonneInfo person = new PersonneInfo(prenom.getText(), nom.getText(), telephone.getText(), adresse.getText(), email.getText());
			try {
				FileOutputStream out = new FileOutputStream("SerialisationContact/Contact" + prenom.getText() + "_" + nom.getText()+ now.getTimeInMillis()+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(out);
				oos.writeObject(person);
				
				oos.close();
				out.close();
			} catch (IOException f) {
				// …
			}
			ContactPanel cPanel = new ContactPanel();
	    	contentPanel2.add(cPanel, "addProfilePicture");
	    	cardLayout2.show(contentPanel2, "addProfilePicture");
		
		}
	}

	class RetourContact extends Listener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactPanel");
	
	
		}
	}
	
	public static void infoTransfert(PersonneInfo info1) {
		// TODO Auto-generated method stub
		String prenomFinal = prenom.getText();
		String nomFinal = nom.getText();
		String telephoneFinal = telephone.getText();
		String adresseFinal = adresse.getText();
		String emailFinal = email.getText();

		}
}
