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
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;

public class HomePagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private HomeController cotroller;
	
    private JLabel nhanKhauTamTruLb;
    private JLabel nhanKhauTamVangLb;
    private JLabel tongHoKhauLb;
    private JLabel tongNhanKhauLb;
    private JLabel noPaidFees;
	
	public HomePagePanel() {
        init();
        this.cotroller = new HomeController(tongNhanKhauLb, tongHoKhauLb, nhanKhauTamTruLb, nhanKhauTamVangLb, noPaidFees);
        this.cotroller.setData();
		
	}
	
	private void init() {
		setBorder(new LineBorder(new Color(240, 255, 255)));
		setBackground(new Color(249, 250, 254));
		setBounds(0, 0, 806, 593);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(249, 250, 254));
		panel.setBounds(10, 10, 786, 584);
		add(panel);
		panel.setLayout(null);
		
        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_4.setBounds(65, 10, 678, 36);
        add(panel_4);
        panel_4.setBackground(new Color(249, 250, 254));
        panel_4.setLayout(null);

		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(255, 255, 255));
		jPanel1.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		jPanel1.setBounds(40, 90, 320, 240);
		panel.add(jPanel1);
		jPanel1.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(120, 10, 100, 100);
		jPanel1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(HomePagePanel.class.getResource("/icons/network.png")));
		lblNewLabel.setBounds(0, 0, 100, 100);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(55, 120, 210, 94);
		jPanel1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel jLabel2 = new JLabel("Nhân khẩu trên địa bàn");
		jLabel2.setBounds(0, 54, 210, 40);
		panel_3.add(jLabel2);
		jLabel2.setBorder(null);
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setBackground(new Color(255, 255, 255));
		jLabel2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		tongNhanKhauLb = new JLabel("0");
		tongNhanKhauLb.setHorizontalAlignment(SwingConstants.CENTER);
		tongNhanKhauLb.setBounds(0, 0, 210, 40);
		panel_3.add(tongNhanKhauLb);
		tongNhanKhauLb.setBorder(null);
		tongNhanKhauLb.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel jPanel3 = new JPanel();
		jPanel3.setLayout(null);
		jPanel3.setBorder(new EmptyBorder(0, 0, 0, 0));
		jPanel3.setBackground(new Color(255, 255, 255));
		jPanel3.setBounds(420, 90, 320, 240);
		panel.add(jPanel3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(120, 10, 70, 80);
		jPanel3.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(HomePagePanel.class.getResource("/icons/house.png")));
		lblNewLabel_1.setBounds(0, 0, 70, 80);
		panel_1_1.add(lblNewLabel_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(55, 120, 210, 94);
		jPanel3.add(panel_3_1);
		
		tongHoKhauLb = new JLabel("0");
		tongHoKhauLb.setHorizontalAlignment(SwingConstants.CENTER);
		tongHoKhauLb.setBounds(0, 0, 210, 40);
		panel_3_1.add(tongHoKhauLb);
		tongHoKhauLb.setFont(new Font("Tahoma", Font.BOLD, 20));
		tongHoKhauLb.setBorder(null);
		
		JLabel jLabel2_1 = new JLabel("Hộ khẩu có trên địa bàn");
		jLabel2_1.setBounds(0, 54, 210, 40);
		panel_3_1.add(jLabel2_1);
		jLabel2_1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		jLabel2_1.setBorder(null);
		jLabel2_1.setBackground(Color.WHITE);
		
		JPanel jPanel5 = new JPanel();
		jPanel5.setLayout(null);
		jPanel5.setBorder(new EmptyBorder(0, 0, 0, 0));
		jPanel5.setBackground(new Color(204, 204, 255));
		jPanel5.setBounds(420, 355, 320, 100);
		panel.add(jPanel5);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(10, 10, 70, 80);
		jPanel5.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(HomePagePanel.class.getResource("/icons/check-in.png")));
		lblNewLabel_2.setBounds(0, 0, 70, 80);
		panel_1_2.add(lblNewLabel_2);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(88, 10, 222, 80);
		jPanel5.add(panel_2_2);
		
		nhanKhauTamTruLb = new JLabel("Số nhân khẩu tạm trú");
		nhanKhauTamTruLb.setHorizontalAlignment(SwingConstants.LEFT);
		nhanKhauTamTruLb.setFont(new Font("Tahoma", Font.BOLD, 15));
		nhanKhauTamTruLb.setBorder(null);
		nhanKhauTamTruLb.setBackground(Color.WHITE);
		nhanKhauTamTruLb.setBounds(10, 0, 202, 40);
		panel_2_2.add(nhanKhauTamTruLb);
		
		JLabel tongNhanKhauLb_2 = new JLabel("0");
		tongNhanKhauLb_2.setBounds(10, 40, 202, 40);
		panel_2_2.add(tongNhanKhauLb_2);
		tongNhanKhauLb_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		tongNhanKhauLb_2.setBorder(null);
		
		JPanel jPanel7 = new JPanel();
		jPanel7.setLayout(null);
		jPanel7.setBorder(new EmptyBorder(0, 0, 0, 0));
		jPanel7.setBackground(new Color(204, 204, 255));
		jPanel7.setBounds(420, 465, 320, 100);
		panel.add(jPanel7);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(10, 10, 70, 80);
		jPanel7.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(HomePagePanel.class.getResource("/icons/hotel.png")));
		lblNewLabel_3.setBounds(0, 0, 70, 80);
		panel_1_3.add(lblNewLabel_3);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBorder(new LineBorder(new Color(204, 204, 255), 1, true));
		panel_3_3.setBackground(Color.WHITE);
		panel_3_3.setBounds(88, 10, 222, 80);
		jPanel7.add(panel_3_3);
		
		nhanKhauTamVangLb = new JLabel("0");
		nhanKhauTamVangLb.setFont(new Font("Tahoma", Font.BOLD, 20));
		nhanKhauTamVangLb.setBorder(null);
		nhanKhauTamVangLb.setBounds(10, 40, 202, 40);
		panel_3_3.add(nhanKhauTamVangLb);
		
		JLabel jLabel2_3 = new JLabel("Số nhân khẩu tạm vắng");
		jLabel2_3.setBounds(10, 0, 202, 40);
		panel_3_3.add(jLabel2_3);
		jLabel2_3.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		jLabel2_3.setBorder(null);
		jLabel2_3.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_4 = new JLabel("Welcome !!!");
		lblNewLabel_4.setBounds(40, 10, 678, 60);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		
		JPanel jPanel1_1 = new JPanel();
		jPanel1_1.setLayout(null);
		jPanel1_1.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		jPanel1_1.setBackground(Color.WHITE);
		jPanel1_1.setBounds(40, 355, 320, 210);
		panel.add(jPanel1_1);
		
		noPaidFees = new JLabel("0");
		noPaidFees.setBounds(55, 50, 210, 40);
		jPanel1_1.add(noPaidFees);
		noPaidFees.setHorizontalAlignment(SwingConstants.CENTER);
		noPaidFees.setFont(new Font("Tahoma", Font.BOLD, 20));
		noPaidFees.setBorder(null);
		
		JLabel jLabel2_2 = new JLabel("Hộ chưa nộp phí đợt này");
		jLabel2_2.setBounds(55, 100, 210, 69);
		jPanel1_1.add(jLabel2_2);
		jLabel2_2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		jLabel2_2.setBorder(null);
		jLabel2_2.setBackground(Color.WHITE);
	}
}