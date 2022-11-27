package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import javax.swing.border.LineBorder;

import controller.AccountsController;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel loginPane;
	private JTextField txtFieldUserName;
	private JPasswordField passwordField;
	private JButton btnLoginButton;
	private JLabel lblLoginWarning;

	public JButton getBtnLoginButton() {
		return btnLoginButton;
	}

	public void setBtnLoginButton(JButton btnLoginButton) {
		this.btnLoginButton = btnLoginButton;
	}

	public JTextField getTxtFieldUserName() {
		return txtFieldUserName;
	}

	public void setTextFieldUserName(JTextField textField) {
		this.txtFieldUserName = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
	public JLabel getLblLoginWarning() {
		return lblLoginWarning;
	}
	
	public void setLblLoginWarning(JLabel lblLoginWarning) {
		this.lblLoginWarning = lblLoginWarning;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {

		this.setResizable(false);
		this.setTitle("Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 200, 700, 450);
		this.setLocationRelativeTo(null);
		loginPane = new JPanel();
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(loginPane);
		loginPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 255));
		panel.setBounds(10, 10, 315, 403);
		loginPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Welcome!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 204, 255));
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(10, 94, 295, 205);
		panel.add(lblNewLabel_1);

		JPanel content_pane = new JPanel();
		content_pane.setBackground(new Color(255, 255, 255));
		content_pane.setBounds(325, 10, 361, 403);
		loginPane.add(content_pane);
		content_pane.setLayout(null);

		txtFieldUserName = new JTextField();
		txtFieldUserName.setBounds(39, 105, 291, 30);
		txtFieldUserName.setForeground(new Color(0, 0, 0));
		txtFieldUserName.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtFieldUserName.setBackground(new Color(255, 255, 255));
		txtFieldUserName.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		content_pane.add(txtFieldUserName);
		txtFieldUserName.setColumns(10);
		txtFieldUserName.addKeyListener(new AccountsController(this));


		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 10));
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(39, 180, 291, 30);
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		content_pane.add(passwordField);
		passwordField.addKeyListener(new AccountsController(this));

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setIcon(null);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(39, 75, 91, 30);
		content_pane.add(lblUsername);

		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(39, 145, 91, 37);
		content_pane.add(lblPassword);
		
		lblLoginWarning = new JLabel("*");
		lblLoginWarning.setBounds(39, 220, 291, 13);
		lblLoginWarning.setVisible(false);
		content_pane.add(lblLoginWarning);

		JButton btnLoginButton = new JButton("Login");
		btnLoginButton.setOpaque(false);
		btnLoginButton.setForeground(new Color(0, 0, 0));
		btnLoginButton.setBackground(new Color(0, 102, 255));
		btnLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoginButton.setBounds(39, 243, 291, 37);
		btnLoginButton.addActionListener(new AccountsController(this));
		content_pane.add(btnLoginButton);

		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(39, 21, 128, 30);
		content_pane.add(lblNewLabel);

	}
}

