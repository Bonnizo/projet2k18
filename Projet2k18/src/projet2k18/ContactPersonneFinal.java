package projet2k18;

import java.awt.BorderLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;

public class ContactPersonneFinal extends JFrame{
	private final JScrollPane scrollPane = new JScrollPane();

	public ContactPersonneFinal() {
	    
		
			//création page
		  	this.setTitle("Création de contact");
		    this.setSize(400, 500);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		    
		    getContentPane().add(scrollPane, BorderLayout.CENTER);
		    this.setVisible(true);
		    
		    
		    
		    //On prévient notre JFrame que notre JPanel sera son content pane
		                  
		    this.setVisible(true);
		
		
			
	
	
	
	
}	
}
