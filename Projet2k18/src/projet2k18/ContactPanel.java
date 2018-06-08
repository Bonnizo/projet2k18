package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ContactPanel extends JPanel {

	// container
	private JPanel contactListPanel = new JPanel();

	private ImageIcon rajouterContact = new ImageIcon("image/plus.png");

	private ImageIcon effacerContact = new ImageIcon("image/close.png");

	// bouton contactPanel

	private BoutonMenu plus = new BoutonMenu(rajouterContact, 40, new boutonContact());
	private BoutonMenu supprimer = new BoutonMenu(effacerContact, 30, new effacerContact());

	// panel contactPanel
	private JPanel contactPanel = new JPanel();

	private JLabel contact = new JLabel("sadsadada");
	private JLabel contact1 = new JLabel("saasdadada");
	private JLabel contact2 = new JLabel("sadsadada");
	private JLabel contact3 = new JLabel("sa23dada");
	

	// panel en plus
	// panel liste contact
	private JPanel listeContacts = new JPanel();

	// panel liste bouton

	private JPanel boutonContact = new JPanel();

	// cardlayout contact
	private CardLayout cardLayout2 = new CardLayout();
	private JPanel contentPanel2 = new JPanel(cardLayout2);

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

		listeContacts.setBackground(Color.WHITE);
		contact.setPreferredSize(new Dimension(400, 20));
		contact1.setPreferredSize(new Dimension(400, 20));
		contact2.setPreferredSize(new Dimension(400, 20));
		contact3.setPreferredSize(new Dimension(400, 20));
		
		listeContacts.add(contact, BorderLayout.NORTH);
		
		listeContacts.add(contact1, BorderLayout.NORTH);
		listeContacts.add(contact2, BorderLayout.NORTH);
		listeContacts.add(contact3, BorderLayout.NORTH);

		
		boutonContact.add(listeContacts, BorderLayout.CENTER);
		contactPanel.add(boutonContact, BorderLayout.NORTH);

		Border panelBorder = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK);

		contact.setBorder(panelBorder);
		contact1.setBorder(panelBorder);
		contact2.setBorder(panelBorder);
		contact3.setBorder(panelBorder);
		
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
