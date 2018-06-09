package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class ContactPanel extends JPanel {

	// container

	private ImageIcon rajouterContact = new ImageIcon("image/plus.png");

	private ImageIcon effacerContact = new ImageIcon("image/close.png");
	private ImageIcon contactPhoto = new ImageIcon("image/close.png");
	private JLabel contactPhotol = new JLabel(contactPhoto);
	private JLabel contactPhotol2 = new JLabel(contactPhoto);
	private JLabel contactPhotol3= new JLabel(contactPhoto);
	private JLabel contactPhotol4= new JLabel(contactPhoto);
	private JLabel contactPhotol5= new JLabel(contactPhoto);
	private JLabel contactPhotol6= new JLabel(contactPhoto);
	
	// bouton contactPanel

	private BoutonMenu plus = new BoutonMenu(rajouterContact, 40, new boutonContact());
	private BoutonMenu supprimer = new BoutonMenu(effacerContact, 30, new effacerContact());

	// panel contactPanel
	private JPanel contactPanel = new JPanel();

	private JLabel contact = new JLabel("sadsadada");
	private JLabel contact1 = new JLabel("saasdadada");
	private JLabel contact2 = new JLabel("sadsadada");
	private JLabel contact3 = new JLabel("sa23dada");
	private JLabel contact4 = new JLabel("sa23dada");
	private JLabel contact5 = new JLabel("sa23dada");

	// panel en plus
	// panel liste contact
	private JPanel test = new JPanel();
	private JScrollPane listeContacts = new JScrollPane(test);

	// panel liste bouton

	private JPanel boutonContact = new JPanel();

	// cardlayout contact
	private CardLayout cardLayout2 = new CardLayout();
	private JPanel contentPanel2 = new JPanel(cardLayout2);

	private GridLayout testlayout = new GridLayout(0,2);
	// flow layout bouton

	private ContactAppli contactAppli = new ContactAppli(cardLayout2, contentPanel2);

	public ContactPanel() {

		// caractristiques page

		this.setBackground(Color.WHITE);
		setOpaque(false);
		this.add(contentPanel2);

		boutonContact.setBackground(Color.WHITE);
		
		boutonContact.setPreferredSize(new Dimension(400, 670));

		listeContacts.setPreferredSize(new Dimension(400, 670));

		contactPanel.setBackground(Color.WHITE);

		contentPanel2.add(contactPanel, "contactPanel");
		contentPanel2.add(contactAppli, "contactAppli");

		boutonContact.add(plus);
		boutonContact.add(supprimer);

		test.setBackground(Color.WHITE);
		listeContacts.setBackground(Color.WHITE);
		
		
		
		
		contactPhotol.setPreferredSize(new Dimension(50, 20));
		
		contactPhotol2.setPreferredSize(new Dimension(50, 200));
		
		contactPhotol3.setPreferredSize(new Dimension(50, 200));
		
		contactPhotol4.setPreferredSize(new Dimension(50, 200));
		
		contactPhotol5.setPreferredSize(new Dimension(50, 200));
		
		contactPhotol.setPreferredSize(new Dimension(50, 200));
		
		contactPhotol.setPreferredSize(new Dimension(50, 200));
		
		contact1.setPreferredSize(new Dimension(50, 200));
		contact2.setPreferredSize(new Dimension(50, 200));
		contact3.setPreferredSize(new Dimension(50, 200));
		contact4.setPreferredSize(new Dimension(50, 200));
		contact5.setPreferredSize(new Dimension(50, 200));
		contact3.setPreferredSize(new Dimension(50, 200));
		
		
		test.setLayout(testlayout);
		test.add(contact);
		test.add(contactPhotol);
		test.add(contact1);
		test.add(contactPhotol2);
		test.add(contact2);
		test.add(contactPhotol3);
		test.add(contact3);
		test.add(contactPhotol4);
		test.add(contact4);
		test.add(contactPhotol5);
		test.add(contact5);
		test.add(contactPhotol6);
		
		
		boutonContact.add(listeContacts, BorderLayout.CENTER);
		contactPanel.add(boutonContact, BorderLayout.NORTH);

		Border panelBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK);
		
		contact.setBorder(panelBorder);
		contact1.setBorder(panelBorder);
		contact2.setBorder(panelBorder);
		contact3.setBorder(panelBorder);
		contact4.setBorder(panelBorder);
		contact5.setBorder(panelBorder);
	
		listeContacts.revalidate();
	}

	class boutonContact extends Listener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactAppli");
		}
	}

	class effacerContact extends Listener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cardLayout2.show(contentPanel2, "contactAppli");
		}
	}
}
