package views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controllers.HomeController;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class HomePagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HomeController cotroller;
	
    private javax.swing.JLabel nhanKhauTamTruLb;
    private javax.swing.JLabel nhanKhauTamVangLb;
    private javax.swing.JLabel tongHoKhauLb;
    private javax.swing.JLabel tongNhanKhauLb;
	
	/**
	 * Create the panel.
	 */
	public HomePagePanel() {
        init();
        this.cotroller = new HomeController(tongNhanKhauLb, tongHoKhauLb, nhanKhauTamTruLb, nhanKhauTamVangLb);
        this.cotroller.setData();

	}
	
	private void init() {
		setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 806, 593);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(204, 204, 255), 2, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 43, 767, 550);
		add(panel);
		panel.setLayout(null);
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(204, 204, 255));
		jPanel1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 204, 255), null, null, null));
		jPanel1.setBounds(60, 20, 678, 100);
		panel.add(jPanel1);
		jPanel1.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 204, 255), null, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 10, 70, 80);
		jPanel1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(HomePagePanel.class.getResource("/Icons/network.png")));
		lblNewLabel.setBounds(0, 0, 70, 80);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(88, 10, 580, 40);
		jPanel1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel jLabel2 = new JLabel("Nhân khẩu có trên địa bàn");
		jLabel2.setBorder(null);
		jLabel2.setBounds(10, 0, 570, 40);
		jLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(jLabel2);
		jLabel2.setBackground(new Color(255, 255, 255));
		jLabel2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(88, 50, 580, 40);
		jPanel1.add(panel_3);
		panel_3.setLayout(null);
		
		tongNhanKhauLb = new JLabel("0");
		tongNhanKhauLb.setBorder(null);
		tongNhanKhauLb.setFont(new Font("Tahoma", Font.BOLD, 20));
		tongNhanKhauLb.setBounds(10, 0, 570, 40);
		panel_3.add(tongNhanKhauLb);
		
		JPanel jPanel3 = new JPanel();
		jPanel3.setLayout(null);
		jPanel3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 204, 255), null, null, null));
		jPanel3.setBackground(new Color(204, 204, 255));
		jPanel3.setBounds(60, 150, 678, 100);
		panel.add(jPanel3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 204, 255), null, null, null));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(10, 10, 70, 80);
		jPanel3.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(HomePagePanel.class.getResource("/Icons/house.png")));
		lblNewLabel_1.setBounds(0, 0, 70, 80);
		panel_1_1.add(lblNewLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(88, 10, 580, 40);
		jPanel3.add(panel_2_1);
		
		JLabel jLabel2_1 = new JLabel("Hộ khẩu có trên địa bàn");
		jLabel2_1.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		jLabel2_1.setBorder(null);
		jLabel2_1.setBackground(Color.WHITE);
		jLabel2_1.setBounds(10, 0, 570, 40);
		panel_2_1.add(jLabel2_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(88, 50, 580, 40);
		jPanel3.add(panel_3_1);
		
		tongHoKhauLb = new JLabel("0");
		tongHoKhauLb.setFont(new Font("Tahoma", Font.BOLD, 20));
		tongHoKhauLb.setBorder(null);
		tongHoKhauLb.setBounds(10, 0, 570, 40);
		panel_3_1.add(tongHoKhauLb);
		
		JPanel jPanel5 = new JPanel();
		jPanel5.setLayout(null);
		jPanel5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 204, 255), null, null, null));
		jPanel5.setBackground(new Color(204, 204, 255));
		jPanel5.setBounds(60, 280, 678, 100);
		panel.add(jPanel5);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 204, 255), null, null, null));
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(10, 10, 70, 80);
		jPanel5.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(HomePagePanel.class.getResource("/Icons/check-in.png")));
		lblNewLabel_2.setBounds(0, 0, 70, 80);
		panel_1_2.add(lblNewLabel_2);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(88, 10, 580, 40);
		jPanel5.add(panel_2_2);
		
		nhanKhauTamTruLb = new JLabel("Số nhân khẩu tạm trú");
		nhanKhauTamTruLb.setHorizontalAlignment(SwingConstants.LEFT);
		nhanKhauTamTruLb.setFont(new Font("Tahoma", Font.BOLD, 15));
		nhanKhauTamTruLb.setBorder(null);
		nhanKhauTamTruLb.setBackground(Color.WHITE);
		nhanKhauTamTruLb.setBounds(10, 0, 570, 40);
		panel_2_2.add(nhanKhauTamTruLb);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_3_2.setBackground(Color.WHITE);
		panel_3_2.setBounds(88, 50, 580, 40);
		jPanel5.add(panel_3_2);
		
		JLabel tongNhanKhauLb_2 = new JLabel("0");
		tongNhanKhauLb_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		tongNhanKhauLb_2.setBorder(null);
		tongNhanKhauLb_2.setBounds(10, 0, 570, 40);
		panel_3_2.add(tongNhanKhauLb_2);
		
		JPanel jPanel7 = new JPanel();
		jPanel7.setLayout(null);
		jPanel7.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 204, 255), null, null, null));
		jPanel7.setBackground(new Color(204, 204, 255));
		jPanel7.setBounds(60, 410, 678, 100);
		panel.add(jPanel7);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 204, 255), null, null, null));
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(10, 10, 70, 80);
		jPanel7.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(HomePagePanel.class.getResource("/Icons/hotel.png")));
		lblNewLabel_3.setBounds(0, 0, 70, 80);
		panel_1_3.add(lblNewLabel_3);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(88, 10, 580, 40);
		jPanel7.add(panel_2_3);
		
		JLabel jLabel2_3 = new JLabel("Số nhân khẩu tạm vắng");
		jLabel2_3.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		jLabel2_3.setBorder(null);
		jLabel2_3.setBackground(Color.WHITE);
		jLabel2_3.setBounds(10, 0, 570, 40);
		panel_2_3.add(jLabel2_3);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_3_3.setBackground(Color.WHITE);
		panel_3_3.setBounds(88, 50, 580, 40);
		jPanel7.add(panel_3_3);
		
		nhanKhauTamVangLb = new JLabel("0");
		nhanKhauTamVangLb.setFont(new Font("Tahoma", Font.BOLD, 20));
		nhanKhauTamVangLb.setBorder(null);
		nhanKhauTamVangLb.setBounds(10, 0, 570, 40);
		panel_3_3.add(nhanKhauTamVangLb);
	}
}
