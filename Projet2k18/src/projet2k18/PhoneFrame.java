package projet2k18;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class PhoneFrame extends JFrame{
	
	
	public PhoneFrame() {
		 	//setUndecorated(true);							//Enlever la bar de titre
	        //getContentPane().setBackground(Color.BLACK);	//mettre la couleur � la fenetre
	        setSize(460,800);								//d�finir la taille
	        //setShape(new RoundRectangle2D.Double(30,30, 350,200, 50,100));//mettre une forme � la fenetre
	        //f.setType(Type.UTILITY); 
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocation(300, 50);
			//getContentPane().setBackground(Color.BLACK);
			setLayout(new BorderLayout());
			setPanel(new DotUnlockPanel());
			setVisible(true);		
	}
	
	public void setPanel(Object jpanel) {
		add((Component) jpanel, BorderLayout.CENTER);
	}

	
}
