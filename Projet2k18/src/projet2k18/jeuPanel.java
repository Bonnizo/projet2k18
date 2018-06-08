package projet2k18;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jeuPanel extends JPanel{
	private JPanel panel1 = new JPanel();
	private JLabel image, titre; 
	private JTextField nom1, nom2;


	public jeuPanel(){
		this.setBackground(Color.BLACK);
		panel1.setSize(460,800);
		panel1.setLayout(new BorderLayout(0, 0));
		interfac();	
			//
}

	private void interfac() {
		
		// titre 
		JPanel paneltitre = new JPanel();
		paneltitre.setPreferredSize(new Dimension(390, 100));
		paneltitre.setBackground(Color.WHITE);
		titre= new JLabel("Tic Tac Tao");
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 55));
		paneltitre.add(titre);
		
		// image 
		JPanel panImage = new JPanel();
		image = new JLabel(new ImageIcon("C:/Users/Zaychenko/Documents/Java/Boxe.jpg"));
		panImage.setPreferredSize(new Dimension(390, 400));
		panImage.setBackground(Color.WHITE);
		panImage.setLayout(new BorderLayout());
		panImage.add(image);

		// Joueur1
		JPanel pjoueur1 = new JPanel();
		pjoueur1.setPreferredSize(new Dimension(390, 75));
		pjoueur1.setBackground(Color.WHITE);
		nom1 = new Ecriture("Nom joueur 1");
		nom1.setPreferredSize(new Dimension(300, 50));
		pjoueur1.add(nom1);
	
		
		// Joueur2
		JPanel pjoueur2 = new JPanel();
		pjoueur2.setPreferredSize(new Dimension(390, 75));
		pjoueur2.setBackground(Color.WHITE);
		nom2 = new Ecriture("Nom joueur 2");
		nom2.setPreferredSize(new Dimension(300, 50));
		pjoueur2.add(nom2);
		
		
		//Panel central 
		JPanel pcentral = new JPanel();
		pcentral.setBackground(Color.WHITE);
		pcentral.add(panImage);
		pcentral.add(pjoueur1);
		pcentral.add(pjoueur2);
		
		//Panel des boutons 
		JPanel pbouton = new JPanel();
		pbouton.setBackground(Color.WHITE);
		
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
		pbouton.add(reglebouton);
		pbouton.add(playbouton);
		
		
		panel1.add(paneltitre, BorderLayout.NORTH);
		panel1.add(pcentral, BorderLayout.CENTER);
		panel1.add(pbouton, BorderLayout.SOUTH);
		this.add(panel1);
		
		
	}
	
	class BoutonRegle implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			Regle dialogregle = new Regle();
			dialogregle.setModal(true);
			dialogregle.setVisible(true);			
		}
	}
	
	class BoutonPlay implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			String name1 = nom1.getText();
			String name2 = nom2.getText();
//			setContentPane(new GamePanel(name1, name2));
			repaint();
		}

	}
	
	
}

