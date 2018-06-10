package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * <b>LockedScreenPanel est un classe héritant de JPanel.</b>
 * <p>
 * C'est le premier panel afficher lors du démaragge de l'application: Ce panel
 * affiche l'heure, et un fond d'écran
 * </p>
 * <p>
 * De plus, il est possible de passer au panel suivant avec un Drag&Drop comme
 * sur Android
 * </p>
 * <p>
 * Si un modèle est enregistré, le Drag&Drop affichera le panel DotUnlockPanel
 * <br />
 * Sinon, le HomeScreenPanel sera affiché
 * </p>
 * 
 * @see DotUnlockPanel
 * @see HomeScreenPanel
 * @author Nathan Bovier
 * @version 1.0
 */
public class LockedScreenPanel extends JPanel implements Runnable {

	/**
	 * Label d'affichage des minutes
	 */
	private JLabel lblMinuteBig = new JLabel();

	/**
	 * Label d'affichage des heures
	 */
	private JLabel lblHourBig = new JLabel();

	/**
	 * coordonnée x du début de Drag&Drop
	 */
	private int xBegin = 0;

	/**
	 * coordonnée y du début de Drag&Drop
	 */
	private int yBegin = 0;

	/**
	 * coordonnée y de fin de Drag&Drop
	 */
	private int yEnd = 0;

	/**
	 * coordonnée x de fin de Drag&Drop
	 */
	private int xEnd = 0;

	/**
	 * Calendrier pour récupérer la date et l'heure actuelle
	 */
	private Calendar now = Calendar.getInstance();

	/**
	 * Thread de rafraichissement de l'heure
	 */
	private Thread th;

	/**
	 * Layout Manager
	 */
	private CardLayout cardLayout;

	/**
	 * Panel qui contient tous les autres pannels pour la gestion de la
	 * nagvigation
	 */
	private JPanel contentPanel;

	/**
	 * Constructeur LockedScreenPanel.
	 * <p>
	 * A la construction d'un objet LockedScreenPanel, on créé un Thread qui
	 * raffraichira l'heure. On créer les Labels d'affichage.
	 * 
	 * </p>
	 *
	 * @param cardLayout
	 *            L'objet CardLayout permet la navigation entre les panels
	 * @param contentPanel
	 *            Le panel qui contiendra tous les autres panels
	 * 
	 * @see LockedScreenPanel#cardLayout
	 * @see LockedScreenPanel#contentPanel
	 */
	public LockedScreenPanel(CardLayout cardLayout, JPanel contentPanel) {
		// Récupération des paramètres
		this.cardLayout = cardLayout;
		this.contentPanel = contentPanel;

		setLayout(new BorderLayout(0, 0));

		// Création du Thread de rafraichissement
		th = new Thread(this);
		th.start();

		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBackground(Color.DARK_GRAY);
		centerPanel.setLayout(null);

		// Création de l'image de fond
		JLabel lblWallpaper = new JLabel();
		lblWallpaper.setIcon(new ImageIcon("image/wallpaper.jpg"));
		lblWallpaper.setForeground(Color.WHITE);
		lblWallpaper.setBackground(Color.RED);
		lblWallpaper.setBounds(0, 0, 470, 700);
		centerPanel.add(lblWallpaper);

		// Création des labels de l'heure
		lblMinuteBig.setText(String.format("%02d", now.get(Calendar.MINUTE)));
		;
		lblMinuteBig.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblMinuteBig.setForeground(Color.WHITE);
		lblMinuteBig.setBounds(160, 176, 108, 92);
		centerPanel.add(lblMinuteBig);

		lblHourBig.setText(String.format("%02d", now.get(Calendar.HOUR_OF_DAY)));
		lblHourBig.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblHourBig.setForeground(Color.WHITE);
		lblHourBig.setBounds(160, 82, 108, 122);
		centerPanel.add(lblHourBig);

		// Gestion pour afficher au bond format la date et le mois
		String[] strDays = new String[] { "Dim.", "Lun.", "Mar.", "Mer.", "Jeu.", "Ven.", "Sam." };
		String[] strMonth = new String[] { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août",
				"Septembre", "Octobre", "Novembre", "Décembre" };
		String str = strDays[now.get(Calendar.DAY_OF_WEEK) - 1] + " " + Integer.toString(now.get(Calendar.DAY_OF_MONTH))
				+ " " + strMonth[now.get(Calendar.MONTH)];

		JLabel lblSamMai = new JLabel();
		lblSamMai.setText(str);
		lblSamMai.setBackground(Color.WHITE);
		lblSamMai.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSamMai.setForeground(Color.WHITE);
		lblSamMai.setBounds(150, 262, 150, 25);
		centerPanel.add(lblSamMai);

		// Création du label qui explique comment décverouiller
		JLabel lblUnlock = new JLabel(
				"<html><center>Faites glisser le curseur sur l'écran <br /> pour le déverrouiller</center></html>");
		lblUnlock.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUnlock.setForeground(Color.WHITE);
		lblUnlock.setBounds(65, 520, 304, 110);
		centerPanel.add(lblUnlock);

		//Gestion de l'évènement de Drag&Drop
		MouseListener ml = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				//Au clic de la souris, on récupère la coordonnée x et y
				xBegin = me.getX();
				yBegin = me.getY();
			}

