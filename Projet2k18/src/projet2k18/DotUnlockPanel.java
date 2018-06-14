package projet2k18;

import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * <b>DotUnlockPanel est une classe h�ritant de JPanel.</b>
 * <p>
 * C'est le panel permettant la gestion du schema de d�verouillage.
 * </p>
 * <p>
 * Il permet la comparaison entre le schema enregistr� et le schema dessin� par
 * l'utilisateur. Si les deux codes correspondent, on affichera le
 * HomeScreenPanel
 * </p>
 * <p>
 * Si ce panel est g�n�r� � partir de SettingsPannel, il permet la modification
 * du schema enregistr�.
 * </p>
 * 
 * @see SettingsPannel
 * @see HomeScreenPanel
 * @author Nathan Bovier
 * @version 1.0
 */
public class DotUnlockPanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// D�claration des constantes

	/**
	 * La couleur du trait de dessin.
	 */
	private final Color INK = new Color(255, 255, 255);

	/**
	 * La couleur des points.
	 */
	private final Color DOT = Color.WHITE;

	// D�claration des tableaux/Listes

	/**
	 * Tableau de points de dessin utilis�s ou non.
	 */
	private boolean trues[] = new boolean[9];

	/**
	 * Tableau de zones permettant de savoir si le curseur passe proche d'un point.
	 */
	private Rectangle rect[] = new Rectangle[9];

	/**
	 * Tableau qui stock le code dessin�. Chaque point correspond a un entier de 1 �
	 * 9. Quand la souris passe proche d'un point, on ajoute sa valeur au tableau.
	 */
	private int pattern[] = new int[9];

	/**
	 * Tableau qui stock les traits dessin�s. Un trait correspond � la ligne
	 * dessin�e entre 2 points.
	 */
	private List<Line2D.Double> lines = new ArrayList<>();

	// D�claration des variables
	/**
	 * Thread de renouvellement du panel
	 */
	private Thread th;
	private Graphics2D g;
	private int startx, starty, endx, endy, enddx, enddy;
	private int end, start, index = 1, stroke = 2, time = 5;
	private int incw = 10, oncw;
	private boolean drawing = false;
	private Timer timer;
	private String finalPattern = "";
	private String finalPatternConfirm = "";

	private CardLayout cardLayout;
	private JPanel contentPanel;
	private Boolean changeCode;
	private JLabel lblTxt;

	/**
	 * Constructeur DotUnlockPanel.
	 * <p>
	 * A la construction d'un objet LockedScreenPanel, on cr�� un Thread qui
	 * raffraichira l'heure. On cr�er les Labels d'affichage.
	 * 
	 * </p>
	 *
	 * @param cardLayout :
	 *            L'objet CardLayout permet la navigation entre les panels
	 * @param contentPanel :
	 *            Le panel qui contiendra tous les autres panels
	 * @param changeCode :
	 * 			  Variable permettant de savoir si le panel ets en mode changement de code ou d�verouillage.
	 * 	
	 */
	public DotUnlockPanel(CardLayout cardLayout, JPanel contentPanel, Boolean changeCode) {
		this.cardLayout = cardLayout;
		this.contentPanel = contentPanel;
		this.changeCode = changeCode;

		setBackground(Color.BLACK);

		try {
			oncw = incw + 40;
			th = new Thread(this);
			setOpaque(false);
			setLayout(null);

			if (changeCode) {
				lblTxt = new JLabel("Veuillez dessiner votre nouveau mod�le");
			} else {
				lblTxt = new JLabel("Dessiner le mod�le de d�verrouillage");
			}

			lblTxt.setHorizontalAlignment(SwingConstants.CENTER);
			lblTxt.setForeground(Color.WHITE);
			lblTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTxt.setBounds(-11, 240, 430, 60);
			add(lblTxt);

			ActionListener al = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {

					if (time == 0) {

						// D�verouillage
						if (!changeCode) {
							// check si le mod�le dessin� correspond au mod�le
							// enregistr�
							for (int numDot : pattern) {

								if (numDot > 0) {
									finalPattern += Integer.toString(numDot);
								}
							}
							// Test conditionnel si le schema dessin� correspond
							// au sch�ma sauvegard�
							if (compareSchemeCode(new File("scheme"), finalPattern)) {
								cardLayout.show(contentPanel, "menu");
								resetScreen();
							} else {
								// Si le code ne correspond pas on reset l'�cran
								lblTxt.setText("Mod�le incorrect dessin�");
								resetScreen();
							}
						}
						// Changement de code
						else {

							if (finalPattern.isEmpty()) {
								for (int numDot : pattern) {

									if (numDot > 0) {
										finalPattern += Integer.toString(numDot);
										resetScreen();
									}
								}
							} else {

								for (int numDot : pattern) {

									if (numDot > 0) {

										finalPatternConfirm += Integer.toString(numDot);
										resetScreen();
									}
								}
							}

							if (!finalPattern.isEmpty() && !finalPatternConfirm.isEmpty()) {
								if (finalPattern.equals(finalPatternConfirm)) {

									// ecriture du nouveau code dans le fichier scheme
									// retour au panel menu
									FileWriter fw;
									try {
										fw = new FileWriter(new File("scheme"));
										fw.write(finalPattern);
										fw.close();

									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									cardLayout.show(contentPanel, "menu");
									resetScreen();

								} else {
									finalPatternConfirm = "";
									finalPattern = "";
								}
							}
						}
						timer.stop();
					}
					--time;
				}
			};

			timer = new Timer(1000, al);
			// Listener starts
			MouseListener ml = new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent me) {
					resetScreen();
					index = 1;
					startx = me.getX();
					starty = me.getY();
					for (int i = 0; i < rect.length; ++i) {
						if (rect[i].contains(me.getPoint())) {
							startx = (int) rect[i].getCenterX();
							starty = (int) rect[i].getCenterY();
							endx = startx;
							endy = starty;
							trues[i] = true;
							pattern[0] = i + 1;
							start = i;
							drawing = true;
							break;
						}
					}
				}

				@Override
				public void mouseReleased(MouseEvent me) {
					drawing = false;
					time = 2;
					timer.start();
				}
			};

			MouseMotionListener mll = new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent me) {
					if (drawing == true) {
						endx = me.getX();
						endy = me.getY();
						for (int i = 0; i < rect.length; ++i) {
							if (trues[i] != true) {
								if (rect[i].contains(me.getPoint())) {

									// cr�er la ligne de centre du point vers le
									// centre du point suivant
									enddx = (int) rect[i].getCenterX();
									enddy = (int) rect[i].getCenterY();
									lines.add(new Line2D.Double(startx, starty, enddx, enddy));

									// la prochaine ligne commence au centre du
									// point actuel
									startx = enddx;
									starty = enddy;

									end = i;

									start = i;
									trues[i] = true;
									pattern[index] = i + 1;
									index++;
									break;
								}
							}
						}
					}
				}
			};

			addMouseListener(ml);
			addMouseMotionListener(mll);
			// Listener ends
			th.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
     * Affiche l'image de fond.
     * 
     * @param g
     * 			composant Graphics par d�faut.
     * 
     */
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("image/wallpaper.jpg"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
     * Affiche les points du mod�le de d�verouillage.
     * 
     * @param g2
     * 			composant Graphics2D amm�lior�.
     * 
     */
	@Override
	public void paint(Graphics g2) {
		// Graphics2D est un enfant de Graphics qui permet de dessiner mieux
		g = (Graphics2D) g2;
		// Am�liore la qualit� de l'affichage
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		super.paint(g);

		int ind = 0;

		// Cr�ation du trait
		g.setColor(INK); // Couleur
		g.setStroke(new BasicStroke(incw, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Forme
																							// du
																							// trait

		// Dessine les lignes entre le point et le curseur
		if (drawing == true) {
			g.drawLine(startx, starty, endx, endy);
		}

		// Dessine les lignes entre les points
		for (int i = 0; i < lines.size(); ++i) {
			g.draw(lines.get(i));
		}

		// Cr�ation du rond autour de point
		g.setColor(DOT); // Couleur
		g.setStroke(new BasicStroke(stroke)); // taille

		// Affichage centr� des points
		for (int i = (getWidth() / 3) / 2; i < getWidth(); i += getWidth() / 3) {
			for (int j = (getHeight() / 2); j < getHeight(); j += getHeight() / 5) {
				// Dessine les points
				g.fillOval(i - incw / 2, j - incw / 2, incw, incw); // i-incw /
																	// 2 permet
																	// de
																	// centrer

				// Si le curseur est dans la zone du point on dessine un rond
				// autour
				if (trues[ind] == true) {
					g.drawOval(i - oncw / 2, j - oncw / 2, oncw, oncw);
				}

				rect[ind] = new Rectangle();
				rect[ind].setLocation(i - (oncw) / 2, j - (oncw) / 2);
				rect[ind].setSize(oncw + stroke / 2, oncw + stroke / 2);
				ind++;
			}
		}
	}

	/**
     * Fonction de comparaison entre code stock� et code dessin�.
     * 
     * @return true :
     * 			Si les sch�mas sont identiques.
     * <br />
     * false:
     * 			Si les sch�mas ne correspondent pas.
     * 
     * @see DotUnlockPanel#finalPattern
     * 
     */
	private Boolean compareSchemeCode(File file, String pattern) {
		//File file = new File("scheme");
		FileReader fr;
		String str = "";
		
		//lecture du fichier scheme stock�
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
		
		//Comparaison des 2 schemas
		if (str.equals(pattern)) {
			return true;
		}
		return false;
	}

	/**
     * Fonction de r�initialisation de l'�cran.<br />
     * Le timer s'arr�te, les variables du schema sont remises � z�ro. <br />
     * les lignes s'effacent.
     * 
     * 
     * @see DotUnlockPanel#clearPattern()
     * @see DotUnlockPanel#makeFalse()
     * 
     */
	private void resetScreen() {
		if (timer.isRunning()) {
			timer.stop();
		}

		clearPattern();
		lines.clear();
		makeFalse();
	}
	
	/**
     * Remet tous les points comme inutilis�s.
     * 
     * @see DotUnlockPanel#trues
     */
	private void makeFalse() {
		for (int i = 0; i < trues.length; ++i) {
			trues[i] = false;
		}
	}

	/**
     * R�initialise la valeur des patterns.
     * 
     * @see DotUnlockPanel#pattern
     * @see DotUnlockPanel#finalPattern
     */
	private void clearPattern() {
		if (!changeCode) {
			finalPattern = "";
			for (int i = 0; i < pattern.length; ++i) {
				pattern[i] = 0;
			}
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (changeCode) {
					if (finalPattern.isEmpty()) {
						lblTxt.setText("Veuillez dessiner votre nouveau mod�le");
					} else if (finalPatternConfirm.isEmpty()) {
						lblTxt.setText("Veuillez confirmer le nouveau mod�le");
					}

				}
				Thread.sleep(10);
				repaint();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}
