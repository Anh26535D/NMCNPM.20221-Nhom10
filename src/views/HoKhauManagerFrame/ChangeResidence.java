package views.HoKhauManagerFrame;

import controllers.HoKhauManagerController.ChuyenDiNoiKhacController;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import bean.HoKhauBean;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author User
 */
public class ChangeResidence extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private ChuyenDiNoiKhacController controller;
	private HoKhauBean hoKhauBean;
	private JFrame parentJFrame;

	private javax.swing.JButton cancelBtn;
	private javax.swing.JButton confirmBtn;
	private javax.swing.JTextField diaChiChuyenDenJtf;
	private javax.swing.JTextField diaChiHienTaiJtf;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea lyDoJta;
	private javax.swing.JTextField maHoKhauJtf;
	private javax.swing.JTextField maKhuVucJtf;
	private javax.swing.JTextField searchJtf;
	private javax.swing.JPanel tableJpn;
	private javax.swing.JPanel panel3;
	private javax.swing.JTextField tenChuHoJtf;

	/**
	 * Creates new form ChuyenDiNoiKhac
	 */
	public ChangeResidence(JFrame parentJFrame) {
		this.setResizable(false);
		this.setTitle("Thay doi ho khau");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(350, 200, 1210, 677);
		this.setLocationRelativeTo(null);

		JPanel contentPane = new JPanel();
		contentPane.setBounds(350, 200, 700, 450);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		jPanel1 = new JPanel();
		jPanel1.setBounds(0, 0, 1196, 640);
		jPanel1.setBackground(new Color(230, 230, 250));
		jPanel1.setLayout(null);
		contentPane.add(jPanel1);

		jPanel2 = new JPanel();
		jPanel2.setBounds(13, 63, 1168, 567);
		jPanel2.setBackground(new Color(240, 248, 255));
		jPanel2.setLayout(null);
		jPanel1.add(jPanel2);

		tableJpn = new JPanel();
		tableJpn.setBounds(23, 57, 507, 445);
		tableJpn.setLayout(null);
		jPanel2.add(tableJpn);

		jLabel13 = new JLabel();
		jLabel13.setBounds(557, 189, 145, 30);
		jPanel2.add(jLabel13);

		jLabel11 = new JLabel();
		jLabel11.setBounds(557, 139, 145, 30);
		jPanel2.add(jLabel11);

		jLabel9 = new JLabel();
		jLabel9.setBounds(557, 89, 145, 30);
		jPanel2.add(jLabel9);

		jLabel15 = new JLabel();
		jLabel15.setBounds(1130, 190, 30, 30);
		jLabel15.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); 
		jLabel15.setForeground(new java.awt.Color(255, 0, 0));
		jLabel15.setText("(*)");

		jLabel16 = new JLabel();
		jLabel16.setBounds(557, 239, 145, 30);
		jPanel2.add(jLabel16);
	

		maHoKhauJtf = new JTextField();
		maHoKhauJtf.setBounds(710, 40, 411, 30);
		jPanel2.add(maHoKhauJtf);

		tenChuHoJtf = new JTextField();
		tenChuHoJtf.setBounds(710, 90, 411, 30);
		jPanel2.add(tenChuHoJtf);

		jLabel10 = new JLabel();
		jLabel10.setBounds(1130, 40, 30, 30);
		jPanel2.add(jLabel10);

		maKhuVucJtf = new JTextField();
		maKhuVucJtf.setBounds(710, 140, 411, 30);
		jPanel2.add(maKhuVucJtf);

		jLabel12 = new JLabel();
		jLabel12.setBounds(1130, 90, 30, 30);
		jPanel2.add(jLabel12);

		diaChiHienTaiJtf = new JTextField();
		diaChiHienTaiJtf.setBounds(710, 190, 411, 30);
		jPanel2.add(diaChiHienTaiJtf);
		

		jLabel21 = new JLabel();
		jLabel21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabel21.setForeground(new Color(255, 0, 0));
		jLabel21.setText("(*)");
		jLabel21.setBounds(1129, 189, 31, 30);
		jPanel2.add(jLabel21);
		

		jLabel22 = new JLabel();
		jLabel22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabel22.setForeground(new Color(255, 0, 0));
		jLabel22.setText("(*)");
		jLabel22.setBounds(1130, 139, 31, 30);
		jPanel2.add(jLabel22);
		

		jLabel1 = new JLabel();
		jLabel1.setBounds(204, 21, 134, 30);
		jPanel2.add(jLabel1);
		

		jLabel6 = new JLabel();
		jLabel6.setBounds(1216, 36, 31, 30);
		jPanel2.add(jLabel16);

		diaChiChuyenDenJtf = new JTextField();
		diaChiChuyenDenJtf.setBounds(710, 240, 411, 30);
		jPanel2.add(diaChiChuyenDenJtf);

		jLabel17 = new JLabel();
		jLabel17.setBounds(1129, 240, 30, 30);;
		jPanel2.add(jLabel17);


		cancelBtn = new javax.swing.JButton();
		cancelBtn.setBounds(781, 480, 110, 35);
		jPanel2.add(cancelBtn);

		confirmBtn = new javax.swing.JButton();
		confirmBtn.setBounds(941, 480, 110, 35);
		jPanel2.add(confirmBtn);

		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane2.setBounds(710, 290, 411, 175);
		jPanel2.add(jScrollPane2);

		panel3 = new JPanel();
		panel3.setBounds(32, 15, 160, 35);
		panel3.setToolTipText("");
		panel3.setBackground(new Color(240, 248, 255));
		panel3.setLayout(null);
		jPanel1.add(panel3);
		
				jLabel2 = new JLabel();
				jLabel2.setBounds(0, 0, 161, 35);
				panel3.add(jLabel2);
				jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
				jLabel2.setBackground(new Color(255, 255, 255));
				jLabel2.setText("Nhập mã hộ khẩu");
				jLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
				jLabel2.setForeground(new Color(0, 0, 0));
		;

		searchJtf = new javax.swing.JTextField("Search");
		searchJtf.setBounds(215, 15, 403, 35);

		searchJtf.setForeground(Color.GRAY);
		searchJtf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (searchJtf.getText().equals("Search")) {
					searchJtf.setText("");
					searchJtf.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (searchJtf.getText().isEmpty()) {
					searchJtf.setForeground(Color.GRAY);
					searchJtf.setText("Search");
				}
			}
		});
		searchJtf.setSelectionColor(new Color(204, 153, 255));
		searchJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchJtf.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 102, 255), null, null, null),
						new EmptyBorder(0, 10, 0, 0)));
		searchJtf.setColumns(10);
		jPanel1.add(searchJtf);

		jLabel1.setFont(new Font("Tahoma", Font.BOLD, 16)); // NOI18N
		jLabel1.setText("Chọn hộ khẩu");

		tableJpn.setBackground(new Color(255, 255, 255));


		maHoKhauJtf.setBackground(new Color(255, 255, 255));
		maHoKhauJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

		jLabel6.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(255, 0, 0));
		jLabel6.setText("(*)");

		jLabel9.setFont(new Font("Tahoma", Font.BOLD, 15)); // NOI18N
		jLabel9.setText("Tên chủ hộ");

		tenChuHoJtf.setBackground(new Color(255, 255, 255));
		tenChuHoJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

		jLabel10.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
		jLabel10.setForeground(new java.awt.Color(255, 0, 0));
		jLabel10.setText("(*)");

		jLabel11.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15)); // NOI18N
		jLabel11.setText("Mã khu vực");

		maKhuVucJtf.setBackground(new Color(255, 255, 255));
		maKhuVucJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

		jLabel12.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
		jLabel12.setForeground(new java.awt.Color(255, 0, 0));
		jLabel12.setText("(*)");

		diaChiHienTaiJtf.setBackground(new Color(255, 255, 255));
		diaChiHienTaiJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

		jLabel13.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15)); // NOI18N
		jLabel13.setText("Địa chỉ hiên tại");
		
		jLabel14 = new javax.swing.JLabel();
		jLabel14.setText("(*)");
		jLabel14.setForeground(Color.RED);
		jLabel14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabel14.setBounds(1130, 287, 30, 30);
		jPanel2.add(jLabel14);




		jLabel16.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15)); // NOI18N
		jLabel16.setText("Địa chỉ chuyển đến");

		diaChiChuyenDenJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

		jLabel17.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
		jLabel17.setForeground(new java.awt.Color(255, 0, 0));
		jLabel17.setText("(*)");
		
		jLabel18 = new JLabel("Lý do chuyển đi");
		jLabel18.setFont(new Font("Tahoma", Font.BOLD, 15));
		jLabel18.setBounds(557, 287, 145, 30);
		jPanel2.add(jLabel18);
		
		cancelBtn.setText("Hủy");
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBackground(new Color(147, 112, 219));
		cancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelBtnActionPerformed(evt);
			}
		});
		jPanel2.add(cancelBtn);

		confirmBtn.setText("Xác nhận");
		confirmBtn.setBorderPainted(false);
		confirmBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirmBtn.setForeground(new Color(255, 255, 255));
		confirmBtn.setBackground(new Color(147, 112, 219));
		confirmBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				confirmBtnActionPerformed(evt);
			}
		});
		jPanel2.add(confirmBtn);
		jLabel20 = new JLabel("Mã hộ khẩu");
		jLabel20.setFont(new Font("Tahoma", Font.BOLD, 15));
		jLabel20.setBounds(557, 39, 145, 30);
		jPanel2.add(jLabel20);
		
		
	    lyDoJta = new javax.swing.JTextArea();
		jScrollPane2.setViewportView(lyDoJta);
		lyDoJta.setLineWrap(true);
		lyDoJta.setColumns(20);
		lyDoJta.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
		lyDoJta.setRows(5);
				

		this.parentJFrame = parentJFrame;
		this.hoKhauBean = new HoKhauBean();
		this.parentJFrame.setEnabled(false);
		controller = new ChuyenDiNoiKhacController(hoKhauBean, searchJtf, tableJpn);
		controller.setDataJtf(maHoKhauJtf, tenChuHoJtf, maKhuVucJtf, diaChiHienTaiJtf);
		
	

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
	}

//	private void initComponents() {
//
//
//	}// </editor-fold>//GEN-END:initComponents

	private void close() {
		if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm",
				JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			this.parentJFrame.setEnabled(true);
			dispose();
		}
	}

	private void cancelBtnActionPerformed(ActionEvent evt) {// GEN-FIRST:event_cancelBtnActionPerformed
		close();
	}// GEN-LAST:event_cancelBtnActionPerformed

	private void confirmBtnActionPerformed(ActionEvent evt) {// GEN-FIRST:event_confirmBtnActionPerformed
		if (this.diaChiChuyenDenJtf.getText().trim().isEmpty() || this.lyDoJta.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!!", "Warning!",
					JOptionPane.NO_OPTION);
		} else {
			this.controller.getHoKhauService().chuyenDi(this.hoKhauBean.getHoKhauModel().getID(),
					diaChiChuyenDenJtf.getText().trim(), lyDoJta.getText().trim());
			this.parentJFrame.setEnabled(true);
			dispose();
		}
	}// GEN-LAST:event_confirmBtnActionPerformed
}
