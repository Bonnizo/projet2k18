package projet2k18;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

import projet2k18.RoundedBorder;

public class FrameMenu extends JFrame {

	public FrameMenu() {

		
			//image des icones du menu
		Icon agenda = new ImageIcon("Image/IconeMenu/contact.png");
		Icon casino = new ImageIcon("Image/IconeMenu/casino.png");
		Icon album = new ImageIcon("\\Image\\IconeMenu\\album.jpg");

		
		//Smartphone solide (contour )
		BorderLayout ecran = new BorderLayout();
		JPanel Smartphone = new JPanel();
		Smartphone.setLayout(ecran);
		Smartphone.setBackground(Color.BLACK);

		//JFRAME DE DEPART depuis le menu 
		JFrame FrameMenu = new JFrame("Menu");

		
		//menu où il y a les applications 
		JPanel menu = new JPanel();
	
		
		// menu de navigation 
		JPanel navigation = new JPanel();
		
/*
		{//fond ecran
			protected void paintComponent(Graphics g) {
				super.paintComponents(g);
				ImageIcon fond = new ImageIcon(
						"C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\Image\\FondEcran\\menu2.jpg");
				Image fondMenu = fond.getImage();
				g.drawImage(fondMenu, 0, 0, this);
			}
		};*/
		
		//placement navigation
		navigation.setBounds(10, 710, 400, 50);
		navigation .setBackground(Color.BLUE);
		FlowLayout navigationLayout = new FlowLayout(0, 40, 50);
		menu.setLayout(navigationLayout);
		
		
		//placement menu 
		menu.setBounds(10, 40, 400, 670);
		FlowLayout menuLayout = new FlowLayout(0, 40, 45);
		menu.setLayout(menuLayout);
		menu.setBackground(Color.WHITE);
		


		//creation des boutons des applications  avec photo centrée
		
		JButton app1 = new JButton(agenda);
		app1.setHorizontalTextPosition(AbstractButton.CENTER);
		app1.setBackground(Color.BLACK);
		app1.setForeground(Color.BLACK);
		JButton app2 = new JButton(casino);
		app2.setHorizontalTextPosition(AbstractButton.CENTER);
		app2.setBackground(Color.BLACK);
		JButton app3 = new JButton(album);
		app3.setHorizontalTextPosition(AbstractButton.CENTER);
		app3.setBackground(Color.BLACK);
		JButton app4 = new JButton(album);
		app4.setHorizontalTextPosition(AbstractButton.CENTER);
		app4.setBackground(Color.BLACK);
		JButton app5 = new JButton(album);
		app5.setHorizontalTextPosition(AbstractButton.CENTER);
		app5.setBackground(Color.BLACK);
		JButton app6 = new JButton(album);
		app6.setHorizontalTextPosition(AbstractButton.CENTER);
		app6.setBackground(Color.BLACK);
		JButton app7 = new JButton(album);
		app7.setHorizontalTextPosition(AbstractButton.CENTER);
		app7.setBackground(Color.BLACK);
		JButton app8 = new JButton(album);
		app8.setHorizontalTextPosition(AbstractButton.CENTER);
		app8.setBackground(Color.BLACK);
		JButton app9 = new JButton(album);
		app9.setHorizontalTextPosition(AbstractButton.CENTER);
		app9.setBackground(Color.BLACK);
		JButton app10 = new JButton(album);
		app10.setHorizontalTextPosition(AbstractButton.CENTER);
		app10.setBackground(Color.BLACK);
		JButton app11 = new JButton(album);
		app11.setHorizontalTextPosition(AbstractButton.CENTER);
		app11.setBackground(Color.BLACK);
		JButton app12 = new JButton(album);
		app12.setHorizontalTextPosition(AbstractButton.CENTER);
		app12.setBackground(Color.BLACK);
		JButton app13 = new JButton(album);
		app13.setHorizontalTextPosition(AbstractButton.CENTER);
		app13.setBackground(Color.BLACK);
		JButton app14 = new JButton(album);
		app14.setHorizontalTextPosition(AbstractButton.CENTER);
		app14.setBackground(Color.BLACK);
		JButton app15 = new JButton(album);
		app15.setHorizontalTextPosition(AbstractButton.CENTER);
		app15.setBackground(Color.BLACK);
		
		//creation bouton navigation
		
		
		
		
		//bouton d'accueil 
		JButton bouton = new JButton() {
			protected void paintComponent(Graphics g) 
			{ g.setColor(getBackground());
			g.fillOval(400, 300, 200, 100);
			super.paintComponent(g); }
		};
		

		//redimension bouton
		app1.setPreferredSize(new Dimension(80, 80));
		app2.setPreferredSize(new Dimension(80, 80));
		app3.setPreferredSize(new Dimension(80, 80));
		app4.setPreferredSize(new Dimension(80, 80));
		app5.setPreferredSize(new Dimension(80, 80));
		app6.setPreferredSize(new Dimension(80, 80));
		app7.setPreferredSize(new Dimension(80, 80));
		app8.setPreferredSize(new Dimension(80, 80));
		app9.setPreferredSize(new Dimension(80, 80));
		app10.setPreferredSize(new Dimension(80, 80));
		app11.setPreferredSize(new Dimension(80, 80));
		app12.setPreferredSize(new Dimension(80, 80));
		app13.setPreferredSize(new Dimension(80, 80));
		app14.setPreferredSize(new Dimension(80, 80));
		app15.setPreferredSize(new Dimension(80, 80));
		
		// arrondir bouton !--> comment enlever ce quil depasse ??<--!
		app1.setBorder(new RoundedBorder(20));
		app2.setBorder(new RoundedBorder(20));
		app3.setBorder(new RoundedBorder(20));
		app4.setBorder(new RoundedBorder(20));
		app5.setBorder(new RoundedBorder(20));
		app6.setBorder(new RoundedBorder(20));
		app7.setBorder(new RoundedBorder(20));
		app8.setBorder(new RoundedBorder(20));
		app9.setBorder(new RoundedBorder(20));
		app10.setPreferredSize(new Dimension(80, 80));
		app11.setPreferredSize(new Dimension(80, 80));
		app12.setPreferredSize(new Dimension(80, 80));
		app13.setPreferredSize(new Dimension(80, 80));
		app14.setPreferredSize(new Dimension(80, 80));
		app15.setPreferredSize(new Dimension(80, 80));

		//ajout bouton
		menu.add(app1);
		menu.add(app2);
		menu.add(app3);
		menu.add(app4);
		menu.add(app5);
		menu.add(app6);
		menu.add(app7);
		menu.add(app8);
		menu.add(app9);
		menu.add(app10);
		menu.add(app11);
		menu.add(app12);
		menu.add(app13);
		menu.add(app14);
		menu.add(app15);
		
/*			//ajout bouton menu
	
		Smartphone.add(bouton, BorderLayout.SOUTH);
*/
		
		//ajout des panels sur frame
		
		FrameMenu.add(menu);
		FrameMenu.add(navigation);
		FrameMenu.add(Smartphone);
	
		
		//frame caractéristiques
		FrameMenu.setResizable(false);
		FrameMenu.setSize(420, 800);
		FrameMenu.setUndecorated(true);
		FrameMenu.setShape(new RoundRectangle2D.Double(2, 2, 420, 800, 100, 100));
		FrameMenu.setVisible(true);
		FrameMenu.setLocation(450, 100);
	}

}