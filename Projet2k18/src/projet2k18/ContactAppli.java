
package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import projet2k18.FrameMain.boutonContact;
import projet2k18.PersonneInfo;

public class ContactAppli extends JPanel{


	// panel contact
	private JPanel contactPanel = new JPanel();
	private JPanel infoPanel = new JPanel();
	private JPanel boutonPanel = new JPanel();
	private JPanel imgPanel = new JPanel();
	private JPanel espacePanel1 = new JPanel();
	private JPanel espacePanel2 = new JPanel();
	//Label
	private JLabel prenomLabel = new JLabel("prenom",10);
	private JLabel nomLabel  = new JLabel("nom");
	private JLabel telephoneLabel  = new JLabel("telephone");
	private JLabel adresseLabel  = new JLabel("adresse");
	private JLabel emailLabel  = new JLabel("email");
	
	
	// Texfield
	private HintTextField prenom = new HintTextField("prenom");
	private HintTextField nom = new HintTextField("nom");
	private HintTextField telephone = new HintTextField("telephone");
	private HintTextField adresse = new HintTextField("adresse");
	private HintTextField email = new HintTextField("email");
	
	
	//bouton 
	
	private JButton ok = new JButton(new ImageIcon("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\ok.png"));

	private JButton annuler = new JButton(new ImageIcon("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\close.png"));

	
	//image
	
	
	private JButton boutonImg = new JButton(new ImageIcon("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\face.png"));

	
	//layout
	private GridLayout grille = new GridLayout(0,1, 20,20);	
	private FlowLayout test = new FlowLayout(100,95,75);
	private BorderLayout centre = new BorderLayout();
	
	
	
	
	//cardlayout
	private CardLayout cardLayout2;
	private JPanel contentPanel2; 
	
	
	
	//Personne cree
	private PersonneInfo personne;
	public  ContactAppli(CardLayout cardLayout2, JPanel contentPanel2){
		this.cardLayout2 = cardLayout2;
		this.contentPanel2 = contentPanel2;
		//caractristiques page
		
		setLayout(centre);
		setBackground(Color.WHITE);
		

		//taille panel dans le container
		
		infoPanel.setPreferredSize(new Dimension( 150, 470));
		
		boutonPanel.setPreferredSize(new Dimension(300,140));

		imgPanel.setPreferredSize(new Dimension(100,100));
		
		espacePanel1.setPreferredSize(new Dimension(10,500));
		espacePanel2.setPreferredSize(new Dimension (400,30));
				
		//bordure label dans panel
		
		Border panelBorder = BorderFactory.createMatteBorder(0, 0, 1,0 , Color.BLACK);
		
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
		
		
		//ajout image
		imgPanel.add(boutonImg);
		boutonImg.setContentAreaFilled(false);
		
		//taille bouton
		ok.setPreferredSize(new Dimension(60,60));
		annuler.setPreferredSize(new Dimension(60,60));
		
		//taille label 
		boutonImg.setPreferredSize(new Dimension(70,80));
		//ajout bouton gestion de l'ajout contact
		boutonPanel.add(annuler);
		boutonPanel.add(ok);
		
		
		
		
		
		
		//layout des 2 panels info + bouton
		infoPanel.setLayout(grille);
		boutonPanel.setLayout(test);
		
		//transparent panel
		infoPanel.setOpaque(false);
		boutonPanel.setOpaque(false);
		imgPanel.setOpaque(false);
		espacePanel1.setOpaque(false);
		espacePanel2.setOpaque(false);
		
		
		//transparent bouton
		ok.setContentAreaFilled(false);
		annuler.setContentAreaFilled(false);
		ok.setBorderPainted(false);
		annuler.setBorderPainted(false);
		boutonImg.setContentAreaFilled(false);
		boutonImg.setBorderPainted(false);
		
		
		
		
		//rajouter panel
		add(infoPanel,BorderLayout.CENTER);
		add(boutonPanel,BorderLayout.SOUTH);
		add(imgPanel, BorderLayout.WEST);
		add(espacePanel1, BorderLayout.EAST);
		add(espacePanel2, BorderLayout.NORTH);
		
	
		
		
		ok.addActionListener(new transfertData());
		annuler.addActionListener(new boutonMenu());
	}
	
	private void setFieldsText() 
	{
		prenom.setText(personne.getPrenom());
		nom.setText(personne.getNom());
		telephone.setText(personne.getTelephone());
		adresse.setText(personne.getAdresse());
		email.setText(personne.getEmail());
	}
	
	public PersonneInfo getModifiedContact() 
	{
		personne.setPrenom(prenom.getText());
		personne.setNom(nom.getText());
		personne.setTelephone(telephone.getText());
		personne.setAdresse(adresse.getText());
		personne.setEmail(email.getText());
		
		

		return personne;
	}
	
	public PersonneInfo getNewContact(int id) 
	{
		
		return new PersonneInfo(id, prenom.getText(), nom.getText(), telephone.getText(), adresse.getText(),email.getText(), null);
	}
	//action bouton
	class transfertData implements ActionListener 
	{
	
		public void actionPerformed(ActionEvent e) 
		{
		System.out.println(PersonneInfo.prenom);
		
		}
		
	}
	class boutonMenu implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout2.show(contentPanel2,  "test");
		}
	}
	
}
