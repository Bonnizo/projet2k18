package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LockedScreenPanel extends JPanel implements Runnable {
	private JLabel lblMinuteBig = new JLabel();	
	private JLabel lblHourBig = new JLabel();
	
	private int xBegin = 0;
	private int yBegin = 0;
	private int yEnd = 0;
	private int xEnd = 0;
	
	private Calendar now = Calendar.getInstance();
	private Thread th;
	private CardLayout cardLayout;
	private JPanel contentPanel;
	
	private NorthPanel nPanel;
	
	
	public LockedScreenPanel(CardLayout cardLayout, JPanel contentPanel) {
		this.cardLayout = cardLayout;
		this.contentPanel = contentPanel;
		th = new Thread(this);
		
		th.start();
		setLayout(new BorderLayout(0, 0));
		
	    
	    JPanel centerPanel = new JPanel();
	    add(centerPanel, BorderLayout.CENTER);
	    centerPanel.setBackground(Color.DARK_GRAY);
	    centerPanel.setLayout(null);
	    
	    lblMinuteBig.setText(String.format("%02d",now.get(Calendar.MINUTE)));;
	    
	    JLabel lblWallpaper = new JLabel();
	    lblWallpaper.setIcon(new ImageIcon("image/wallpaper.jpg"));
	    lblWallpaper.setForeground(Color.WHITE);
	    lblWallpaper.setBackground(Color.RED);
	    lblWallpaper.setBounds(0, 0, 470, 700); 
	    centerPanel.add(lblWallpaper);
	    
	   
	    lblMinuteBig.setFont(new Font("Tahoma", Font.BOLD, 70));
	    lblMinuteBig.setForeground(Color.WHITE);
	    lblMinuteBig.setBounds(160, 176, 108, 92);
	    centerPanel.add(lblMinuteBig);
	    
	    lblHourBig.setText(String.format("%02d", now.get(Calendar.HOUR_OF_DAY)));
	    lblHourBig.setFont(new Font("Tahoma", Font.BOLD, 70));
	    lblHourBig.setForeground(Color.WHITE);
	    lblHourBig.setBounds(160, 82, 108, 122);
	    centerPanel.add(lblHourBig);
	    String[] strDays = new String[] { "Dim.", "Lun.", "Mar.", "Mer.", "Jeu.", "Ven.",
	            "Sam." };
	    String[] strMonth = new String[] { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin",
        "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" };
	    String str = strDays[now.get(Calendar.DAY_OF_WEEK) - 1] + " " +Integer.toString(now.get(Calendar.DAY_OF_MONTH))+ " " + strMonth[now.get(Calendar.MONTH)];
	    
	    JLabel lblSamMai = new JLabel();
	    lblSamMai.setText(str);
	    lblSamMai.setBackground(Color.WHITE);
	    lblSamMai.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblSamMai.setForeground(Color.WHITE);
	    lblSamMai.setBounds(150, 262, 150, 25);
	    centerPanel.add(lblSamMai);
	    
	    JLabel lblUnlock = new JLabel("<html><center>Faites glisser le curseur sur l'écran <br /> pour le déverrouiller</center></html>");
	    lblUnlock.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblUnlock.setForeground(Color.WHITE);
	    lblUnlock.setBounds(65, 520, 304, 110);
	    centerPanel.add(lblUnlock);
	    
	    /*nPanel = new NorthPanel();
	    add(nPanel, BorderLayout.NORTH);*/
	    
	     
	     MouseListener ml = new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent me) {
					xBegin = me.getX();
					yBegin = me.getY();
				}

				@Override
				public void mouseReleased(MouseEvent me) {
					xEnd= me.getX();
					yEnd = me.getY();
					if(getDistance(xBegin, yBegin, xEnd, yEnd)>= 70){
						
						if(getCode().equals(""))
							cardLayout.show(contentPanel, "menu");
						else
							cardLayout.show(contentPanel, "verouiller");
						
					}
				}
			};
			addMouseListener(ml);
	     centerPanel.setComponentZOrder(lblWallpaper, 2);
	     centerPanel.setComponentZOrder(lblHourBig, 1);
	     centerPanel.setComponentZOrder(lblMinuteBig, 0);
	     centerPanel.setComponentZOrder(lblSamMai, 0);
	     centerPanel.setComponentZOrder(lblUnlock, 0);
	}
	
	private double getDistance(int xBegin, int yBegin, int xEnd, int yEnd) {
		double distance = Math.sqrt(Math.pow((xEnd-xBegin),2)+Math.pow((yEnd-yBegin), 2)); 
		return distance;
		
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
				now = Calendar.getInstance();
				lblHourBig.setText(String.format("%02d", now.get(Calendar.HOUR_OF_DAY)));
				lblMinuteBig.setText(String.format("%02d",now.get(Calendar.MINUTE)));
				
				repaint();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
