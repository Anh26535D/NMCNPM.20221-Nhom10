package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import bean.DanhMucBean;
import controllers.DashboardController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DashBoardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
    private JPanel HoKhauBtn;
    private JPanel Home;
    private JPanel NhanKhauBtn;
    private JPanel ThongKeBtn;
    private JLabel jlbTrangChu;
    private JLabel jlbHoKhau;
    private JLabel jlbNhanKhau;
    private JLabel jlbThongKe;
    private JPanel jpnBean;
    private JPanel jpnContainer;
    private JPanel jpnMenu;
    
    private JButton LogoutBtn;
    
    private DashboardController controller;

	public DashBoardFrame() {
		init();
		
        List<DanhMucBean> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMucBean("TrangChu", Home, jlbTrangChu));
        listDanhMuc.add(new DanhMucBean("NhanKhau", NhanKhauBtn, jlbNhanKhau));
        listDanhMuc.add(new DanhMucBean("HoKhau", HoKhauBtn, jlbHoKhau));
        listDanhMuc.add(new DanhMucBean("ThongKe", ThongKeBtn, jlbThongKe));
        
        this.controller = new DashboardController(jpnBean, this);
        controller.setView(Home, "TrangChu");
        controller.setEvent(listDanhMuc);
	}
	
	private void init() {
		this.setResizable(false);
		this.setTitle("Quản lý nhân khẩu");
		this.setBounds(350, 200, 1000, 650);
		this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                    dispose();
                }
            }
        });
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		
		jpnContainer = new JPanel();
		jpnContainer.setBackground(new Color(204, 204, 255));
		jpnContainer.setBounds(0, 0, 986, 613);
		jpnContainer.setLayout(null);
		contentPane.add(jpnContainer);
		
		jpnMenu = new JPanel();
		jpnMenu.setBorder(new LineBorder(new Color(204, 153, 255), 3, true));
		jpnMenu.setBackground(new Color(240, 255, 255));
		jpnMenu.setBounds(20, 10, 130, 593);
		jpnMenu.setLayout(null);
		jpnContainer.add(jpnMenu);
		
		Home = new JPanel();
		Home.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 204, 255), null, new Color(204, 255, 255), null));
		Home.setBackground(new Color(220, 152, 255));
		Home.setBounds(10, 10, 110, 54);
		Home.setLayout(null);
		jpnMenu.add(Home);
		
		jlbTrangChu = new JLabel("Trang chủ");
		jlbTrangChu.setForeground(new Color(255, 255, 255));
		jlbTrangChu.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlbTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		jlbTrangChu.setBounds(0, 0, 110, 54);
		Home.add(jlbTrangChu);
		
		NhanKhauBtn = new JPanel();
		NhanKhauBtn.setBorder(new LineBorder(new Color(255, 204, 255), 1, true));
		NhanKhauBtn.setBackground(new Color(102, 153, 255));
		NhanKhauBtn.setBounds(10, 108, 110, 54);
		NhanKhauBtn.setLayout(null);
		jpnMenu.add(NhanKhauBtn);
		
		jlbNhanKhau = new JLabel("Nhân khẩu");
		jlbNhanKhau.setToolTipText("Nhân khẩu");
		jlbNhanKhau.setBackground(new Color(204, 204, 255));
		jlbNhanKhau.setBorder(null);
		jlbNhanKhau.setForeground(new Color(255, 255, 255));
		jlbNhanKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlbNhanKhau.setHorizontalAlignment(SwingConstants.CENTER);
		jlbNhanKhau.setBounds(0, 0, 110, 54);
		NhanKhauBtn.add(jlbNhanKhau);
		
		HoKhauBtn = new JPanel();
		HoKhauBtn.setBorder(new LineBorder(new Color(255, 204, 255), 1, true));
		HoKhauBtn.setBackground(new Color(102, 153, 255));
		HoKhauBtn.setForeground(new Color(204, 204, 255));
		HoKhauBtn.setBounds(10, 172, 110, 54);
		HoKhauBtn.setLayout(null);
		jpnMenu.add(HoKhauBtn);
		
		jlbHoKhau = new JLabel("Hộ khẩu");
		jlbHoKhau.setBackground(new Color(102, 153, 255));
		jlbHoKhau.setBorder(null);
		jlbHoKhau.setForeground(new Color(255, 255, 255));
		jlbHoKhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlbHoKhau.setBounds(0, 0, 110, 54);
		jlbHoKhau.setHorizontalAlignment(SwingConstants.CENTER);
		jlbHoKhau.setToolTipText("Hộ khẩu");
		HoKhauBtn.add(jlbHoKhau);
		
		ThongKeBtn = new JPanel();
		ThongKeBtn.setBackground(new Color(102, 153, 255));
		ThongKeBtn.setBorder(new LineBorder(new Color(255, 204, 255), 1, true));
		ThongKeBtn.setBounds(10, 236, 110, 54);
		ThongKeBtn.setLayout(null);
		jpnMenu.add(ThongKeBtn);
		
		jlbThongKe = new JLabel("Thống kê");
		jlbThongKe.setBackground(new Color(102, 102, 255));
		jlbThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		jlbThongKe.setBounds(0, 0, 110, 54);
		jlbThongKe.setForeground(new Color(255, 255, 255));
		jlbThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		jlbThongKe.setToolTipText("Thống kê");
		ThongKeBtn.add(jlbThongKe);
		
        LogoutBtn = new JButton("Thoát");
        LogoutBtn.setFocusPainted(false);
        LogoutBtn.setBorderPainted(false);
        LogoutBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to log out?", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                    dispose();
                    LoginFrame loginFrame = new LoginFrame();
                    loginFrame.setVisible(true);
                }
			}
		});
        LogoutBtn.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				LogoutBtn.setBackground(new Color(23, 69, 255));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				LogoutBtn.setBackground(new Color(102, 153, 255));
				
			}
		});
        
        LogoutBtn.setForeground(Color.WHITE);
        LogoutBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        LogoutBtn.setBorder(new LineBorder(new Color(255, 204, 255), 1, true));
        LogoutBtn.setBackground(new Color(102, 153, 255));
        LogoutBtn.setBounds(10, 529, 110, 54);
        jpnMenu.add(LogoutBtn);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 255));
		panel.setBorder(new LineBorder(new Color(255, 153, 255), 2, true));
		panel.setBounds(10, 70, 110, 10);
		jpnMenu.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 153, 255), 2, true));
		panel_1.setBackground(new Color(204, 153, 255));
		panel_1.setBounds(10, 88, 110, 10);
		jpnMenu.add(panel_1);
		
		jpnBean = new JPanel();
		jpnBean.setBackground(new Color(255, 255, 255));
		jpnBean.setBounds(170, 10, 806, 593);
		jpnContainer.add(jpnBean);
	}
}
