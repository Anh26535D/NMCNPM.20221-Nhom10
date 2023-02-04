package views.FeesManagerFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.PhiBatBuocBean;
import controllers.FeesManagerController.PayFeeController;
import controllers.FeesManagerController.StatisticFeesController;
import models.PayFeeModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class PayFeeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private StatisticFeesController parentController;
	private JFrame parentFrame;
	private PhiBatBuocBean selectedFee;
	private PayFeeController controller;
	private PayFeeModel payFeeModel;
	
	private JTextField soTienJtf;
	private JTextField tenJtf;
	private JButton CancelBtn;
	private JButton CreateBtn;

	public PayFeeFrame(StatisticFeesController parentController, JFrame parentJFrame, PhiBatBuocBean selectedFee) {
		init();
		this.parentController = parentController;
		this.parentFrame = parentJFrame;
		this.parentFrame.setEnabled(false);
		this.selectedFee = selectedFee;
		controller = new PayFeeController();
		this.payFeeModel = new PayFeeModel();

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
	}

	private void init() {
		setTitle("Nộp phí");
		setBounds(100, 100, 650, 310);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBounds(5, 5, 1100, 1100);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(240, 248, 255));
		jPanel1.setBounds(10, 10, 616, 253);
		jPanel1.setLayout(null);
		contentPane.add(jPanel1);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 10, 596, 190);
		jPanel1.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Người nộp");
		lblNewLabel.setBounds(10, 10, 576, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("Số tiền");
		lblNewLabel_1.setBounds(10, 108, 576, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		soTienJtf = new JTextField();
		soTienJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		soTienJtf.setBounds(10, 138, 576, 40);
		panel.add(soTienJtf);
		soTienJtf.setColumns(10);

		tenJtf = new JTextField();
		tenJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenJtf.setBounds(10, 40, 576, 40);
		panel.add(tenJtf);
		tenJtf.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(10, 200, 596, 43);
		jPanel1.add(panel_3);

		CancelBtn = new JButton("Cancel");
		CancelBtn.setBounds(330, 10, 100, 25);
		CancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CancelBtnActionPerformed(evt);
			}
		});
		panel_3.setLayout(null);
		CancelBtn.setBackground(new Color(147, 112, 219));
		CancelBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		CancelBtn.setForeground(new Color(255, 255, 255));
		CancelBtn.setBorderPainted(false);
		panel_3.add(CancelBtn);

		CreateBtn = new JButton("Pay");
		CreateBtn.setBounds(486, 10, 100, 25);
		CreateBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CreateBtnActionPerformed(evt);
			}
		});
		CreateBtn.setBackground(new Color(147, 112, 219));
		CreateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		CreateBtn.setForeground(new Color(255, 255, 255));
		CreateBtn.setBorderPainted(false);
		panel_3.add(CreateBtn);
	}

	private void CancelBtnActionPerformed(ActionEvent evt) {
		tenJtf.setText("");
		soTienJtf.setText("");
	}

	private boolean validateForm() {
		String tenNguoiNop = tenJtf.getText();
		String soTien = soTienJtf.getText();
		if (tenNguoiNop.trim().isEmpty() || soTien.trim().isEmpty()) {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		try {
			long d = Long.parseLong(soTien);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, "Số tiền không thể chứa các ký tự", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (validateForm()) {
			this.payFeeModel.setIdNhanKhau(Integer.parseInt(tenJtf.getText()));;
			this.payFeeModel.setSo_tien(Integer.parseInt(soTienJtf.getText()));
			try {
				if (this.controller.payFee(this.payFeeModel, this.selectedFee.getFeesModel().getID())) {
					JOptionPane.showMessageDialog(null, "Thêm thành công!!");
					close();
					parentController.refreshData();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	void close() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!",
				JOptionPane.YES_NO_OPTION) == 0) {
			this.parentFrame.setEnabled(true);
			dispose();
		}
	}
	
	
}
