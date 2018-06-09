package projet2k18;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSettingsTitle = new JLabel("R\u00E9glages");
		lblSettingsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettingsTitle.setFont(new Font("Serif", Font.BOLD, 30));
		panel.add(lblSettingsTitle, BorderLayout.NORTH);
		
		JPanel panelSettingsBtn = new JPanel();
		panel.add(panelSettingsBtn, BorderLayout.CENTER);
		panelSettingsBtn.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnChangeCode = new JButton("changer le code");
		btnChangeCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentPanel, "changeCode");
			}
		});
		panelSettingsBtn.add(btnChangeCode);
		
		JButton btnResetCode = new JButton("enlever code");
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
	}
	
	

}
