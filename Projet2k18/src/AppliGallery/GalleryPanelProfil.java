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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;


/**
 * Cette classe est l'application Photo on y retrouve les différentes photos 
 * 
 * La possibilité de séléctionner les photos, les supprmiers, ou les afficher à l'écran.
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
	
	public GalleryPanelProfil(CardLayout cardLayout2, JPanel contentPanel2) {

		this.cardLayout2 = cardLayout2;
		this.contentPanel2= contentPanel2;
	
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
		
		icon = new ImageIcon("image/back.png");
		lblRetour = new JLabel(icon);
		lblRetour.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(lblRetour, BorderLayout.WEST);
		
		lblRetour.addMouseListener(new Menu());
	
	}

	class SelectImage extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (isSelected) {

				temp = (JLabel) e.getSource();
				if (temp.isEnabled()) {
					temp.setEnabled(false);
				} else {
					temp.setEnabled(true);
				}
				temp.setForeground(Color.BLACK);
				temp.setText("Deleted");
			} else {
				//appel panel diapo avec comme param le filename selectionné
				JLabel temp = (JLabel)e.getSource();
				
				diapoPanel = new DiapoPanel(cardLayout, contentPanel, temp.getIcon().toString());
		    	contentPanel.add(diapoPanel, "diapo");
		    	cardLayout.show(contentPanel, "diapo");
				
				revalidate();
				repaint();
			}
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

	

	private String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	private boolean checkExtension(File fichier) {
		String ext = getFileExtension(fichier);
		if (ext.toLowerCase().equals("jpeg") || ext.toLowerCase().equals("jpg") || ext.toLowerCase().equals("png"))
			return true;
		else
			return false;
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
