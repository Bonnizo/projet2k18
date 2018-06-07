package projet2k18;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


import projet2k18.RoundedBorder;

public class FrameMain extends JFrame {

	// liste jPanel
	// Smartphone solide (contour )
	private JPanel smartphonePanel = new JPanel();

	// menu où il y a les applications
	private JPanel menuPanel = new JPanel();

	// menu de navigation
	private JPanel navigationPanel = new JPanel();

	// panel photo
	private JPanel photoPanel = new JPanel();
		
	
	// panel Jeu
	private JPanel jeuPanel = new JPanel();
	

	
		
	
	//site icone https://www.flaticon.com/free-icons/
	// liste boutton pour les app

	private BoutonApp  app1 = new BoutonApp("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\face.png");
	private BoutonApp  app2 = new BoutonApp ("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\face.png");
	private BoutonApp  app3 = new BoutonApp ("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\face.png");
	private BoutonApp  app4 = new BoutonApp ("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\face.png");
	private BoutonApp  app5 = new BoutonApp ("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\face.png");
	private BoutonApp  app6 = new BoutonApp ("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\face.png");
	private BoutonApp  app7 = new BoutonApp ("autre");
	private BoutonApp  app8 = new BoutonApp ("autre");
	private BoutonApp  app9 = new BoutonApp ("autre");
	private BoutonApp  app10 = new BoutonApp ("autre");
	private BoutonApp  app11 = new BoutonApp ("autre");
	private BoutonApp  app12 = new BoutonApp ("autre");
	private BoutonApp  app13 = new BoutonApp ("autre");
	private BoutonApp  app14 = new BoutonApp ("autre");
	private BoutonApp  app15 = new BoutonApp ("autre");

	// naviguer
	private BoutonNav nav1 = new BoutonNav("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\menu.png");
	private BoutonNav nav2 = new BoutonNav("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\lock.png");
	private BoutonNav nav3 = new BoutonNav("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\images\\IconeBouton\\turn-off.png");

	// panel cardlayout

	private CardLayout cardLayout = new CardLayout();
	private JPanel contentPanel = new JPanel(cardLayout);
	
	
	//panel verouiller
	
		private DotUnlockPanel verou = new DotUnlockPanel(cardLayout, contentPanel,false false);
	private DotUnlockPanel changeCode = new DotUnlockPanel(cardLayout, contentPanel, true);
	private LockedScreenPanel locked= new LockedScreenPanel(cardLayout, contentPanel);

	// panel contact
			private ContactPanel contactPanel = new ContactPanel();
			
			
	
	

	public FrameMain() {

		// Frame

		// frame caractéristiques
		setResizable(false);
		setUndecorated(true);
		setBackground(Color.BLACK);
		setLocation(200, 100);
		setSize(480, 800);
		setShape(new RoundRectangle2D.Double(20, 0, 440, 735, 20, 20));

		// Smartphone

		setContentPane(smartphonePanel);
		smartphonePanel.setOpaque(false);
		smartphonePanel.add(contentPanel);
		smartphonePanel.add(navigationPanel);

		// ajout panel pour cardlayout
		
		contentPanel.add(locked, "locked");
		contentPanel.add(verou, "verouiller");
		contentPanel.add(menuPanel, "menu");
		contentPanel.add(photoPanel,"photo" );
		contentPanel.add(contactPanel,"contact" );
		contentPanel.add(jeuPanel, "jeu");
	
		
		// placement menu

		menuPanel.setPreferredSize(new Dimension(400, 670));
		FlowLayout menuLayout = new FlowLayout(0, 40, 45);
		menuPanel.setLayout(menuLayout);
		menuPanel.setBackground(Color.WHITE);

		
	
		// placement navigation

		navigationPanel.setPreferredSize(new Dimension(400, 50));
		navigationPanel.setBackground(Color.BLACK);
		FlowLayout navigationLayout = new FlowLayout(45, 70, 0);
		navigationPanel.setLayout(navigationLayout);

		/*
		 * {//fond ecran protected void paintComponent(Graphics g) {
		 * super.paintComponents(g); ImageIcon fond = new ImageIcon(
		 * "C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\Image\\FondEcran\\menu2.jpg"
		 * ); Image fondMenu = fond.getImage(); g.drawImage(fondMenu, 0, 0, this); } };
		 */

		/*
		 * 
		 * 
		 * 
		 * 
		 * //creation des boutons des applications avec photo centrée
		 * 
		 * 
		 * app1.setHorizontalTextPosition(AbstractButton.CENTER);
		 * app1.setBackground(Color.BLACK);
		 * 
		 * 
		 * //creation bouton navigation
		 * 
		 * 
		 * 		 * nav1.setBackground(Color.RED);
		 * nav2.setHorizontalTextPosition(AbstractButton.CENTER);
		 * nav2.setBackground(Color.RED);
		 * nav3.setHorizontalTextPosition(AbstractButton.CENTER);
		 * nav3.setBackground(Color.RED);
		 * 
		 * 
		 * 
		 */
	

		// ajout bouton
		menuPanel.add(app1);
		menuPanel.add(app2);
		menuPanel.add(app3);
		menuPanel.add(app4);
		menuPanel.add(app5);
		menuPanel.add(app6);
		menuPanel.add(app7);
		menuPanel.add(app8);
		menuPanel.add(app9);
		menuPanel.add(app10);
		menuPanel.add(app11);
		menuPanel.add(app12);
		menuPanel.add(app13);
		menuPanel.add(app14);
		menuPanel.add(app15);

		
	
		navigationPanel.add(nav1);
		navigationPanel.add(nav2);
		navigationPanel.add(nav3);

		
		
		
		
		
		//TESTER CARDLAYOUT
		
		photoPanel.setBackground(Color.RED);
		photoPanel.setPreferredSize(new Dimension(400,670));
		

		
		
		jeuPanel.setBackground(Color.YELLOW);
		jeuPanel.setPreferredSize(new Dimension(400,670));
		
		
		
		//action bouton app
		app1.addActionListener(new boutonContact());
		app2.addActionListener(new boutonPhoto());
		app3.addActionListener(new boutonJeu());
		
		
		
		//action bouton navigation
		
		nav1.addActionListener(new boutonMenu());
		nav2.addActionListener(new boutonVerou());
		nav3.addActionListener(new boutonQuit());
		
		
		
		


		
	}
	// Creation action bouton

	class boutonPhoto implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "photo");
		}
	}
	class boutonMenu implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "menu");
		}
	}
	class boutonJeu implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "jeu");
		}
	}
	class boutonContact implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "contact");
		}
	}
	class boutonVerou implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "locked");
		}
	}
	class boutonQuit implements ActionListener 
	{
	
		public void actionPerformed(ActionEvent e) 
		{
		System.exit(0);
		}
		
	}
}