package projet2k18;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Regle extends JDialog {
	
	private JLabel texteregle, textetitre;
	
	public Regle() {
		getContentPane().setBackground(Color.BLACK);
		setUndecorated(true);
		setResizable(false);
		setSize(400,300); 
		 
		//Titre de la dialogue 
		JPanel titre = new JPanel();
		titre.setPreferredSize(new Dimension(400, 40));
		titre.setBackground(Color.BLACK);
		textetitre= new JLabel("Règles du jeu");
		textetitre.setHorizontalAlignment(SwingConstants.CENTER);
		textetitre.setForeground(Color.WHITE);
		textetitre.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));
		titre.add(textetitre);
		
		//Texte des règles 
		JPanel texte = new JPanel();
		texte.setPreferredSize(new Dimension(400, 200));
		texte.setBackground(Color.BLACK);
		texteregle= new JLabel("<html>L’objectif est de réussir à aligner trois ronds <br />" + 
				"		ou trois croix dans une grille de 3 sur 3. <br /> <br />" + 
				"		Les joueurs choisissent un des éléments, et <br />" + 
				"		jouent en alternance. La partie s’arrête <br />" + 
				"		lorsque l’un des joueurs a réussi à aligner trois <br />"+
				"		éléments, ou lorsque les 9 cases ont été <br />" + 
				"		remplies.</html>");
		texteregle.setForeground(Color.WHITE);
		texteregle.setFont(new Font("Tahoma", Font.BOLD, 16));
		texte.add(texteregle);
		
		//Bouton cancel
		JPanel cancelbouton = new JPanel();
		cancelbouton.setBackground(Color.BLACK);
		cancelbouton.setPreferredSize(new Dimension(400, 50));
		JButton cancel = new JButton("Cancel");
		cancel.setForeground(Color.BLACK);
		cancel.setBackground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelbouton.add(cancel);
		cancel.addActionListener(new ButtCancel());
		
		
		this.getContentPane().add(titre, BorderLayout.NORTH);
		this.getContentPane().add(texte, BorderLayout.CENTER);
		this.getContentPane().add(cancelbouton, BorderLayout.SOUTH);
	}
	
	class ButtCancel implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}

}

