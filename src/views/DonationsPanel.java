package views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DonationsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JFrame parentFrame;

	public DonationsPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 806, 593);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOTHING HERE --------------");
		lblNewLabel.setBounds(238, 130, 454, 141);
		add(lblNewLabel);
	}
}