			@Override
			public void mouseReleased(MouseEvent me) {
				//Au relachement de la souris, on récupère la coordonnée x et y
				xEnd = me.getX();
				yEnd = me.getY();
				
				//Si la distance de clic est suffisament grande on passe à DotUnlockPannel ou HomeScreenPanel
				if (getDistance(xBegin, yBegin, xEnd, yEnd) >= 70) {
					//S'il n'y a pas de code, on passe directement au menu
					//Sinon on passe au DotUnlockPanel
					if (getCode().equals(""))
						cardLayout.show(contentPanel, "menu");
					else
						cardLayout.show(contentPanel, "verouiller");

				}
			}
		};
		addMouseListener(ml);
		//Affichage de l'image en arrière plan grâce au ZIndex
		centerPanel.setComponentZOrder(lblWallpaper, 2);
		centerPanel.setComponentZOrder(lblHourBig, 1);
		centerPanel.setComponentZOrder(lblMinuteBig, 0);
		centerPanel.setComponentZOrder(lblSamMai, 0);
		centerPanel.setComponentZOrder(lblUnlock, 0);
	}
	
	/**
     * calcule et retourne la distance entre la coordonnée initiale et finale du Drag&Drop.
     * 
     * @param xBegin
     * 			coordonnée x du début de Drag&Drop
     * 
     * @param yBegin
     * 			coordonnée y du début de Drag&Drop
     * 
     * @param xEnd
     * 			coordonnée x de fin de Drag&Drop
     * 
     * @param yEnd
     * 			coordonnée y de fin de Drag&Drop
     * 
     * @return La distance entre la coordonnée initiale et finale du Drag&Drop
     * 
     * @see LockedScreenPanel#xBegin
     * @see LockedScreenPanel#yBegin
     * @see LockedScreenPanel#xEnd
     * @see LockedScreenPanel#yEnd
     */
	private double getDistance(int xBegin, int yBegin, int xEnd, int yEnd) {
		double distance = Math.sqrt(Math.pow((xEnd - xBegin), 2) + Math.pow((yEnd - yBegin), 2));
		return distance;
	}
	
	/**
     * Récupère la contenu du fichier scheme, contenant le code pour déverouiller le natel.
     * 
     * @return le code pour déverouiller le natel sous la forme (124673)
     * 
     * @see DotUnlockPanel
     */
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
				now = Calendar.getInstance();
				lblHourBig.setText(String.format("%02d", now.get(Calendar.HOUR_OF_DAY)));
				lblMinuteBig.setText(String.format("%02d", now.get(Calendar.MINUTE)));
				repaint();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
