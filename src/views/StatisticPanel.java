package views;

import controllers.StatisticPanelController;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StatisticPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	private javax.swing.ButtonGroup GenderChoose;
	private javax.swing.JComboBox<String> GenderJcb;
	private javax.swing.JComboBox<String> StatusJcb;
	private javax.swing.JTextField denNamJtf;
	private javax.swing.JTextField denTuoiJtf;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel9;
	private javax.swing.ButtonGroup statusChoose;
	private javax.swing.JTextField tuNamJtf;
	private javax.swing.JTextField tuTuoiJtf;

	private JFrame parentFrame;
	private StatisticPanelController controller;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel tableJpn;
	private JPanel panel_3;

	public StatisticPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		init();
		this.controller = new StatisticPanelController(GenderJcb, StatusJcb, tuTuoiJtf, denTuoiJtf, tuNamJtf, denNamJtf, tableJpn);
		this.controller.setDataTable();
	}

	private void init() {
		setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 806, 593);
		setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(153, 102, 255), 2));
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(10, 10, 786, 43);
		panel.setLayout(null);
		add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 255));
		panel_1.setBorder(new LineBorder(new Color(147, 112, 219), 2, true));
		panel_1.setBounds(10, 63, 786, 146);
		panel_1.setLayout(null);
		add(panel_1);
		
		jLabel7 = new javax.swing.JLabel("Giới tính");
		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setBounds(10, 20, 80, 40);
		panel_1.add(jLabel7);

		GenderJcb = new javax.swing.JComboBox<>();
		GenderJcb.setBounds(90, 20, 130, 40);
		GenderJcb.setFont(new java.awt.Font("Tahoma", 0, 14));
		GenderJcb.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Toàn bộ", "Nam", "Nữ" }
			)
		);
		panel_1.add(GenderJcb);

		jLabel1 = new javax.swing.JLabel("Tình trạng:");
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setBounds(300, 20, 100, 40);
		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
		panel_1.add(jLabel1);

		StatusJcb = new javax.swing.JComboBox<>();
		StatusJcb.setBounds(400, 20, 140, 40);
		StatusJcb.setFont(new java.awt.Font("Tahoma", 0, 14));
		StatusJcb.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Toàn bộ", "Thường trú", "Tạm trú", "Tạm vắng" }
			)
		);
		panel_1.add(StatusJcb);

		jButton1 = new javax.swing.JButton("Show");
		jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));
		jButton1.setBounds(646, 20, 130, 40);
		jButton1.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		jButton1.setForeground(new Color(255, 255, 255));
		jButton1.setBackground(new Color(102, 102, 255));
		jButton1.setBorderPainted(false);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		panel_1.add(jButton1);

		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(153, 102, 255), 2));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 73, 766, 63);
		panel_3.setLayout(null);
		panel_1.add(panel_3);
		
		jLabel2 = new JLabel("Độ tuổi");
		jLabel2.setFont(new Font("Tahoma", Font.BOLD, 14));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setBounds(10, 10, 60, 43);
		panel_3.add(jLabel2);

		jLabel3 = new JLabel("Từ");
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setBounds(72, 10, 60, 43);
		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
		panel_3.add(jLabel3);

		tuTuoiJtf = new JTextField();
		tuTuoiJtf.setFont(new java.awt.Font("Tahoma", 0, 14));
		tuTuoiJtf.setBounds(132, 10, 70, 43);
		panel_3.add(tuTuoiJtf);

		jLabel4 = new javax.swing.JLabel("đến");
		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setBounds(203, 10, 60, 43);
		panel_3.add(jLabel4);

		denTuoiJtf = new JTextField();
		denTuoiJtf.setFont(new java.awt.Font("Tahoma", 0, 14));
		denTuoiJtf.setBounds(263, 10, 70, 43);
		panel_3.add(denTuoiJtf);

		jLabel5 = new JLabel("Tuổi:");
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5.setBounds(333, 11, 60, 43);
		jLabel5.setFont(new Font("Tahoma", Font.ITALIC, 14)); // NOI18N
		panel_3.add(jLabel5);

		jLabel9 = new JLabel("Năm:");
		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel9.setBounds(436, 10, 60, 43);
		panel_3.add(jLabel9);

		
		jLabel10 = new JLabel("Từ");
		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel10.setBounds(496, 10, 60, 43);
		panel_3.add(jLabel10);

		tuNamJtf = new JTextField();
		tuNamJtf.setFont(new java.awt.Font("Tahoma", 0, 14));
		tuNamJtf.setBounds(556, 10, 70, 43);
		panel_3.add(tuNamJtf);

		jLabel11 = new JLabel("đến");
		jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel11.setBounds(626, 10, 60, 43);
		panel_3.add(jLabel11);
		
		denNamJtf = new JTextField();
		denNamJtf.setFont(new java.awt.Font("Tahoma", 0, 14));
		denNamJtf.setBounds(686, 10, 70, 43);
		panel_3.add(denNamJtf);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 255), null, null, null));
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(10, 219, 786, 364);
		add(panel_2);

		tableJpn = new JPanel();
		tableJpn.setLayout(null);
		tableJpn.setBackground(Color.WHITE);
		tableJpn.setBounds(10, 10, 766, 344);
		panel_2.add(tableJpn);
		

		GenderChoose = new javax.swing.ButtonGroup();
		statusChoose = new javax.swing.ButtonGroup();
		jLabel6 = new javax.swing.JLabel();
		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
		jLabel6.setBounds(729, 105, 0, 30);
		add(jLabel6);

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.controller.setData();
	}

}
