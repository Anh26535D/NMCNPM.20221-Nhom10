package views.HoKhauManagerFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import bean.HoKhauBean;
import bean.MemOfFamily;
import bean.NhanKhauBean;
import controllers.HoKhauManagerController.ThemMoiController;
import models.ThanhVienCuaHoModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class NewHouseholdFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField maHoKhauJtf;
    private JTextField maKhuVucJtf;
    private JPanel memTableJpn;
    private JTextField ngaySinhChuHoJtf;
    private JButton saveBtn;
    private JButton selectBtn;
    private JTextField soCMTChuHo;
    private JTextField tenChuHoJtf;
    private JButton cancelBtn;
    private JTextField diaChiJtf;
    private JButton editBtn;
	
	private JFrame parentJFrame;
    private NhanKhauBean chuHo = new NhanKhauBean();
    private final List<MemOfFamily> list = new ArrayList<>();
    private final ThemMoiController controller = new ThemMoiController();
    private final HoKhauBean hoKhauBean = new HoKhauBean();


	/**
	 * Create the frame.
	 */
	public NewHouseholdFrame(JFrame parentJFrame) {
		init();
		this.parentJFrame = parentJFrame;
		parentJFrame.setEnabled(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		        @Override
		        public void windowClosing(WindowEvent e) {
		            close();
		        }
		        
		});
		setDataThanhVien();
	}
	
	private void init() {
		this.setResizable(false);
		this.setTitle("Hộ khẩu mới");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 200, 700, 800);
		this.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setBackground(new Color(230, 230, 250));
		jPanel2.setBounds(0, 0, 676, 753);
		contentPane.add(jPanel2);
		jPanel2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 23, 656, 53);
		jPanel2.add(panel);
		panel.setLayout(null);
		
		JLabel jLabel1 = new JLabel("Mã hộ khẩu");
		jLabel1.setBounds(10, 10, 174, 33);
		panel.add(jLabel1);
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		maHoKhauJtf = new JTextField();
		maHoKhauJtf.setFont(new Font("Tahoma", Font.BOLD, 15));
        maHoKhauJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maHoKhauJtfActionPerformed(evt);
            }
        });
		maHoKhauJtf.setBounds(190, 10, 454, 33);
		panel.add(maHoKhauJtf);
		maHoKhauJtf.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 86, 656, 53);
		jPanel2.add(panel_1);
		
		JLabel jLabel3 = new JLabel("Mã khu vực");
		jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel3.setBounds(10, 10, 174, 33);
		panel_1.add(jLabel3);
		
		maKhuVucJtf = new JTextField();
		maKhuVucJtf.setFont(new Font("Tahoma", Font.BOLD, 15));
        maKhuVucJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKhuVucJtfActionPerformed(evt);
            }
        });
		maKhuVucJtf.setColumns(10);
		maKhuVucJtf.setBounds(190, 10, 454, 33);
		panel_1.add(maKhuVucJtf);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(10, 149, 656, 53);
		jPanel2.add(panel_2);
		
		JLabel jLabel5 = new JLabel("Địa chỉ");
		jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel5.setBounds(10, 10, 174, 33);
		panel_2.add(jLabel5);
		
		diaChiJtf = new JTextField();
		diaChiJtf.setFont(new Font("Tahoma", Font.BOLD, 15));
        diaChiJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaChiJtfActionPerformed(evt);
            }
        });
		diaChiJtf.setColumns(10);
		diaChiJtf.setBounds(190, 10, 454, 33);
		panel_2.add(diaChiJtf);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(10, 212, 656, 53);
		jPanel2.add(panel_3);
		
		JLabel jLabel1_3 = new JLabel("Chủ hộ");
		jLabel1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel1_3.setBounds(10, 10, 79, 33);
		panel_3.add(jLabel1_3);
		
		tenChuHoJtf = new JTextField();
		tenChuHoJtf.setFont(new Font("Tahoma", Font.BOLD, 15));
        tenChuHoJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenChuHoJtfActionPerformed(evt);
            }
        });
		tenChuHoJtf.setColumns(10);
		tenChuHoJtf.setBounds(190, 10, 454, 33);
		panel_3.add(tenChuHoJtf);
		
		selectBtn = new JButton("Chọn");
        selectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBtnActionPerformed(evt);
            }
        });
		selectBtn.setBorderPainted(false);
		selectBtn.setBounds(100, 10, 83, 33);
		selectBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		selectBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		selectBtn.setForeground(new Color(255, 255, 255));
		selectBtn.setBackground(new Color(147, 112, 219));
		panel_3.add(selectBtn);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(240, 248, 255));
		panel_4.setBounds(10, 275, 656, 53);
		jPanel2.add(panel_4);
		
		JLabel jLabel7 = new JLabel("Ngày sinh chủ hộ");
		jLabel7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel7.setBounds(10, 10, 174, 33);
		panel_4.add(jLabel7);
		
		ngaySinhChuHoJtf = new JTextField();
		ngaySinhChuHoJtf.setFont(new Font("Tahoma", Font.BOLD, 15));
        ngaySinhChuHoJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngaySinhChuHoJtfActionPerformed(evt);
            }
        });

		ngaySinhChuHoJtf.setHorizontalAlignment(SwingConstants.LEFT);
		ngaySinhChuHoJtf.setColumns(10);
		ngaySinhChuHoJtf.setBounds(190, 10, 454, 33);
		panel_4.add(ngaySinhChuHoJtf);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(240, 248, 255));
		panel_5.setBounds(10, 338, 656, 53);
		jPanel2.add(panel_5);
		
		JLabel jLabel1_5 = new JLabel("Số CMT chủ hộ");
		jLabel1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel1_5.setBounds(10, 10, 174, 33);
		panel_5.add(jLabel1_5);
		
		soCMTChuHo = new JTextField();
		soCMTChuHo.setFont(new Font("Tahoma", Font.BOLD, 15));
        soCMTChuHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soCMTChuHoActionPerformed(evt);
            }
        });
		soCMTChuHo.setColumns(10);
		soCMTChuHo.setBounds(190, 10, 454, 33);
		panel_5.add(soCMTChuHo);
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(240, 248, 255));
		jPanel1.setFont(new Font("Tahoma", Font.BOLD, 20));
		jPanel1.setBorder(new TitledBorder(null, "Th\u00E0nh vi\u00EAn c\u1EE7a h\u1ED9", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18)));
		jPanel1.setBounds(10, 401, 656, 295);
		jPanel2.add(jPanel1);
		jPanel1.setLayout(null);
		
		editBtn = new JButton("Sửa");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
		editBtn.setForeground(new Color(255, 255, 255));
		editBtn.setBackground(new Color(147, 112, 219));
		editBtn.setBorderPainted(false);
		editBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		editBtn.setBounds(10, 36, 94, 33);
		jPanel1.add(editBtn);
		
		memTableJpn = new JPanel();
		memTableJpn.setBackground(new Color(255, 255, 255));
		memTableJpn.setBounds(10, 79, 636, 206);
		jPanel1.add(memTableJpn);
		
		cancelBtn = new JButton("Hủy");
		cancelBtn.setBackground(new Color(147, 112, 219));
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBounds(464, 706, 90, 37);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
		jPanel2.add(cancelBtn);
		
		saveBtn = new JButton("Lưu");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
		saveBtn.setBackground(new Color(147, 112, 219));
		saveBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		saveBtn.setForeground(new Color(255, 255, 255));
		saveBtn.setBorderPainted(false);
		saveBtn.setBounds(576, 706, 90, 37);
		jPanel2.add(saveBtn);
	}
	
    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }
	
    public void setDataChuHo() {
        this.tenChuHoJtf.setText(this.chuHo.getNhanKhauModel().getHoTen());
        this.ngaySinhChuHoJtf.setText(this.chuHo.getNhanKhauModel().getNamSinh().toString());
        this.soCMTChuHo.setText(this.chuHo.getChungMinhThuModel().getSoCMT());
    }

    public void setDataThanhVien() {
        this.controller.setData(this.list, this.memTableJpn);
    }
    
    private void maHoKhauJtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maHoKhauJtfActionPerformed
    }//GEN-LAST:event_maHoKhauJtfActionPerformed

    private void maKhuVucJtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maKhuVucJtfActionPerformed
    }//GEN-LAST:event_maKhuVucJtfActionPerformed

    private void diaChiJtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaChiJtfActionPerformed
    }//GEN-LAST:event_diaChiJtfActionPerformed

    private void selectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBtnActionPerformed
        ChoosePeople choosePeople = new ChoosePeople(this.chuHo, this);
        choosePeople.setLocationRelativeTo(null);
        choosePeople.setResizable(false);
        choosePeople.setVisible(true);
    }//GEN-LAST:event_selectBtnActionPerformed

    private void tenChuHoJtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenChuHoJtfActionPerformed
    }//GEN-LAST:event_tenChuHoJtfActionPerformed

    private void ngaySinhChuHoJtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngaySinhChuHoJtfActionPerformed
    }//GEN-LAST:event_ngaySinhChuHoJtfActionPerformed

    private void soCMTChuHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soCMTChuHoActionPerformed
    }//GEN-LAST:event_soCMTChuHoActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        close();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        ChangeListPeopleJframe changeListPeopleJframe = new ChangeListPeopleJframe(list, this);
        changeListPeopleJframe.setLocationRelativeTo(null);
        changeListPeopleJframe.setResizable(false);
        changeListPeopleJframe.setVisible(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (this.maHoKhauJtf.getText().trim().isEmpty() 
                || this.maKhuVucJtf.getText().trim().isEmpty()
                || this.diaChiJtf.getText().trim().isEmpty()
                || this.chuHo.getNhanKhauModel().getHoTen() == null
                || this.list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các thông tin bắt buộc", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            this.hoKhauBean.setChuHo(chuHo.getNhanKhauModel());
            this.list.forEach(person -> {
                ThanhVienCuaHoModel temp = new ThanhVienCuaHoModel();
                temp.setIdNhanKhau(person.getNhanKhau().getNhanKhauModel().getID());
                temp.setQuanHeVoiChuHo(person.getThanhVienCuaHoModel().getQuanHeVoiChuHo());
                this.hoKhauBean.getListThanhVienCuaHo().add(temp);
            });
            this.hoKhauBean.getHoKhauModel().setMaHoKhau(maHoKhauJtf.getText().trim());
            this.hoKhauBean.getHoKhauModel().setMaKhuVuc(maKhuVucJtf.getText().trim());
            this.hoKhauBean.getHoKhauModel().setDiaChi(diaChiJtf.getText().trim());
            try {
                this.controller.addNew(hoKhauBean);
                this.parentJFrame.setEnabled(true);
                dispose();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
