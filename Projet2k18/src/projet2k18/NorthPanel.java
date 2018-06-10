package projet2k18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NorthPanel extends JPanel{

	private JLabel lblHour = new JLabel();
	private Calendar now = Calendar.getInstance();

	public NorthPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.BLACK);
		JPanel topRightPanel = new JPanel();
		topRightPanel.setBackground(Color.BLACK);
		add(topRightPanel, BorderLayout.EAST);
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
		add(topLeftPanel, BorderLayout.WEST);

		JLabel lblOperator = new JLabel("Swisscom");
		lblOperator.setFont(new Font("Tahoma", Font.BOLD, 12));
		topLeftPanel.add(lblOperator);
		lblOperator.setForeground(Color.WHITE);
	}

}
