package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GalleryPanel extends JPanel{
	private ImageIcon fdp;
	private File[] listOfFiles;
	private JLabel[] imagesList;
	private GridImage gImage;
	private JPanel container = new JPanel();
	String []listContent = {"Card1", "Card2"};
	private CardLayout clGalerie = new CardLayout();
	private JPanel panel;
	private JLabel lblGalerie;
	private JLabel lblRetour;
	private JLabel lblSelect;
	private ImageIcon icon;
	private CardLayout cardLayout;
	private JPanel contentPanel;
	private Boolean isSelected = false;
	
	public GalleryPanel(CardLayout cardLayout, JPanel contentPanel) {
		
		this.cardLayout = cardLayout;
		this.contentPanel = contentPanel;
		
		
		setLayout(new BorderLayout());
		
		container.setLayout(clGalerie);
		gImage = new GridImage();
		
		JScrollPane scroll = new JScrollPane(gImage);
		container.add(scroll, listContent[0]);
		// TODO Auto-generated constructor stub
		this.add(container,BorderLayout.CENTER);
		
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
		lblRetour.addMouseListener(new returnMenu());
		lblRetour.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSelect = new JLabel("Select");
		lblSelect.addMouseListener(new returnMenu());
		lblSelect.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(lblSelect, BorderLayout.EAST);
		    
	}
	
	
	class returnMenu extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if(e.getSource().equals(lblSelect)) {
				if(!isSelected) {
					isSelected = true;
					lblSelect.setText("selection");
				}
				else if(isSelected) {
					isSelected = false;
					lblSelect.setText("select");
				}
			}
			else if(e.getSource().equals(lblRetour)) {
				cardLayout.show(contentPanel, "menu");
				isSelected = false;
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
					System.out.println("File " + listOfFiles[i].getName());
					imagesList[i] = new JLabel();
					imagesList[i].setPreferredSize(new Dimension(120, 120));
					add(imagesList[i]);
				}
		    }
		}
		
		public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        for (int i = 0; i < listOfFiles.length; i++) {
		        fdp = new ImageIcon(listOfFiles[i].getPath());
		        imagesList[i].setIcon(fdp);
	        }
	    }
	}

}
