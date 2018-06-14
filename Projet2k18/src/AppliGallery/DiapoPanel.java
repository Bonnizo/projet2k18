package AppliGallery;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class DiapoPanel extends JPanel {
	private CardLayout cardLayout;
	private JPanel contentPanel;
	
	private JPanel northDiapoPanel;
	private JPanel southDiapoPanel;
	private JPanel container = new JPanel();
	private GridImage gImage;
	
	
	private String filename;
	
	private JLabel lblDiapo;
	private JLabel lblReturn;
	private JLabel lblTrash;
	private ImageIcon icon;
	private JLabel lblNext;
	private JLabel lblPrevious;
	
	
	private JLabel lblImage;
	private ImageIcon imgIcon;
	
	private File[] listOfFiles;
	
	private int id = 0;
	private int numberOfImage = 0;
	
	public DiapoPanel(CardLayout cardLayout, JPanel contentPanel, String filename) {

		this.cardLayout = cardLayout;
		this.contentPanel = contentPanel;
		this.filename = filename;
		getIdOnFolder(filename);
		setLayout(new BorderLayout());
		setDiapoMenuPanel();
		showImage();
	}
	
	private void showImage() {
		gImage = new GridImage();
		container.setBackground(Color.BLACK);
		container.add(gImage);
		add(container, BorderLayout.CENTER);
	}
	
	private void resetPanel() {
		southDiapoPanel.removeAll();
		northDiapoPanel.removeAll();
		removeAll();
		gImage = null;
		container.removeAll();
		setDiapoMenuPanel();
		showImage();
		revalidate();
		repaint();
		
	}
	
	private void setDiapoMenuPanel() {
		northDiapoPanel = new JPanel();
		add(northDiapoPanel, BorderLayout.NORTH);
		northDiapoPanel.setLayout(new BorderLayout());

		lblDiapo = new JLabel("Diaporama");
		lblDiapo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiapo.setFont(new Font("Tahoma", Font.BOLD, 18));
		northDiapoPanel.add(lblDiapo, BorderLayout.CENTER);
		
		icon = new ImageIcon("image/back.png");
		lblReturn = new JLabel(icon);
		lblReturn.addMouseListener(new Menu());
		lblReturn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		northDiapoPanel.add(lblReturn, BorderLayout.WEST);
		
		
		southDiapoPanel = new JPanel();
		southDiapoPanel.setLayout(new BorderLayout());
		
		icon = new ImageIcon("image/trash.png");
		lblTrash = new JLabel(icon);
		lblTrash.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTrash.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblTrash.setSize(new Dimension(120, 50));
		lblTrash.addMouseListener(new Menu());
		southDiapoPanel.add(lblTrash, BorderLayout.CENTER);
		
		icon = new ImageIcon("image/next.png");
		lblNext = new JLabel(icon);
		lblNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNext.addMouseListener(new Menu());
		southDiapoPanel.add(lblNext, BorderLayout.EAST);
		
		if(id == numberOfImage-1) {
			lblNext.setEnabled(false);
		}
		
		icon = new ImageIcon("image/previous.png");
		lblPrevious = new JLabel(icon);
		lblPrevious.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblPrevious.addMouseListener(new Menu());
		southDiapoPanel.add(lblPrevious, BorderLayout.WEST);
		
		if(id == 0) {
			lblPrevious.setEnabled(false);
		}
		
		add(southDiapoPanel, BorderLayout.SOUTH);
	}
	
	class GridImage extends JPanel {

		public GridImage() {
			
			fillGrid();
		}

		private void fillGrid() {
			lblImage = new JLabel();
			add(lblImage);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			imgIcon = new ImageIcon(filename);
			lblImage.setIcon(imgIcon);
		}
	}
	
	
	class Menu extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			File folder = new File("Photo");
			listOfFiles = folder.listFiles();
			numberOfImage = listOfFiles.length;
			
			if(e.getSource().equals(lblReturn)) {
				GalleryPanel gPanel = new GalleryPanel(cardLayout, contentPanel);
				contentPanel.add(gPanel, "photo2");
				cardLayout.show(contentPanel, "photo2");
			}
			else if(e.getSource().equals(lblNext) && (id+2) != numberOfImage) {
					id += 1;
					filename = listOfFiles[id].toString();
					resetPanel();
			}
			else if(e.getSource().equals(lblPrevious) && id != 0) {
					System.out.println("WTF");
					id -=1;
					filename = listOfFiles[id].toString();
					resetPanel();
			}
			else if(e.getSource().equals(lblTrash)) {
				File deletedFile = new File(filename);
				deletedFile.delete();
				id += 1;
				filename = listOfFiles[id].toString();
				resetPanel();
			}
		}
		
	}
	
	private void getIdOnFolder(String filename) {
		File folder = new File("Photo");
		listOfFiles = folder.listFiles();
		numberOfImage = listOfFiles.length;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].toString().equals(filename)) {
				id = i;
				break;
			}
		}
	}
}
