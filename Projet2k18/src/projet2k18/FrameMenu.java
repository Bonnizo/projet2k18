package projet2k18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import projet2k18.RoundedBorder;

public class FrameMenu extends JFrame {

	public FrameMenu() {
		
		Icon agenda = new ImageIcon("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\Image\\IconeMenu\\agenda.jpg");
		Icon casino = new ImageIcon("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\Image\\IconeMenu\\casino.png");
		Icon album = new ImageIcon("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\Image\\IconeMenu\\album.jpg");
	
		
		
		
		
		
		
		
	
		
		
		JFrame FrameMenu = new JFrame("Menu");

		JPanel menu = new JPanel()
	
		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponents(g);
				ImageIcon fond = new ImageIcon("C:\\Users\\Victor\\Desktop\\ProgJava\\projet2k18\\Image\\FondEcran\\menu2.jpg");
				Image fondMenu = fond.getImage();
				g.drawImage(fondMenu, 0,0, this);
			}
		};
		
		
		FlowLayout menuLayout = new FlowLayout(0, 65, 80);
		menu.setLayout(menuLayout);
		
				
		
		JButton app1 = new JButton(agenda);
		app1.setHorizontalTextPosition(AbstractButton.CENTER);
		JButton app2 = new JButton(casino);
		app2.setHorizontalTextPosition(AbstractButton.CENTER);
		JButton app3 = new JButton(album);
		app3.setHorizontalTextPosition(AbstractButton.CENTER);
		JButton app4 = new JButton(album);
		app3.setHorizontalTextPosition(AbstractButton.CENTER);
		JButton app5 = new JButton(album);
		app3.setHorizontalTextPosition(AbstractButton.CENTER);
		JButton app6 = new JButton(album);
		app3.setHorizontalTextPosition(AbstractButton.CENTER);
		JButton app7 = new JButton(album);
		app3.setHorizontalTextPosition(AbstractButton.CENTER);
		JButton app8 = new JButton(album);
		app3.setHorizontalTextPosition(AbstractButton.CENTER);
		JButton app9 = new JButton(album);
		app3.setHorizontalTextPosition(AbstractButton.CENTER);
		
	


		app1.setPreferredSize(new Dimension(70, 70));
		app2.setPreferredSize(new Dimension(70, 70));
		app3.setPreferredSize(new Dimension(70, 70));
		app4.setPreferredSize(new Dimension(70, 70));
		app5.setPreferredSize(new Dimension(70, 70));
		app6.setPreferredSize(new Dimension(70, 70));
		app7.setPreferredSize(new Dimension(70, 70));
		app8.setPreferredSize(new Dimension(70, 70));
		app9.setPreferredSize(new Dimension(70, 70));

		app1.setBorder(new RoundedBorder(20));
		app2.setBorder(new RoundedBorder(20));
		app3.setBorder(new RoundedBorder(20));
		app4.setBorder(new RoundedBorder(20));
		app5.setBorder(new RoundedBorder(20));
		app6.setBorder(new RoundedBorder(20));
		app7.setBorder(new RoundedBorder(20));
		app8.setBorder(new RoundedBorder(20));
		app9.setBorder(new RoundedBorder(20));

	
		
		menu.add(app1);
		menu.add(app2);
		menu.add(app3);
		menu.add(app4);
		menu.add(app5);
		menu.add(app6);
		menu.add(app7);
		menu.add(app8);
		menu.add(app9);
		
		
		
		
		
		FrameMenu.add(menu);
		FrameMenu.setBackground(Color.red);
		FrameMenu.setResizable(false);
		FrameMenu.setSize(480, 800);
		FrameMenu.setUndecorated(true);
		FrameMenu.setShape(new RoundRectangle2D.Double(2, 2, 480, 800, 100, 100));
		FrameMenu.setVisible(true);

	}
	
	

}