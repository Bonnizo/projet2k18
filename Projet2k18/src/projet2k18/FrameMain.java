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
import java.io.FileNotFoundException;
import java.io.FileReader;
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

	// menu o� il y a les applications
	private JPanel menuPanel = new JPanel();

	// menu de navigation
	private JPanel navigationPanel = new JPanel();

	// panel photo
	private JPanel photoPanel = new JPanel();
		
	
	// panel Jeu
	private JPanel jeuPanel = new JPanel();
	

	//site icone https://www.flaticon.com/free-icons/
	//icone
	private ImageIcon lock = new ImageIcon("image/lock.png");
	private ImageIcon menu = new ImageIcon("image/menu.png");
	private ImageIcon close = new ImageIcon("image/shutdown.png");
	
	private ImageIcon agenda = new ImageIcon("image/contact.png");
	private ImageIcon photo = new ImageIcon("image/photo.png");
	private ImageIcon jeu = new ImageIcon("image/game.png");
	private ImageIcon reglage = new ImageIcon("image/setting.png");
	
	private ImageIcon fake1 = new ImageIcon("image/sms.png");
	private ImageIcon fake2 = new ImageIcon("image/phone.png");
	private ImageIcon fake3 = new ImageIcon("image/musique.png");
	private ImageIcon fake4 = new ImageIcon("image/youtube.png");
	private ImageIcon fake5 = new ImageIcon("image/cloud.png");
	private ImageIcon fake6 = new ImageIcon("image/facebook.png");
	private ImageIcon fake7 = new ImageIcon("image/instagram.png");
	private ImageIcon fake8 = new ImageIcon("image/time.png");
	
	// Bouton pour les app
	
	private BoutonMenu app1 = new BoutonMenu (agenda, 80, new boutonContact());
	private BoutonMenu app2 = new BoutonMenu (photo, 80, new boutonPhoto());
	private BoutonMenu app3 = new BoutonMenu (jeu, 80, new boutonJeu());
	private BoutonMenu app4= new BoutonMenu (reglage, 80, new boutonSettings());
	
	private BoutonMenu appfake1 =new BoutonMenu (fake1, 80);
	private BoutonMenu appfake2 =new BoutonMenu (fake2, 80);
	private BoutonMenu appfake3 =new BoutonMenu (fake3, 80);
	private BoutonMenu appfake4 =new BoutonMenu (fake4, 80);
	private BoutonMenu appfake5 =new BoutonMenu (fake5, 80);
	private BoutonMenu appfake6 =new BoutonMenu (fake6, 80);
	private BoutonMenu appfake7 =new BoutonMenu (fake7, 80);
	private BoutonMenu appfake8 =new BoutonMenu (fake8, 80);
	
	



	
	// Bouton pour naviguer
	private BoutonMenu nav1 = new BoutonMenu(menu, 40, new boutonMenu());
	private BoutonMenu nav2 = new BoutonMenu(lock, 40, new boutonVerou());
	private BoutonMenu nav3 = new BoutonMenu(close, 40, new boutonQuit());
	
	
	

	// panel cardlayout

	private CardLayout cardLayout = new CardLayout();
	private JPanel contentPanel = new JPanel(cardLayout);
	
	
	//panel verouiller
	
	private DotUnlockPanel verou = new DotUnlockPanel(cardLayout, contentPanel,false);
	private DotUnlockPanel changeCode = new DotUnlockPanel(cardLayout, contentPanel, true);
	private LockedScreenPanel locked= new LockedScreenPanel(cardLayout, contentPanel);

	// panel contact
	private ContactPanel contactPanel = new ContactPanel();
			
		
	
	
	

	public FrameMain() {

		// Frame

		// frame caract�ristiques
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
		contentPanel.add(changeCode,"settings");
		
		// placement menu
		contentPanel.setPreferredSize(new Dimension(400, 670));
		GridLayout menuLayout = new GridLayout(0, 3);
		menuPanel.setLayout(menuLayout);
		
		menuPanel.setBackground(Color.WHITE);

		
	
		// placement navigation

		navigationPanel.setPreferredSize(new Dimension(400, 50));
		navigationPanel.setBackground(Color.BLACK);
		FlowLayout navigationLayout = new FlowLayout(0, 70, 0);
		navigationPanel.setLayout(navigationLayout);

		
		
		//ajout bouton
	
		menuPanel.add(app1);
		menuPanel.add(app2);
		menuPanel.add(app3);
		menuPanel.add(app4);
		menuPanel.add(appfake1);
		menuPanel.add(appfake2);
		menuPanel.add(appfake3);
		menuPanel.add(appfake4);
		menuPanel.add(appfake5);
		menuPanel.add(appfake6);
		menuPanel.add(appfake7);
		menuPanel.add(appfake8);
		

		
	
		navigationPanel.add(nav1);
		navigationPanel.add(nav2);
		navigationPanel.add(nav3);
		

		
		
		
		
		
		//TESTER CARDLAYOUT
		
		photoPanel.setBackground(Color.RED);
		photoPanel.setPreferredSize(new Dimension(400,670));
		

		
		
		jeuPanel.setBackground(Color.YELLOW);
		jeuPanel.setPreferredSize(new Dimension(400,670));
		
		
	
		
		
		
		
		


		
	}
	// Creation action bouton
	class boutonSettings extends Listener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "settings");
		}
	}

	class boutonPhoto extends Listener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "photo");
		}
	}
	class boutonMenu extends Listener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "menu");
		}
	}
	class boutonJeu extends Listener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "jeu");
		}
	}
	class boutonContact extends Listener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "contact");
		}
	}
	class boutonVerou extends Listener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(contentPanel, "locked");
		}
	}
	class boutonQuit extends Listener
	{
	
		public void actionPerformed(ActionEvent e) 
		{
		System.exit(0);
		}
		
	}
}