package projet2k18;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GalleryPanel extends JPanel{
	private ImageIcon fdp;
	private File[] listOfFiles;
	private JButton[] buttons;
	public GalleryPanel() {
		setLayout(new GridLayout(0, 3));
		
		
		// TODO Auto-generated constructor stub
		File folder = new File("Photo");
		listOfFiles = folder.listFiles();
		buttons = new JButton[listOfFiles.length];
	    for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				buttons[i] = new JButton();
				add(buttons[i]);
			}
	    }
		    
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < listOfFiles.length; i++) {
	        fdp = new ImageIcon(listOfFiles[i].getPath());
	        buttons[i].setIcon(fdp);
        }
    }
	
	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		
		fenetre.add(new GalleryPanel());
		fenetre.setSize(460, 800);
		fenetre.setVisible(true);
	}

}
