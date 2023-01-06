package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.AddressController;
import models.AddressModel;
import utility.ComboBoxSuggestion;
import utility.SuggestionUtility;
import views.PeopleManagerFrame.AddNewPeopleFrame;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class AddressSuggestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame parentFrame;
	private JPanel contentPane;
	private JTextField houseJtf;
//	private JTextField wardJtf;
	private JComboBox wardJtf;
	private JTextField districtJtf;
	private JTextField provinceJtf;

	private AddressModel addrModel;
	private AddressController addrController;

	public AddressSuggestion(JFrame parentFrame, AddressModel addrModel) {
		this.addrController = new AddressController();
		init();
		this.parentFrame = parentFrame;
		this.addrModel = addrModel;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		parentFrame.setEnabled(false);
	}

	private void init() {
		setResizable(false);
		setTitle("Chọn địa điểm");
		setBounds(350, 200, 700, 450);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 686, 413);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 20, 666, 60);
		panel.add(panel_1);
		panel_1.setLayout(null);

		houseJtf = new JTextField();
		houseJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		houseJtf.setBounds(157, 10, 499, 41);
		panel_1.add(houseJtf);
		houseJtf.setColumns(10);

		JLabel lblNewLabel = new JLabel("Số nhà, đường");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 137, 41);
		panel_1.add(lblNewLabel);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(240, 248, 255));
		panel_1_1.setBounds(10, 100, 666, 60);
		panel.add(panel_1_1);

//		wardJtf = new SuggestionUtility(false) {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public List<String> getSuggestions(String textContent) {
//				List<String> list = addrController.searchByWard(textContent);
//				return list;
//			}
//		};
//
//		wardJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		wardJtf.setBounds(157, 10, 499, 41);
		wardJtf = new ComboBoxSuggestion<String>();
		wardJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		wardJtf.setBounds(157, 10, 499, 41);
		wardJtf.setModel(new DefaultComboBoxModel<String>(addrController.getWards().toArray(new String[0])));
		panel_1_1.add(wardJtf);

		JLabel lblX = new JLabel("Xã, phường");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblX.setBounds(10, 10, 137, 41);
		panel_1_1.add(lblX);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(240, 248, 255));
		panel_1_2.setBounds(10, 180, 666, 60);
		panel.add(panel_1_2);

		districtJtf = new SuggestionUtility(false) {
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				List<String> list = addrController.searchByDistrict(textContent);
				return list;
			}
		};
		districtJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		districtJtf.setColumns(10);
		districtJtf.setBounds(157, 10, 499, 41);
		panel_1_2.add(districtJtf);

		JLabel lblHuynThTrn = new JLabel("Huyện, Thị trấn");
		lblHuynThTrn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHuynThTrn.setBounds(10, 10, 137, 41);
		panel_1_2.add(lblHuynThTrn);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(new Color(240, 248, 255));
		panel_1_3.setBounds(10, 260, 666, 60);
		panel.add(panel_1_3);

		provinceJtf = new SuggestionUtility(false) {
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				List<String> list = addrController.searchByProvince(textContent);
				return list;
			}
		};
		provinceJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		provinceJtf.setColumns(10);
		provinceJtf.setBounds(157, 10, 499, 41);
		panel_1_3.add(provinceJtf);

		JLabel lblTnhThnhPh = new JLabel("Tỉnh, thành phố");
		lblTnhThnhPh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnhThnhPh.setBounds(10, 10, 137, 41);
		panel_1_3.add(lblTnhThnhPh);

		JButton cancelBtn = new JButton("Hủy");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancelBtn.setBackground(new Color(147, 112, 219));
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBounds(400, 340, 114, 44);
		panel.add(cancelBtn);

		JButton acceptBtn = new JButton("Đồng ý");
		acceptBtn.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					acceptAction();
				}
			}
		});
		acceptBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acceptAction();
			}
		});
		acceptBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		acceptBtn.setBackground(new Color(147, 112, 219));
		acceptBtn.setForeground(new Color(255, 255, 255));
		acceptBtn.setBorderPainted(false);
		acceptBtn.setBounds(550, 340, 114, 44);
		panel.add(acceptBtn);
	}

	private void close() {
		if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm",
				JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			parentFrame.setEnabled(true);
			dispose();
		}
	}

	private void cancelAction() {
		houseJtf.setText("");
		houseJtf.requestFocus();
		((JTextField)wardJtf.getEditor()).setText("");
		districtJtf.setText("");
		provinceJtf.setText("");
	}

	private void acceptAction() {
		if (((JTextField)wardJtf.getEditor()).getText().isEmpty() || districtJtf.getText().isEmpty() || provinceJtf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ địa chỉ");
		} else {
			addrModel.setHouse_no(houseJtf.getText());
			addrModel.setWard(((JTextField)wardJtf.getEditor()).getText());
			addrModel.setDistrict(districtJtf.getText());
			addrModel.setProvince(provinceJtf.getText());
			AddNewPeopleFrame parent = (AddNewPeopleFrame) parentFrame;
			parent.setNguyenQuanTxb(addrModel.getAddress());
			close();
		}
	}

}
