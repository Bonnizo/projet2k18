package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class LockedScreenPanel extends JPanel implements Runnable {
	private JLabel lblMinuteBig = new JLabel();	
	private JLabel lblHourBig = new JLabel();
	private JLabel lblHour = new JLabel();
	
	private int xBegin = 0;
	private int yBegin = 0;
	private int yEnd = 0;
	private int xEnd = 0;
	
	private Calendar now = Calendar.getInstance();
	private Thread th;
	private CardLayout cardLayout;
	private JPanel contentPanel;
	
	
	public LockedScreenPanel(CardLayout cardLayout, JPanel contentPanel) {
		this.cardLayout = cardLayout;
		this.contentPanel = contentPanel;
		th = new Thread(this);
		
		th.start();
		setLayout(new BorderLayout(0, 0));
		
	    
	    JPanel centerPanel = new JPanel();
	    add(centerPanel, BorderLayout.CENTER);
	    centerPanel.setBackground(Color.BLACK);
	    centerPanel.setLayout(null);
	    
	    lblMinuteBig.setText(String.format("%02d",now.get(Calendar.MINUTE)));;
	    lblMinuteBig.setFont(new Font("Tahoma", Font.BOLD, 70));
	    lblMinuteBig.setForeground(Color.WHITE);
	    lblMinuteBig.setBounds(178, 176, 108, 92);
	    centerPanel.add(lblMinuteBig);
	    
	    lblHourBig.setText(String.format("%02d", now.get(Calendar.HOUR_OF_DAY)));
	    lblHourBig.setFont(new Font("Tahoma", Font.BOLD, 70));
	    lblHourBig.setForeground(Color.WHITE);
	    lblHourBig.setBounds(178, 82, 108, 122);
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
	    lblSamMai.setBounds(162, 262, 150, 25);
	    centerPanel.add(lblSamMai);
	    
	    JLabel lblUnlock = new JLabel("<html><center>Faites glisser le curseur sur l'écran <br /> pour le déverrouiller</center></html>");
	    lblUnlock.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblUnlock.setForeground(Color.WHITE);
	    lblUnlock.setBounds(93, 555, 304, 110);
	    centerPanel.add(lblUnlock);
	    
	    JPanel southPanel = new JPanel();
	    add(southPanel, BorderLayout.SOUTH);
	    southPanel.setBackground(Color.BLACK);
	    
	    JPanel northPanel = new JPanel();
	    add(northPanel, BorderLayout.NORTH);
	    northPanel.setBackground(Color.BLACK);
	    northPanel.setLayout(new BorderLayout(0, 0));
	    
	    JPanel topRightPanel = new JPanel();
	    topRightPanel.setBackground(Color.BLACK);
	    northPanel.add(topRightPanel, BorderLayout.EAST);
	    topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	    
	    lblHour.setText(String.format("%02d:%02d", now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE)));
	    lblHour.setFont(new Font("Tahoma", Font.BOLD, 12));
	    topRightPanel.add(lblHour);
	    lblHour.setForeground(Color.WHITE);
	    
	    JLabel lblCharge = new JLabel("100%");
	    lblCharge.setFont(new Font("Tahoma", Font.BOLD, 12));
	    topRightPanel.add(lblCharge);
	    lblCharge.setForeground(Color.WHITE);
	    
	    
	     JPanel topLeftPanel = new JPanel();
	     topLeftPanel.setBackground(Color.BLACK);
	     northPanel.add(topLeftPanel, BorderLayout.WEST);
	     
	     JLabel lblOperator= new JLabel("Swisscom");
	     lblOperator.setFont(new Font("Tahoma", Font.BOLD, 12));
	     topLeftPanel.add(lblOperator);
	     lblOperator.setForeground(Color.WHITE);
	     
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
						System.out.println("Unlock");
						System.out.println(getDistance(xBegin, yBegin, xEnd, yEnd));
						
						cardLayout.show(contentPanel, "verouiller");
						
					}
				}
			};
			addMouseListener(ml);
	     
	}
	
	private double getDistance(int xBegin, int yBegin, int xEnd, int yEnd) {
		double distance = Math.sqrt(Math.pow((xEnd-xBegin),2)+Math.pow((yEnd-yBegin), 2)); 
		return distance;
		
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(5000);
				now = Calendar.getInstance();
				lblHourBig.setText(String.format("%02d", now.get(Calendar.HOUR_OF_DAY)));
				lblMinuteBig.setText(String.format("%02d",now.get(Calendar.MINUTE)));
				lblHour.setText(String.format("%02d:%02d", now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE)));
				repaint();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
