package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class CreateNewHouseholdRegistrationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldBookNo;
	private JTextField txtFieldHouseholder;
	private JTextField txtFieldHouseNo;
	private JTextField txtFieldHamlet;

	public CreateNewHouseholdRegistrationFrame() {	
		this.setResizable(false);
		this.setTitle("Add a new household registration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 200, 600, 431);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 566, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm mới hộ khẩu");
		lblNewLabel.setBounds(199, 5, 167, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 55, 566, 329);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 546, 35);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Số hộ khẩu");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(0, 0, 164, 35);
		panel_2.add(lblNewLabel_1);
		
		txtFieldBookNo = new JTextField();
		txtFieldBookNo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtFieldBookNo.setBounds(163, 0, 383, 35);
		panel_2.add(txtFieldBookNo);
		txtFieldBookNo.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 55, 546, 35);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Chủ hộ");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(0, 0, 164, 35);
		panel_3.add(lblNewLabel_2);
		
		txtFieldHouseholder = new JTextField();
		txtFieldHouseholder.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtFieldHouseholder.setBounds(163, 0, 383, 35);
		panel_3.add(txtFieldHouseholder);
		txtFieldHouseholder.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 100, 546, 35);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Số nhà");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(0, 0, 164, 35);
		panel_4.add(lblNewLabel_3);
		
		txtFieldHouseNo = new JTextField();
		txtFieldHouseNo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtFieldHouseNo.setBounds(163, 0, 383, 35);
		panel_4.add(txtFieldHouseNo);
		txtFieldHouseNo.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 145, 546, 35);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Thôn");
		lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(0, 0, 164, 35);
		panel_5.add(lblNewLabel_4);
		
		txtFieldHamlet = new JTextField();
		txtFieldHamlet.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtFieldHamlet.setBounds(163, 0, 383, 35);
		panel_5.add(txtFieldHamlet);
		txtFieldHamlet.setColumns(10);

		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 190, 546, 35);
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 235, 546, 35);
		panel_1.add(panel_7);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.setBounds(237, 280, 101, 39);
		panel_1.add(btnNewButton);
	}
}
