package views.PeopleManagerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import controllers.NhanKhauManagerController.KhaiTuController;
import services.CitizenIdService;
import utils.SuggestionUtility;

import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeathCertiFrame extends javax.swing.JFrame {

	private JFrame parentJFrame = null;
	private KhaiTuController controller = null;

	private javax.swing.JButton checkBtn1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton checkBtn2;
	private com.toedter.calendar.JDateChooser jDateChooser1;
	private com.toedter.calendar.JDateChooser jDateChooser2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField soCMTngkhai;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField soCMTngchet;

	public DeathCertiFrame(JFrame parentJFrame) {

		initComponents();
		this.parentJFrame = parentJFrame;
		this.controller = new KhaiTuController();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		parentJFrame.setEnabled(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}

		});
		this.soCMTngkhai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// neu keycode == 10 ~ enter
				if (e.getKeyCode() == 10) {
					checkCMTNguoiKhai();
				}
			}
		});
		this.soCMTngchet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// neu keycode == 10 ~ enter
				if (e.getKeyCode() == 10) {
					checkCMTNguoiChet();
				}
			}
		});
	}

	private void close() {
		if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm",
				JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			this.parentJFrame.setEnabled(true);
			dispose();
		}
	}

	private void initComponents() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Khai tử");
		soCMTngkhai = new SuggestionUtility(false) {

			@Override
			public List<String> getSuggestions(String textContent) {
				CitizenIdService cidService = new CitizenIdService();
				return cidService.search(textContent);
			}
		};
		soCMTngkhai.setBounds(163, 11, 300, 30);

		soCMTngchet = new SuggestionUtility(false) {

			@Override
			public List<String> getSuggestions(String textContent) {
				CitizenIdService cidService = new CitizenIdService();
				return cidService.search(textContent);
			}
		};
		soCMTngchet.setBounds(163, 61, 300, 30);
		jPanel1 = new javax.swing.JPanel();
		jPanel1.setEnabled(false);
		jPanel1.setBackground(new Color(240, 248, 255));
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(10, 10, 143, 30);
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setBounds(10, 114, 126, 30);
		jTextField2 = new javax.swing.JTextField();
		jTextField2.setBackground(new Color(255, 255, 255));
		jTextField2.setBounds(138, 115, 418, 30);
		jButton2 = new javax.swing.JButton();
		jButton2.setBounds(450, 372, 106, 30);
		jButton3 = new javax.swing.JButton();
		jButton3.setBounds(331, 372, 106, 30);
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(12, 175, 89, 30);
		jDateChooser1 = new com.toedter.calendar.JDateChooser();
		jDateChooser1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jDateChooser1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jDateChooser1.setEnabled(false);
		jDateChooser1.setOpaque(false);
		jDateChooser1.getCalendarButton().setBackground(new Color(255, 255, 255));
		jDateChooser1.setBackground(new Color(255, 255, 255));
		jDateChooser1.setBounds(138, 175, 418, 30);
		jLabel5 = new javax.swing.JLabel();
		jLabel5.setBounds(10, 223, 91, 30);
		jDateChooser2 = new com.toedter.calendar.JDateChooser();
		jDateChooser2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jDateChooser2.setEnabled(false);
		jDateChooser2.getCalendarButton().setBackground(new Color(255, 255, 255));
		jDateChooser2.setBackground(new Color(255, 255, 255));
		jDateChooser2.setBounds(138, 223, 418, 30);
		jLabel6 = new javax.swing.JLabel();
		jLabel6.setBounds(10, 271, 91, 30);
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(137, 271, 419, 91);
		jTextArea1 = new javax.swing.JTextArea();
		checkBtn1 = new javax.swing.JButton();
		checkBtn1.setBounds(473, 10, 83, 30);
		jLabel7 = new javax.swing.JLabel();
		jLabel7.setBounds(10, 60, 140, 30);
		checkBtn2 = new javax.swing.JButton();
		checkBtn2.setBounds(473, 60, 83, 30);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel1.setText("Số CMT người khai:");

		soCMTngkhai.setFont(new Font("Tahoma", Font.PLAIN, 16));

		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel2.setText("Số giấy khai tử:");

		jTextField2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextField2.setEnabled(false);
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jButton2.setText("Xác nhận");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				confirmActionPerformed(evt);
			}
		});
		jButton2.setBackground(new Color(147, 112, 219));
		jButton2.setFont(new Font("Tahoma", Font.BOLD, 15));
		jButton2.setForeground(new Color(255, 255, 255));
		jButton2.setBorderPainted(false);

		jButton3.setText("Hủy");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelActionPerformed(evt);
			}
		});
		jButton3.setBackground(new Color(147, 112, 219));
		jButton3.setFont(new Font("Tahoma", Font.BOLD, 15));
		jButton3.setForeground(new Color(255, 255, 255));
		jButton3.setBorderPainted(false);

		jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel4.setText("Ngày khai:");

		jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel5.setText("Ngày chết:");

		jLabel6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel6.setText("Lý do chết:");

		jTextArea1.setColumns(20);
		jTextArea1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTextArea1.setRows(5);
		jTextArea1.setEnabled(false);
		jScrollPane1.setViewportView(jTextArea1);

		checkBtn1.setBorderPainted(false);
		checkBtn1.setForeground(new Color(255, 255, 255));
		checkBtn1.setBackground(new Color(147, 112, 219));
		checkBtn1.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBtn1.setText("Check");
		checkBtn1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkCMTNguoiKhai();
			}
		});

		jLabel7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel7.setText("Số CMT người chết:");

		soCMTngchet.setFont(new Font("Tahoma", Font.PLAIN, 16));

		checkBtn2.setBorderPainted(false);
		checkBtn2.setForeground(new Color(255, 255, 255));
		checkBtn2.setBackground(new Color(147, 112, 219));
		checkBtn2.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBtn2.setText("Check");
		checkBtn2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkCMTNguoiChet();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE).addContainerGap()));
		getContentPane().setLayout(layout);
		jPanel1.setLayout(null);
		jPanel1.add(jButton3);
		jPanel1.add(jButton2);
		jPanel1.add(jLabel4);
		jPanel1.add(jLabel5);
		jPanel1.add(jLabel2);
		jPanel1.add(jDateChooser1);
		jPanel1.add(jTextField2);
		jPanel1.add(jDateChooser2);
		jPanel1.add(jLabel6);
		jPanel1.add(jScrollPane1);
		jPanel1.add(jLabel1);
		jPanel1.add(soCMTngkhai);
		jPanel1.add(jLabel7);
		jPanel1.add(soCMTngchet);
		jPanel1.add(checkBtn1);
		jPanel1.add(checkBtn2);

		pack();
	}

	private void checkCMTNguoiKhai() {
		String tempCMT = this.soCMTngkhai.getText().trim();
		if (tempCMT.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập So CMT", "Warning!!", JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			try {
				long cmt = Long.parseLong(tempCMT);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập So CMT đúng định dạng!", "Warning!!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		int tempID = controller.checkCMT(this.soCMTngkhai.getText());
		if (tempID != -1) {
			JOptionPane.showMessageDialog(this, "OK!!");
		} else {
			if (JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân khẩu trong hệ thống!! Thử lại?", "Warning!!",
					JOptionPane.OK_CANCEL_OPTION) != 0) {
				close();
			}
		}
	}
	
	private void checkCMTNguoiChet() {
		String tempCMT = this.soCMTngchet.getText().trim();
		if (tempCMT.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập So CMT", "Warning!!", JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			try {
				long cmt = Long.parseLong(tempCMT);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập So CMT đúng định dạng!", "Warning!!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		int tempID = controller.checkCMT(this.soCMTngchet.getText());
		if (tempID != -1) {
			JOptionPane.showMessageDialog(this, "OK!!");
		} else {
			if (JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân khẩu trong hệ thống!! Thử lại?", "Warning!!",
					JOptionPane.OK_CANCEL_OPTION) != 0) {
				close();
			}
		}
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		close();
	}

	private void confirmActionPerformed(java.awt.event.ActionEvent evt) {
		close();
	}

	private void cancelActionPerformed(java.awt.event.ActionEvent evt) {
		close();
	}

}