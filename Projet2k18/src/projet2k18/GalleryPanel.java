package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
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
public class GalleryPanel extends JPanel {

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

	public GalleryPanel(CardLayout cardLayout, JPanel contentPanel) {

		this.cardLayout = cardLayout;
		this.contentPanel = contentPanel;
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
		lblRetour.addMouseListener(new Menu());
		lblRetour.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(lblRetour, BorderLayout.WEST);
		
		
		panel_1 = new JPanel();
		lblTrash = new JLabel("");
		lblTrash.addMouseListener(new Menu());
		panel_1.add(lblTrash);
		lblSelect = new JLabel("Select  ");
		panel_1.add(lblSelect);
		lblSelect.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(panel_1, BorderLayout.EAST);
		
		SouthPanelGallery = new JPanel();
		icon = new ImageIcon("image/plus.png");
		lblAdd = new JLabel(icon);
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblAdd.addMouseListener(new Menu());
		SouthPanelGallery.add(lblAdd);
		lblSelect.addMouseListener(new Menu());
		add(SouthPanelGallery, BorderLayout.SOUTH);
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
			if (e.getSource().equals(lblSelect)) {
				if (!isSelected) {
					isSelected = true;
					lblSelect.setText("selection  ");
					icon = new ImageIcon("image/trash.png");
					lblTrash.setIcon(icon);
					lblTrash.setCursor(new Cursor(Cursor.HAND_CURSOR));
				} else if (isSelected) {
					isSelected = false;
					lblSelect.setText("select  ");
					lblTrash.setIcon(null);
					for (int i = 0; i < imagesList.length; i++) {
						if (!imagesList[i].isEnabled()) {
							imagesList[i].setEnabled(true);
						}
					}

				}
			} else if (e.getSource().equals(lblRetour)) {
				cardLayout.show(contentPanel, "menu");
				isSelected = false;
			} else if (e.getSource().equals(lblTrash)) {
				for (int i = 0; i < imagesList.length; i++) {
					if (!imagesList[i].isEnabled()) {
						File deletedFile = new File(imagesList[i].getIcon().toString());
						deletedFile.delete();
					}
				}
				gImage = null;
				container.remove(scroll);
				remove(container);
				refillGrid();
				revalidate();
				repaint();
			} else if (e.getSource().equals(lblAdd)) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "jpeg", "png");

				fileChooser.setFileFilter(filter);
				fileChooser.setMultiSelectionEnabled(true);
				int reponse = fileChooser.showOpenDialog(null);
				if (reponse == fileChooser.APPROVE_OPTION) {

					File[] fs = fileChooser.getSelectedFiles();
					String location = "Photo\\";
					int cptExistantImage = 0;
					for (int i = 0; i < fs.length; i++) {
						String path = location + fs[i].getName();
						File destination;

						Path source = fs[i].toPath();

						if (checkExtension(fs[i]) == true) {
							String choosedFile = fs[i].getName().substring(0, fs[i].getName().lastIndexOf("."));
							for (int j = 0; j < imagesList.length; j++) {
								String existingFilename = imagesList[j].getIcon().toString();
								existingFilename = existingFilename.substring(location.length(),
										existingFilename.lastIndexOf("."));
								if (choosedFile.equals(existingFilename) == true) {
									cptExistantImage++;
								}

							}
							if (cptExistantImage > 0) {
								String choosedFileExt = getFileExtension(fs[i]);
								destination = new File(
										location + choosedFile + "(" + cptExistantImage + ")." + choosedFileExt);
							} else {
								destination = new File(path);
							}
							try {
								System.out.println(source);
								Files.copy(source, destination.toPath());
							} catch (IOException e1) {
								e1.printStackTrace();
							}

						} else {
							break;
						}
					}
					gImage = null;
					container.remove(scroll);
					remove(container);
					refillGrid();
					revalidate();
					repaint();
				}
				if (reponse == fileChooser.CANCEL_OPTION) {
					fileChooser.cancelSelection();
					return;
				}
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
