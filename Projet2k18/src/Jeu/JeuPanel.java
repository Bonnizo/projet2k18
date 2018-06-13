package Jeu;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**Premier Panel du jeu Tic Tac Tao 
 * on y rentre les noms des deux joeurs 
 * et on accède au jeu. 
 * 
 * @see GamePanel 
 * @See Regle 
 * @see Ecriture 
 * @author Zaychenko
 *
 */
public class JeuPanel extends JPanel{

	/**
	 * Les deux noms des joueurs
	 */
	private String name1, name2;
	/**
	 * le panel container des cardlayout
	 */
	private JPanel panelct = new JPanel();
	private CardLayout cl = new CardLayout();
	/**
	 * Le premier panel du jeu
	 */
	private JPanel panel1 = new JPanel();
	/** 
	 * Le deuxième panel du jeu 
	 */
	//private GamePanel panel2 = new GamePanel(panelct, cl, name1, name2);
	private JLabel titre; 
	/** 
	 * Ou il faut rentrer le nom des joueurs
	 */
	private JTextField nom1, nom2;
	private ImageIcon boxe = new ImageIcon("image/Boxe.jpg");



	/**
	 * Constructeur du premier pannel JeuPanel
	 * @see GamePanel
	 * @ Regle
	 * @ Ecriture 
	 */
	public JeuPanel(){
		
		//Ajout pour le CardLayout
		panelct.setLayout(cl);
		panelct.add(panel1, "jeu1");
		
		
		this.setPreferredSize(new Dimension(400, 670));
		panel1.setPreferredSize(new Dimension(400, 670));
		panelct.setPreferredSize(new Dimension(400, 670));
		panel1.setBackground(Color.WHITE);
		panel1.setLayout(new BorderLayout(0, 0));

		// titre 
		titre= new JLabel("Tic Tac Tao");
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 55));
		

		// image 
		JLabel labphoto= new JLabel(boxe);
		labphoto.setPreferredSize(new Dimension(390, 350));

		// Joueur1
		nom1 = new Ecriture("Nom joueur 1");
		nom1.setPreferredSize(new Dimension(350, 50));

		// Joueur2
		nom2 = new Ecriture("Nom joueur 2");
		nom2.setPreferredSize(new Dimension(350, 50));
		
		

		//Panel central 
		JPanel pcentral = new JPanel();
		pcentral.setBackground(Color.WHITE);
		pcentral.add(labphoto);
		pcentral.add(nom1);
		pcentral.add(nom2);
			
		
		//Bouton Play
		JButton playbouton = new JButton("Play");
		playbouton.setPreferredSize(new Dimension(100, 60));
		playbouton.setForeground(Color.WHITE);
		playbouton.setBackground(Color.BLACK);
		playbouton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		playbouton.addActionListener(new BoutonPlay());
		
		//Bouton des règles
		JButton reglebouton = new JButton("?");
		reglebouton.setPreferredSize(new Dimension(100, 60));
		reglebouton.setForeground(Color.WHITE);
		reglebouton.setBackground(Color.BLACK);
		reglebouton.setFont(new Font("Tahoma",Font.PLAIN, 35));
		reglebouton.addActionListener(new BoutonRegle());
		
		//Ajouter les boutons 
		JPanel pbouton = new JPanel();
		pbouton.setBackground(Color.WHITE);
		pbouton.setPreferredSize(new Dimension(400, 100));
		pbouton.add(reglebouton);
		pbouton.add(playbouton);
		
		
	
		
		panel1.add(titre, BorderLayout.NORTH);
		panel1.add(pcentral, BorderLayout.CENTER);
		panel1.add(pbouton, BorderLayout.SOUTH);
		this.add(panelct);
	
}
	/**
	 * Boutton pour affiche la JDialog avec les règles du jeu 
	 * @see Regle
	 * @author Zaychenko
	 *
	 */
	class BoutonRegle implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Regle dialogregle = new Regle();
			dialogregle.setModal(true);
			dialogregle.setVisible(true);			
		}
	}
	/**
	 * Boutton pour accèder au panel du jeu
	 * @see GamePanel
	 * @author Zaychenko
	 *
	 */
		class BoutonPlay implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			name1 = nom1.getText();
			name2 = nom2.getText();
			GamePanel panel2 = new GamePanel(panelct, cl, name1, name2);
			panelct.add(panel2, "jeu2");
			cl.show(panelct, "jeu2");

		}
	}
}