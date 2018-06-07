package projet2k18;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ContactPanel extends JPanel {

	// container
	private JPanel contactListPanel = new JPanel();



	

	// bouton test

	private JButton nav = new JButton("dfsfdfs");

	//panel test
	private JPanel test = new JPanel ();

	//cardlayout contact
	private CardLayout cardLayout2 = new CardLayout();
	private JPanel contentPanel2 = new JPanel(cardLayout2);
	
	
	
	private ContactAppli test2 = new ContactAppli(cardLayout2, contentPanel2);

	public ContactPanel() {

		//caractristiques page
	
		this.add(contentPanel2);
		test.setBackground(Color.RED);
		test.add(nav);
		
		contentPanel2.add(test, "test");
		contentPanel2.add(test2, "test2");
		
		
		
		
		
		nav.addActionListener(new boutonContact());
		
		
	}
	
	class boutonContact implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout2.show(contentPanel2, "test2");
		}
	}
}
