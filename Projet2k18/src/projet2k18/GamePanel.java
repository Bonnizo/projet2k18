package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import projet2k18.JeuPanel.BoutonRegle;

/**
 * Deuxième pannel du jeu Tic Tac Tao 
 * c'est ici que nous allons jouer 
 * 
 *
 * 
 * @see JeuPanel 
 * @author Zaychenko
 *
 */
public class GamePanel extends JPanel {
	/**
	 * Panel ayant l'interface du jeu
	 */
	private JPanel panel2 = new JPanel();
	private JLabel joueur1, joueur2, vs;
	private JButton changer;
	private JTextField score1, score2;
	private String alterner = "X";
	/** 
	 * compte le nombre de X
	 */
	private int cptX = 0;
	/**
	 * Compte le nombre de O
	 */
	private int cptO = 0;
	/** 
	 * Compte le nombre de click sur la grille
	 */
	private int cptclick = 0;
	/**
	 * Tableau recroupant les bouttons 
	 */
	private JButton[] b = new JButton[9];
	private CardLayout cl;
	private JPanel panelct;
	private String name1; 
	private String name2;


/**
 * Constructeur du deuxième JPanel du jeu 
 * on y définie la taille,..
 * 
 * 
 * @param panelct le pannel avec les différents JPanel
 * @param cl le cardLaayout
 * @param name1 le nom du premier joueur
 * @param name2 le nom du deuxième joueur
 */
	public GamePanel(JPanel panelct, CardLayout cl, String name1, String name2) {
		this.panelct=panelct;
		this.cl=cl;
		this.name1=name1;
		this.name2=name2;
		

		setSize(460, 800);
		setLayout(new BorderLayout(0, 0));
		panel2.setLayout(new BorderLayout(0, 0));
		panel2.setSize(460, 800);
		panel2.setBackground(Color.WHITE);
		add(panel2);
		interface2();
		

	}
	/**
	 * On ajout tous les boutons ainsi que les informations des joueurs 
	 */

	private void interface2() {
		
		// titre
		JPanel paneltitre = new JPanel();
		JPanel titregauche = new JPanel();
		JPanel titredroite = new JPanel();
		paneltitre.setBackground(Color.WHITE);

		titregauche.setLayout(new GridLayout(2, 1, 0, 0));
		titregauche.setBackground(Color.WHITE);

		titredroite.setPreferredSize(new Dimension(350, 120));
		titredroite.setLayout(new GridLayout(3, 1, 0, 0));
		titredroite.setBackground(Color.WHITE);

		score1 = new JTextField("0");
		score2 = new JTextField("0");
		
		joueur1 = new JLabel(name1);
		joueur1.setHorizontalAlignment(SwingConstants.LEFT);
		joueur2 = new JLabel(name2);
		joueur2.setHorizontalAlignment(SwingConstants.LEFT);
		vs = new JLabel("VS");
		vs.setHorizontalAlignment(SwingConstants.LEFT);

		joueur1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		joueur2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		vs.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 25));
		score1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		score2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));

		titredroite.add(joueur1);
		titredroite.add(vs);
		titredroite.add(joueur2);

		titregauche.add(score1);
		titregauche.add(score2);
		paneltitre.add(titredroite);
		paneltitre.add(titregauche);

		// Grille
		JPanel panelgrille = new JPanel();
		panelgrille.setLayout(new GridLayout(3, 3, 0, 0));
		panelgrille.setPreferredSize(new Dimension(390, 500));
		panelgrille.setBackground(Color.WHITE);

		for (int i = 0; i < b.length; i++) {
			b[i] = new JButton("");
			b[i].setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 90));
			b[i].setBackground(Color.BLACK);
			b[i].addActionListener(new boutonjeu());
			panelgrille.add(b[i]);
		}

		// paneau bouton
		JPanel panelbout = new JPanel();
		panelbout.setBackground(Color.WHITE);
		panelbout.setPreferredSize(new Dimension(390, 100));
		changer = new JButton("Changer joueur");
		changer.setForeground(Color.WHITE);
		changer.setBackground(Color.BLACK);
		changer.setFont(new Font("Tahoma",Font.PLAIN, 25));
		changer.addActionListener(new boutonchanger());
		panelbout.add(changer);
	

		panel2.add(paneltitre, BorderLayout.NORTH);
		panel2.add(panelgrille, BorderLayout.CENTER);
		panel2.add(panelbout, BorderLayout.SOUTH);
	}
	
	/**
	 * calcule le score du jeu
	 */
	private void scorejeu() {
		score1.setText(String.valueOf(cptX));
		score2.setText(String.valueOf(cptO));
	}
	
