package views.PeopleManagerFrame;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utility.SuggestionUtility;
import views.AddressSuggestion;
import controllers.LoginController;
import controllers.PeoplePanelController;
import controllers.NhanKhauManagerController.AddNewController;
import models.AddressModel;
import models.ChungMinhThuModel;
import models.NhanKhauModel;

import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import bean.NhanKhauBean;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class NewPeopleFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int MARGIN_TOP = 20;
	
	private PeoplePanelController parentController;
    private JFrame parentFrame;
    private NhanKhauBean nhanKhauBean;
    private AddNewController controller;
    private AddressSuggestion addrSuggestion;
    private AddressModel addrModel = new AddressModel();

	private JPanel contentPane;
	private JTextField hoTenTxb;
	private JTextField danTocTxb;
	private JTextField soCMTTxb;
	private JTextField trinhDoHocVanTxb;
	private JTextField trinhDoNgoaiNguTxb;
	private JTextField ngheNghiepTxb;
	private JTextField bietDanhTxb;
	private JTextField tonGiaoTxb;
	private JTextField soHoChieuTxb;
	private JTextField trinhDoChuyenMonTxb;
	private JTextField bietTiengDanTocTxb;
	private JTextField noiLamViecTxb;
	private com.toedter.calendar.JDateChooser namSinhDateC;
	private javax.swing.JButton jButton1;
	private SuggestionUtility quocTichTxb;
	private SuggestionUtility diaChiHienNayTxb;
	private JButton CancelBtn ;
	private JButton CreateBtn;
	private SuggestionUtility nguyenQuanTxb;
	private SuggestionUtility noiThuongTruTxb;
	private javax.swing.JComboBox<String> gioiTinhCbb;
	
    /**
     * @wbp.parser.constructor
     */
    public NewPeopleFrame(JFrame parentJFrame) {
    	init();
        this.parentController = new PeoplePanelController(){
            @Override
            public void refreshData() {
            }

            @Override
            public void initAction() {
            }
        };
        
        this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.nhanKhauBean = new NhanKhauBean();
        controller = new AddNewController();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    close();
            }
            
        });
    }

	public NewPeopleFrame(PeoplePanelController parentController, JFrame parentJFrame) {
        init();
		this.parentController = parentController;
        this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.nhanKhauBean = new NhanKhauBean();
        controller = new AddNewController();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });
	}
	
	private void init() {
		setTitle("Thêm nhân khẩu");
		setBounds(100, 100, 909, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nguyenQuanTxb = new SuggestionUtility(false) {
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		nguyenQuanTxb.setEditable(false);
		nguyenQuanTxb.setBounds(140, 113, 230, 30);
		contentPane.add(nguyenQuanTxb);
		
		namSinhDateC = new JDateChooser();
		namSinhDateC.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		namSinhDateC.setBounds(140, 72, 250, 30);
		contentPane.add(namSinhDateC);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAddressAction();
			}
		});
		btnNewButton.setBounds(370, 113, 20, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Họ và tên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(24, 31, 100, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNgyThngNm = new JLabel("Ngày sinh");
		lblNgyThngNm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgyThngNm.setBounds(24, 52+MARGIN_TOP, 113, 30);
		contentPane.add(lblNgyThngNm);
		
		JLabel lblNguynQun = new JLabel("Nguyên Quán:");
		lblNguynQun.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNguynQun.setBounds(24, 93+MARGIN_TOP, 99, 30);
		contentPane.add(lblNguynQun);
		
		JLabel lblNghNghip = new JLabel("Nghề nghiệp:");
		lblNghNghip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNghNghip.setBounds(24, 339+MARGIN_TOP, 65, 30);
		contentPane.add(lblNghNghip);
		
		JLabel lblChiuS = new JLabel("Hộ chiếu số");
		lblChiuS.setBounds(466, 175+MARGIN_TOP, 65, 30);
		contentPane.add(lblChiuS);
		
		JLabel lblNiLmVic = new JLabel("Nơi làm việc:");
		lblNiLmVic.setBounds(466, 339+MARGIN_TOP, 65, 30);
		contentPane.add(lblNiLmVic);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setBounds(466, 52+MARGIN_TOP, 65, 30);
		contentPane.add(lblGiiTnh);
		
		JLabel lblQucTch = new JLabel("Quốc tịch:");
		lblQucTch.setBounds(466, 134+MARGIN_TOP, 65, 30);
		contentPane.add(lblQucTch);
		
		JLabel lblNiThngCh = new JLabel("Nơi thường trú:");
		lblNiThngCh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNiThngCh.setBounds(24, 215+MARGIN_TOP, 113, 30);
		contentPane.add(lblNiThngCh);
		
		JLabel lblTnGio = new JLabel("Tôn giáo:");
		lblTnGio.setBounds(466, 93+MARGIN_TOP, 65, 30);
		contentPane.add(lblTnGio);
		
		JLabel lblSCmtcccd = new JLabel("Số CMT/CCCD:");
		lblSCmtcccd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSCmtcccd.setBounds(24, 175+MARGIN_TOP, 113, 30);
		contentPane.add(lblSCmtcccd);
		
		JLabel lblDnTc = new JLabel("Dân tộc:");
		lblDnTc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDnTc.setBounds(24, 134+MARGIN_TOP, 65, 30);
		contentPane.add(lblDnTc);
		
		JLabel lblBitDanh = new JLabel("Biệt danh:");
		lblBitDanh.setBounds(466, 11+MARGIN_TOP, 65, 30);
		contentPane.add(lblBitDanh);
		
		JLabel lblaChHin = new JLabel("Địa chỉ hiện tại:");
		lblaChHin.setBounds(466, 216+MARGIN_TOP, 93, 30);
		contentPane.add(lblaChHin);
		
		JLabel lblTrnhHc = new JLabel("Trình độ học vấn:");
		lblTrnhHc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrnhHc.setBounds(24, 257+MARGIN_TOP, 113, 30);
		contentPane.add(lblTrnhHc);
		
		JLabel lblNewLabel_5_1 = new JLabel("Trình độ chuyên môn:");
		lblNewLabel_5_1.setBounds(466, 257+MARGIN_TOP, 134, 30);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Biết tiếng dân tộc:");
		lblNewLabel_5_2.setBounds(466, 298+MARGIN_TOP, 113, 30);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel lblTrnhNgoi = new JLabel("Trình độ ngoại ngữ:");
		lblTrnhNgoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrnhNgoi.setBounds(24, 298+MARGIN_TOP, 113, 30);
		contentPane.add(lblTrnhNgoi);
		
		JLabel lblNewLabel_1 = new JLabel("(*)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		lblNewLabel_1.setBounds(400, 31, 30, 30);
		contentPane.add(lblNewLabel_1);
		
		hoTenTxb = new JTextField();
		hoTenTxb.setBounds(140, 30, 250, 30);
		contentPane.add(hoTenTxb);
		hoTenTxb.setColumns(10);
		
		danTocTxb = new JTextField();
		danTocTxb.setColumns(10);
		danTocTxb.setBounds(140, 134+MARGIN_TOP, 250, 30);
		contentPane.add(danTocTxb);
		
		soCMTTxb = new JTextField();
		soCMTTxb.setColumns(10);
		soCMTTxb.setBounds(140, 195, 250, 30);
		contentPane.add(soCMTTxb);
		
		trinhDoHocVanTxb = new JTextField();
		trinhDoHocVanTxb.setColumns(10);
		trinhDoHocVanTxb.setBounds(140, 257+MARGIN_TOP, 214, 30);
		contentPane.add(trinhDoHocVanTxb);
		
		noiThuongTruTxb = new SuggestionUtility(false) {
			private static final long serialVersionUID = 1L;

			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		noiThuongTruTxb.setEditable(false);
		noiThuongTruTxb.setBounds(140, 236, 230, 30);
		contentPane.add(noiThuongTruTxb);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getAddressAction();
			}
		});
		btnNewButton_1.setBounds(370, 236, 20, 30);
		contentPane.add(btnNewButton_1);
		
		trinhDoNgoaiNguTxb = new JTextField();
		trinhDoNgoaiNguTxb.setColumns(10);
		trinhDoNgoaiNguTxb.setBounds(140, 298+MARGIN_TOP, 214, 30);
		contentPane.add(trinhDoNgoaiNguTxb);
		
		ngheNghiepTxb = new JTextField();
		ngheNghiepTxb.setColumns(10);
		ngheNghiepTxb.setBounds(140, 339+MARGIN_TOP, 214, 30);
		contentPane.add(ngheNghiepTxb);
		
		JLabel lblNewLabel_1_1 = new JLabel("(*)");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setBounds(400, 72, 30, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("(*)");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1.setBounds(400, 112, 30, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("(*)");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.RED);
		lblNewLabel_1_1_2.setBounds(400, 154, 30, 30);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("(*)");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setForeground(Color.RED);
		lblNewLabel_1_1_3.setBounds(400, 194, 30, 30);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("(*)");
		lblNewLabel_1_1_4.setForeground(Color.RED);
		lblNewLabel_1_1_4.setBounds(410, 225+MARGIN_TOP, 14, 14);
		contentPane.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("(*)");
		lblNewLabel_1_1_5.setForeground(Color.RED);
		lblNewLabel_1_1_5.setBounds(364, 266+MARGIN_TOP, 14, 14);
		contentPane.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("(*)");
		lblNewLabel_1_1_6.setForeground(Color.RED);
		lblNewLabel_1_1_6.setBounds(364, 324+MARGIN_TOP, 14, 14);
		contentPane.add(lblNewLabel_1_1_6);
		
		JLabel lblNewLabel_1_1_6_1 = new JLabel("(*)");
		lblNewLabel_1_1_6_1.setForeground(Color.RED);
		lblNewLabel_1_1_6_1.setBounds(364, 365+MARGIN_TOP, 14, 14);
		contentPane.add(lblNewLabel_1_1_6_1);
		
		gioiTinhCbb = new JComboBox<String>();
		gioiTinhCbb.setBounds(594, 52+MARGIN_TOP, 99, 30);
		gioiTinhCbb.addItem("Nam");
		gioiTinhCbb.addItem("Nữ");
		contentPane.add(gioiTinhCbb);
		
		bietDanhTxb = new JTextField();
		bietDanhTxb.setColumns(10);
		bietDanhTxb.setBounds(594, 11+MARGIN_TOP, 214, 30);
		contentPane.add(bietDanhTxb);
		
		tonGiaoTxb = new JTextField();
		tonGiaoTxb.setColumns(10);
		tonGiaoTxb.setBounds(596, 93+MARGIN_TOP, 214, 30);
		contentPane.add(tonGiaoTxb);
		
		quocTichTxb = new SuggestionUtility(false) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		quocTichTxb.setBounds(596, 134+MARGIN_TOP, 214, 30);
		contentPane.add(quocTichTxb);
		
		soHoChieuTxb = new JTextField();
		soHoChieuTxb.setColumns(10);
		soHoChieuTxb.setBounds(596, 176+MARGIN_TOP, 214, 30);
		contentPane.add(soHoChieuTxb);
		
		diaChiHienNayTxb = new SuggestionUtility(false) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		diaChiHienNayTxb.setBounds(596, 217+MARGIN_TOP, 214, 30);
		contentPane.add(diaChiHienNayTxb);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(829, 217+MARGIN_TOP, 36, 30);
		contentPane.add(btnNewButton_2);
		
		trinhDoChuyenMonTxb = new JTextField();
		trinhDoChuyenMonTxb.setColumns(10);
		trinhDoChuyenMonTxb.setBounds(596, 257+MARGIN_TOP, 214, 30);
		contentPane.add(trinhDoChuyenMonTxb);
		
		bietTiengDanTocTxb = new JTextField();
		bietTiengDanTocTxb.setColumns(10);
		bietTiengDanTocTxb.setBounds(596, 298+MARGIN_TOP, 214, 30);
		contentPane.add(bietTiengDanTocTxb);
		
		noiLamViecTxb = new JTextField();
		noiLamViecTxb.setColumns(10);
		noiLamViecTxb.setBounds(596, 339+MARGIN_TOP, 214, 30);
		contentPane.add(noiLamViecTxb);
		
		jButton1 = new JButton("Khác...");
		jButton1.setBounds(140, 421+MARGIN_TOP, 160, 30);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		contentPane.add(jButton1);
		
		CancelBtn = new JButton("Cancel");
		CancelBtn.setBounds(642, 420+MARGIN_TOP, 89, 30);
		CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
		contentPane.add(CancelBtn);
		
		CreateBtn = new JButton("Create");
		CreateBtn.setBounds(763, 420+MARGIN_TOP, 89, 30);
		CreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBtnActionPerformed(evt);
            }
        });
		contentPane.add(CreateBtn);
	}
	
	void close() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
	        this.parentFrame.setEnabled(true);
	        dispose();		
		}
    }
	
    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
       close();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ProfileFrame tieuSuJFrame = new ProfileFrame(this, this.nhanKhauBean);
        tieuSuJFrame.setLocationRelativeTo(null);
        tieuSuJFrame.setResizable(false);
        tieuSuJFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean validateValueInForm() {
        // check null
        if (hoTenTxb.getText().trim().isEmpty() 
                || nguyenQuanTxb.getText().trim().isEmpty()
                || tonGiaoTxb.getText().trim().isEmpty()
                || danTocTxb.getText().trim().isEmpty()
                || quocTichTxb.getText().trim().isEmpty()
                || soCMTTxb.getText().trim().isEmpty()
                || noiThuongTruTxb.getText().trim().isEmpty()
                || diaChiHienNayTxb.getText().trim().isEmpty()
                || trinhDoHocVanTxb.getText().trim().isEmpty()
                || trinhDoChuyenMonTxb.getText().trim().isEmpty()
                || trinhDoNgoaiNguTxb.getText().trim().isEmpty()
                || bietTiengDanTocTxb.getText().trim().isEmpty()
                || ngheNghiepTxb.getText().trim().isEmpty()
                || noiLamViecTxb.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        // check dinh dang so chung minh thu
        try {
                long d = Long.parseLong(soCMTTxb.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Số CMT không thể chứa các ký tự", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        // kiem tra do dai cmt
        if (soCMTTxb.getText().length() != 9 && soCMTTxb.getText().length() != 12) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng CMT", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        if (validateValueInForm()) {
        	
            NhanKhauModel temp = this.nhanKhauBean.getNhanKhauModel();
            ChungMinhThuModel cmt = this.nhanKhauBean.getChungMinhThuModel();
            temp.setBietDanh(bietDanhTxb.getText());
            temp.setHoTen(hoTenTxb.getText());
            temp.setNamSinh(namSinhDateC.getDate());
            temp.setGioiTinh(gioiTinhCbb.getSelectedItem().toString());
            temp.setNguyenQuan(nguyenQuanTxb.getText());
            temp.setTonGiao(tonGiaoTxb.getText());
            temp.setDanToc(danTocTxb.getText());
            temp.setQuocTich(quocTichTxb.getText());
            cmt.setSoCMT(soCMTTxb.getText());
            temp.setSoHoChieu(soHoChieuTxb.getText());
            temp.setNoiThuongTru(noiThuongTruTxb.getText());
            temp.setDiaChiHienNay(diaChiHienNayTxb.getText());
            temp.setTrinhDoHocVan(trinhDoHocVanTxb.getText());
            temp.setTrinhDoChuyenMon(trinhDoChuyenMonTxb.getText());
            temp.setTrinhDoNgoaiNgu(trinhDoNgoaiNguTxb.getText());
            temp.setBietTiengDanToc(bietTiengDanTocTxb.getText());
            temp.setNgheNghiep(ngheNghiepTxb.getText());
            temp.setNoiLamViec(noiLamViecTxb.getText());
            temp.setIdNguoiTao(LoginController.currentUser.getID());
            try {
                if (this.controller.addNewPeople(this.nhanKhauBean)) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công!!");
                    close();
                    parentController.refreshData();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_CreateBtnActionPerformed
    
    private void getAddressAction() {
		addrSuggestion = new AddressSuggestion(this, addrModel);
		addrSuggestion.setVisible(true);
    }
    
    public void setNguyenQuanTxb(String address) {
		nguyenQuanTxb.setText(address);
	}
    
}