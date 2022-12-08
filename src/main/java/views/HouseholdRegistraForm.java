package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Cursor;
import javax.swing.JPopupMenu;

public class HouseholdRegistraForm extends JFrame {
	private int maxSizeOfFeild=51;
	private JTextField txtPleaseInput;
	private JTextField textField;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseholdRegistraForm frame = new HouseholdRegistraForm();
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
	public HouseholdRegistraForm() {
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("Household Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 601);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Household Register Form");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel.setBounds(115, 0, 189, 54);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số hộ khẩu");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 44, 76, 32);
		getContentPane().add(lblNewLabel_1);
		
		txtPleaseInput = new JTextField("Please input");
		txtPleaseInput.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtPleaseInput.setActionCommand("");
		txtPleaseInput.setAutoscrolls(false);
		txtPleaseInput.setBounds(44, 79, 317, 31);
		getContentPane().add(txtPleaseInput);
		txtPleaseInput.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ tên chủ hộ");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(34, 121, 95, 32);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tỉnh/Thành phố trực thuộc trung ương");
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(34, 194, 257, 32);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quận/Thành phố/Huyện");
		lblNewLabel_1_3.setFont(new Font("SansSerif",Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(34, 260, 170, 32);
		getContentPane().add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField.setText("please input");
		textField.setColumns(10);
		textField.setAutoscrolls(false);
		textField.setBounds(44, 152, 317, 31);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Phường/Xã");
		lblNewLabel_1_3_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(34, 335, 76, 32);
		getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Số nhà(nếu có)");
		lblNewLabel_1_3_1_1.setFont(new Font("SansSerif",Font.PLAIN, 14));
		lblNewLabel_1_3_1_1.setBounds(35, 411, 108, 32);
		getContentPane().add(lblNewLabel_1_3_1_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("SansSerif",Font.PLAIN, 12));
		textField_4.setText("please input");
		textField_4.setColumns(10);
		textField_4.setAutoscrolls(false);
		textField_4.setBounds(44, 442, 317, 31);
		getContentPane().add(textField_4);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(44, 225, 317, 31);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("111111111111111111111111111111111111111111111111111");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(44, 293, 317, 31);
		getContentPane().add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("111111111111111111111111111111111111111111111111111");
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(44, 370, 317, 31);
		getContentPane().add(menuBar_2);
		
		JMenu mnNewMenu_2 = new JMenu("1111111111111111111111111111111111111111111111111");
		menuBar_2.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(316, 528, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(215, 528, 89, 23);
		getContentPane().add(btnNewButton_1);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