/**
 * Veille à ce que l'affichage des X et O soit alterner
 */
	private void debutalterner() {
		if (alterner.equalsIgnoreCase("X")) {
			alterner = "O";
		} else {
			alterner = "X";
		}
	}
	
	/**
	 * Lorsqu'il y'a 3 X ou O à la suite, la méthode colorie les cases en blanc
	 * @param ba premier bouton
	 * @param bb deuxième bouton
	 * @param bc troisième bouton
	 */
	private void coloriercase(JButton ba, JButton bb, JButton bc) {
		ba.setBackground(Color.WHITE);
		bb.setBackground(Color.WHITE);
		bc.setBackground(Color.WHITE);

	}
	
	/** 
	 * Efface le contenu des boutons pour refaire une partie
	 */
	private void effacergame() {

		for (int i = 0; i < b.length; i++) {
			b[i].setText(null);
			b[i].setEnabled(true);
			b[i].setBackground(Color.BLACK);
		}
		cptclick = 0;

	}
	
	/** 
	 * Vérifie si il y'a une suite de 3 même caracctères (X ou O)
	 */
	private void victoire() {
		cptclick++;

		int choix = 0;
		String bs1 = b[0].getText();
		String bs2 = b[1].getText();
		String bs3 = b[2].getText();
		String bs4 = b[3].getText();
		String bs5 = b[4].getText();
		String bs6 = b[5].getText();
		String bs7 = b[6].getText();
		String bs8 = b[7].getText();
		String bs9 = b[8].getText();

		// Gagnant avec des X
		if (bs1 == ("X") && bs2 == ("X") && bs3 == ("X")) {
			cptX++;
			choix = 1;
			coloriercase(b[0], b[1], b[2]);
		}
		if (bs4 == ("X") && bs5 == ("X") && bs6 == ("X")) {
			cptX++;
			choix = 1;
			coloriercase(b[3], b[4], b[5]);
		}
		if (bs7 == ("X") && bs8 == ("X") && bs9 == ("X")) {
			cptX++;
			choix = 1;
			coloriercase(b[6], b[7], b[8]);
		}
		if (bs1 == ("X") && bs4 == ("X") && bs7 == ("X")) {
			cptX++;
			choix = 1;
			coloriercase(b[0], b[3], b[6]);
		}
		if (bs2 == ("X") && bs5 == ("X") && bs8 == ("X")) {
			cptX++;
			choix = 1;
			coloriercase(b[1], b[4], b[7]);
		}
		if (bs3 == ("X") && bs6 == ("X") && bs9 == ("X")) {
			cptX++;
			choix = 1;
			coloriercase(b[2], b[5], b[8]);
		}
		if (bs1 == ("X") && bs5 == ("X") && bs9 == ("X")) {
			cptX++;
			choix = 1;
			coloriercase(b[0], b[4], b[8]);
		}
		if (bs3 == ("X") && bs5 == ("X") && bs7 == ("X")) {
			cptX++;
			choix = 1;
			coloriercase(b[2], b[4], b[6]);
		}

		// Le gagnant avec des O
		if (bs1 == ("O") && bs2 == ("O") && bs3 == ("O")) {
			cptO++;
			choix = 2;
			coloriercase(b[0], b[1], b[2]);
		}
		if (bs4 == ("O") && bs5 == ("O") && bs6 == ("O")) {
			cptO++;
			choix = 2;
			coloriercase(b[3], b[4], b[5]);
		}
		if (bs7 == ("O") && bs8 == ("O") && bs9 == ("O")) {
			cptO++;
			choix = 2;
			coloriercase(b[6], b[7], b[8]);
		}
		if (bs1 == ("O") && bs4 == ("O") && bs7 == ("O")) {
			cptO++;
			choix = 2;
			coloriercase(b[0], b[3], b[6]);
		}
		if (bs2 == ("O") && bs5 == ("O") && bs8 == ("O")) {
			cptO++;
			choix = 2;
			coloriercase(b[1], b[4], b[7]);
		}
		if (bs3 == ("O") && bs6 == ("O") && bs9 == ("O")) {
			cptO++;
			choix = 2;
			coloriercase(b[2], b[5], b[8]);
		}
		if (bs1 == ("O") && bs5 == ("O") && bs9 == ("O")) {
			cptO++;
			choix = 2;
			coloriercase(b[0], b[4], b[8]);
		}
		if (bs3 == ("O") && bs5 == ("O") && bs7 == ("O")) {
			cptO++;
			choix = 2;
			coloriercase(b[2], b[4], b[6]);
		}

		if (choix == 1) {
			JOptionPane.showMessageDialog(null, "Le gagnant est : " + name1, "Victoire !",
					JOptionPane.INFORMATION_MESSAGE);
			effacergame();
		} else if (choix == 2) {
			JOptionPane.showMessageDialog(null, "Le gagnant est : " + name2, "Victoire !",
					JOptionPane.INFORMATION_MESSAGE);
			effacergame();
		}

		if (cptclick == 9) {
			JOptionPane.showMessageDialog(null, "Il n'y a pas de gagnant !", "Match null",
					JOptionPane.INFORMATION_MESSAGE);
			effacergame();
		}

		scorejeu();

	}

	/**
	 * L'action listener des 9 boutons du jeu ou s'affiche les X ou les O
	 * @author Zaychenko
	 *
	 */
	class boutonjeu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object bsource = e.getSource();

			for (int i = 0; i < b.length; i++) {
				if (bsource == b[i]) {
					b[i].setText(alterner);
					b[i].setEnabled(false);
				}
			}

			debutalterner();
			victoire();
		}

	}
	
	/**
	 * Bouton servant à revenir au premier pannel pour changer le nom d'un ou des deux joueurs.
	 * @see JeuPanel
	 * @author Zaychenko
	 *
	 */
	class boutonchanger implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cl.show(panelct, "jeu1");

		}

	}

}
