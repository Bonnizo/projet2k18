package projet2k18;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
/**
 * La JDialog qui affiche les règles du jeu 
 * @author Zaychenko
 *
 */
public class Regle extends JDialog {
	
	private JLabel texteregle, textetitre;
	private JLabel text;

	/**
	 * Constructeur de la JDialog 
	 */
	public Regle() {
		getContentPane().setBackground(Color.BLACK);
		setUndecorated(true);
		setResizable(false);
		setSize(398,300); 
		
		//Centrer la JDialog
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - this.getWidth()) / 2;
		final int y = (screenSize.height - this.getHeight()) / 2;
		this.setLocation(x, y);

		//Titre de la dialogue 
		textetitre= new JLabel("Règles du jeu");
		textetitre.setHorizontalAlignment(SwingConstants.CENTER);
		textetitre.setForeground(Color.WHITE);
		textetitre.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 30));

		
		//Texte des règles 
//		texteregle= new JLabel("<html>L’objectif est de réussir à aligner trois ronds <br />" + 
//				"		ou trois croix dans une grille de 3 sur 3. <br /> <br />" + 
//				"		Les joueurs choisissent un des éléments, et <br />" + 
//				"		jouent en alternance. La partie s’arrête <br />" + 
//				"		lorsque l’un des joueurs a réussi à aligner trois <br />"+
//				"		éléments, ou lorsque les 9 cases ont été <br />" + 
//				"		remplies.</html>");
//		texteregle.setForeground(Color.WHITE);
//		texteregle.setFont(new Font("Tahoma", Font.BOLD, 16));

		//Text des règles en lecture
		text= new JLabel(LireRegle("TextRegle/Regle.txt"));
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Tahoma", Font.BOLD, 16));
		
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

		
		getContentPane().add(textetitre, BorderLayout.NORTH);
		getContentPane().add(text, BorderLayout.CENTER);
		getContentPane().add(cancelbouton, BorderLayout.SOUTH);
	}
	
	/**
	 * Lis un fichier texte contenant les règles du jeu
	 * @param file le texte ayant les règles
	 * @return le texte qui le met dans un JLabel
	 */
	public String LireRegle(String file )
    {
		//Lis le fichier
        String texttt = "";
        String text;
        try
        {
        	FileReader fin = new FileReader(file);
            BufferedReader bin = new BufferedReader(fin);
             
            while( (text = bin.readLine()) != null )
            	texttt += text+"\n";
        }
        catch( Exception e )
        {
        	System.out.println(e.getMessage());
        }  
         
        return "<html>"+texttt+"</html>";
    }
	
	/**
	 * Ferme la JDialog 
	 * @see JEuPanel
	 * @author Zaychenko
	 *
	 */
	class ButtCancel implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}

}

