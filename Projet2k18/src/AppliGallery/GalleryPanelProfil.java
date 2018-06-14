package AppliGallery;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import AppliGallery.DiapoPanel.GridImage;
import projet2k18.ContactModification;
import projet2k18.ContactPanel;
import projet2k18.PersonneInfo;

import javax.swing.JFileChooser;


/**
 * Cette classe est la possibilité d'ajouter une photo à un contact en ouvrant un nouveau pannel avec des images 
 * 
 * 
 * 
 * @see menu
 * 
 * @author Victor 
 * @author Nathan
 * @author Zaychenko
 *
 */
public class GalleryPanelProfil extends JPanel {

	private ImageIcon imgIcon;
	private File[] listOfFiles;
	private JLabel[] imagesList;
	private GridImage gImage;
	private JPanel container = new JPanel();
	private CardLayout clGalerie = new CardLayout();
	private JPanel panel;
	private JLabel lblGalerie;
	private JLabel lblRetour;
	private JLabel lblSelect;
	private ImageIcon icon;
	private CardLayout cardLayout;
	private JPanel contentPanel;
	private Boolean isSelected = false;
	private JLabel temp;
	private JPanel panel_1;
	private JLabel lblTrash;
	private JScrollPane scroll;
	private JPanel SouthPanelGallery;
	private JLabel lblAdd;
	private JFileChooser fileChooser = new JFileChooser();
	private DiapoPanel diapoPanel;
	private ImageIcon image ;
	private CardLayout cardLayout2;
	private JPanel contentPanel2;
	private Boolean isProfilePicture = false;
	PersonneInfo p;
	private String filenameZ;
	public GalleryPanelProfil(CardLayout cardLayout2, JPanel contentPanel2, Boolean isProfilePicture, PersonneInfo p, String filename) {

		this.cardLayout2 = cardLayout2;
		this.contentPanel2= contentPanel2;
		this.isProfilePicture = isProfilePicture;
		this.p = p;
		this.filenameZ = filename;
		
		setLayout(new BorderLayout());
		container.setLayout(clGalerie);
		refillGrid();

		setGalleryMenuPanel();

	}

	private void refillGrid() {
		// TODO Auto-generated constructor stub
		gImage = new GridImage();

		scroll = new JScrollPane(gImage);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		container.add(scroll);
		add(container, BorderLayout.CENTER);
	}

	private void setGalleryMenuPanel() {
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		lblGalerie = new JLabel("Galerie");
		lblGalerie.setHorizontalAlignment(SwingConstants.CENTER);
		lblGalerie.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblGalerie, BorderLayout.CENTER);
		
	
	}

	class SelectImage extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {

			PersonneInfo person = p;
			JLabel test = (JLabel)e.getSource();

			String filename = test.getIcon().toString();
			p.setPhoto(filename);
			
			try {
				FileOutputStream out = new FileOutputStream(filenameZ);
				ObjectOutputStream oos = new ObjectOutputStream(out);
				oos.writeObject(p);

				oos.close();
			} catch (IOException f) {
				// …
			}
			ContactPanel cPanel = new ContactPanel();
	    	contentPanel2.add(cPanel, "addProfilePicture");
	    	cardLayout2.show(contentPanel2, "addProfilePicture");
		}
	}

	class Menu extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(lblRetour)) {
				cardLayout2.show(contentPanel2, "contactPanel");
				isSelected = false;
			} 
			
		}
	}

	class GridImage extends JPanel {

		public GridImage() {
			setLayout(new GridLayout(0, 3));
			fillGrid();
		}

		private void fillGrid() {
			File folder = new File("Photo");
			listOfFiles = folder.listFiles();
			imagesList = new JLabel[listOfFiles.length];
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					imagesList[i] = new JLabel();
					imagesList[i].setPreferredSize(new Dimension(120, 120));
					imagesList[i].addMouseListener(new SelectImage());
					imagesList[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
					add(imagesList[i]);
				}
			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < listOfFiles.length; i++) {
				imgIcon = new ImageIcon(listOfFiles[i].getPath());
				imagesList[i].setIcon(imgIcon);
			}
		}
	}
}