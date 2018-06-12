package projet2k18;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class SettingsPanel extends JPanel {

	private CardLayout cardLayout;
	private JPanel contentPanel;
	private FileWriter fw;

	
	public SettingsPanel(CardLayout cardLayout, JPanel contentPanel) {
		this.cardLayout = cardLayout;
		this.contentPanel = contentPanel;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(0, 0,0));
		
		JLabel lblSettingsTitle = new JLabel("R\u00E9glages");
		lblSettingsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettingsTitle.setFont(new Font("Serif", Font.BOLD, 30));
		lblSettingsTitle.setPreferredSize(new Dimension(390,50));
		panel.add(lblSettingsTitle, BorderLayout.NORTH);
		panel.setBackground(Color.WHITE);
		
		
		JPanel panelSettingsBtn = new JPanel();
		panel.add(panelSettingsBtn, BorderLayout.CENTER);
		panelSettingsBtn.setLayout(new GridLayout(0, 2));
		
		ImageIcon btnChangeCodeImage = new ImageIcon("image/lockSettings.png");
		JButton btnChangeCode = new JButton(btnChangeCodeImage);
		btnChangeCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPanel, "changeCode");
			}
		});
		panelSettingsBtn.add(btnChangeCode);
		
		ImageIcon btnResetCodeImage = new ImageIcon("image/nolock.png");
		JButton btnResetCode = new JButton(btnResetCodeImage);
		btnResetCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fw = new FileWriter(new File("scheme"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fw.write("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cardLayout.show(contentPanel, "menu");
			}
		});
		panelSettingsBtn.add(btnResetCode);
		// TODO Auto-generated constructor stub
		
		Border btnBorder = BorderFactory.createMatteBorder(1, 1, 1,1 , Color.BLACK);
		
		
		
		btnChangeCode.setBackground(Color.WHITE);
		btnChangeCode.setPreferredSize(new Dimension (200,635));
		btnResetCode.setBackground(Color.WHITE);
		btnResetCode.setPreferredSize(new Dimension (200,635));
		btnChangeCode.setBorder(btnBorder);
		btnResetCode.setBorder(btnBorder);
		
	
	}
	
	

}
