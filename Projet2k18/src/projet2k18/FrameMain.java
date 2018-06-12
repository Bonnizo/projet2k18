package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Victor
 *
 *
 *
 * <b>Frame Main gère tout l'affichage des principales class du smartphone.</b>
 * <p>
 * Depuis cette class représente donc le menu du smartphone.
 * </p>
 * 
 * 
 * @see Main
 * @see SettingsPannel
 * @see HomeScreenPanel
 * @see GamePanel
 * @see ContactPanel
 * @see GalleryPanel
 * @author Victor Bonny
 * @version 1.0
 */
 
public class FrameMain extends JFrame implements Runnable{

	// liste jPanel
	// Smartphone solide (contour )
	private JPanel smartphonePanel = new JPanel();

	// menu où il y a les applications
	private JPanel menuPanel = new JPanel();

	// menu de navigation
	private JPanel navigationPanel = new JPanel();

	
		
	

	

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
	
	private BoutonMenu appfake1 =new BoutonMenu (fake1, 80, new btnsHome());
	private BoutonMenu appfake2 =new BoutonMenu (fake2, 80, new btnsHome());
	private BoutonMenu appfake3 =new BoutonMenu (fake3, 80, new btnsHome());
	private BoutonMenu appfake4 =new BoutonMenu (fake4, 80, new btnsHome());
	private BoutonMenu appfake5 =new BoutonMenu (fake5, 80, new btnsHome());
	private BoutonMenu appfake6 =new BoutonMenu (fake6, 80, new btnsHome());
	private BoutonMenu appfake7 =new BoutonMenu (fake7, 80, new btnsHome());
	private BoutonMenu appfake8 =new BoutonMenu (fake8, 80, new btnsHome());
	
	



	
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
	private SettingsPanel settings = new SettingsPanel(cardLayout, contentPanel);
	private LockedScreenPanel locked= new LockedScreenPanel(cardLayout, contentPanel);

	// panel photo
	private GalleryPanel photoPanel = new GalleryPanel(cardLayout, contentPanel);
	
	// panel contact
	private ContactPanel contactPanel = new ContactPanel();
	//jeu
	private JeuPanel jeuPanel = new JeuPanel();
		
	private NorthPanel nPanel = new NorthPanel();
	
	

	public FrameMain() {

		// Frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		// frame caractéristiques
		setResizable(false);
		setUndecorated(true);
		setBackground(Color.BLACK);
		setLocation((int)(screenWidth/2)-240, (int)(screenHeight/2)-410);
		//setSize(480, 800);
		//setShape(new RoundRectangle2D.Double(20, 0, 440, 735, 20, 20));
		setSize(480, 820);
		setShape(new RoundRectangle2D.Double(20, 0, 440, 765, 20, 20));
		
		
		// Smartphone
		//smartphonePanel.setLayout(new BorderLayout());
		setContentPane(smartphonePanel);
		smartphonePanel.setOpaque(false);
		
		smartphonePanel.add(nPanel);
		smartphonePanel.add(contentPanel);
		smartphonePanel.add(navigationPanel);

		// ajout panel pour cardlayout
	
		contentPanel.add(locked, "locked");
		
		contentPanel.add(verou, "verouiller");
		contentPanel.add(menuPanel, "menu");
		contentPanel.add(photoPanel,"photo" );
		contentPanel.add(contactPanel,"contact" );
		contentPanel.add(jeuPanel, "jeu");
		contentPanel.add(changeCode,"changeCode");
		contentPanel.add(settings,"settings");
		
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
		
		//photoPanel.setBackground(Color.RED);
		photoPanel.setPreferredSize(new Dimension(400,670));
		
		contactPanel.setBackground(Color.WHITE);
	}
	class btnsHome extends Listener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			URI uri = null;
			if(e.getSource().equals(appfake4)){
				try {
					uri = new URI("https://www.youtube.com");
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getSource().equals(appfake5)){
				try {
					uri = new URI("http://www.meteosuisse.admin.ch/home.html?tab=overview");
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			try {
				java.awt.Desktop.getDesktop().browse(uri);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
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
			if(getCode().equals("")) {
				cardLayout.show(contentPanel, "menu");
			}
			else {
				cardLayout.show(contentPanel, "verouiller");
			}
				
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
	
	private String getCode() {
		File file = new File("scheme");
		FileReader fr;
		String str = "";

		try {
			fr = new FileReader(file);
			int i = 0;

			while ((i = fr.read()) != -1) {
				str += (char) i;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}

	
	@Override
	public void run() {
		try {
			while (true) {
				
				Thread.sleep(5000);
				System.out.println("test");
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}