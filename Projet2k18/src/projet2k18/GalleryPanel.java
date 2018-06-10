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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GalleryPanel extends JPanel{
	
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
		container.add(scroll);
		add(container,BorderLayout.CENTER);
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
		panel.add(lblRetour, BorderLayout.WEST);
		lblRetour.addMouseListener(new Menu());
		lblRetour.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.EAST);
		
		lblTrash = new JLabel("");
		lblTrash.addMouseListener(new Menu());
		panel_1.add(lblTrash);
		lblSelect = new JLabel("Select  ");
		panel_1.add(lblSelect);
		lblSelect.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSelect.addMouseListener(new Menu());
		
	}
	
	class SelectImage extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if(isSelected) {
				
				temp =  (JLabel)e.getSource();
				if(temp.isEnabled()) {
					temp.setEnabled(false);
				}
				else {
					temp.setEnabled(true);
				}
				temp.setForeground(Color.BLACK);
				temp.setText("Deleted");
			} else {
				
			}
		}
	}
	
	class Menu extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if(e.getSource().equals(lblSelect)) {
				if(!isSelected) {
					isSelected = true;
					lblSelect.setText("selection  ");
					icon = new ImageIcon("image/trash.png");
					lblTrash.setIcon(icon);
					lblTrash.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				else if(isSelected) {
					isSelected = false;
					lblSelect.setText("select  ");
					lblTrash.setIcon(null);
					
				}
			}
			else if(e.getSource().equals(lblRetour)) {
				cardLayout.show(contentPanel, "menu");
				isSelected = false;
			}
			else if(e.getSource().equals(lblTrash)) {
				for(int i = 0; i < imagesList.length; i++) {
					if(!imagesList[i].isEnabled()) {
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
			}
			
		}
		
	}
	
	class GridImage extends JPanel {
		
		public GridImage() {
			setLayout(new GridLayout(0,3));
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
