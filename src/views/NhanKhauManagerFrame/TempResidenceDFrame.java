package views.NhanKhauManagerFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import utility.SuggestionUtility;
import controllers.NhanKhauManagerController.DangKyTamTruController;
import models.TamTruModel;
import services.NhanKhauService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TempResidenceDFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NhanKhauService peopleService = new NhanKhauService();
	
	private JFrame parentFrame;
    private DangKyTamTruController controller;
    private TamTruModel tamTruModel;
    
	private JPanel contentPane;
	private JTextField maGiayTamTruJtf;
	private SuggestionUtility soDienThoaiJtf;
	private JLabel availableIcon;
    private JDateChooser denNgayDc;
    private JTextArea lyDoTar;
    private SuggestionUtility soCmtJtf;
    private JDateChooser tuNgayDc;
    private JButton CancelBtn;
    private JButton acceptBtn;
    private JButton checkBtn;

    
	public TempResidenceDFrame() {
		initComponents();
		this.peopleService = new NhanKhauService();
		this.controller = new DangKyTamTruController();
        this.tamTruModel = new TamTruModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Đăng ký tạm trú");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {     
                    close();
            }
            
        });
	}
	
	public TempResidenceDFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        this.controller = new DangKyTamTruController();
        this.tamTruModel = new TamTruModel();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Đăng ký tạm trú");
        parentFrame.setEnabled(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
            
        });
    }
	
	void close() {
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Warning!!", JOptionPane.YES_NO_OPTION)) {
            this.parentFrame.setEnabled(true);
            dispose();
        }
    }
	
	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số CMT / CCCD");
		lblNewLabel.setBounds(55, 11, 96, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblMGiyTm = new JLabel("Mã giấy tạm trú");
		lblMGiyTm.setBounds(81, 62, 96, 30);
		contentPane.add(lblMGiyTm);
		
		JLabel lblNiTmTr = new JLabel("Số điện thoại");
		lblNiTmTr.setBounds(81, 103, 96, 30);
		contentPane.add(lblNiTmTr);
		
		JLabel lblTNgy = new JLabel("Từ ngày");
		lblTNgy.setBounds(81, 144, 96, 30);
		contentPane.add(lblTNgy);
		
		JLabel lblnNgy = new JLabel("Đến ngày");
		lblnNgy.setBounds(81, 185, 96, 30);
		contentPane.add(lblnNgy);
		
		JLabel lblLDo = new JLabel("Lí do");
		lblLDo.setBounds(81, 234, 96, 30);
		contentPane.add(lblLDo);
		
		denNgayDc = new JDateChooser();
		denNgayDc.setBounds(200, 185, 284, 30);
		contentPane.add(denNgayDc);
		
		tuNgayDc = new JDateChooser();
		tuNgayDc.setBounds(200, 144, 284, 30);
		contentPane.add(tuNgayDc);
		
		maGiayTamTruJtf = new JTextField();
		maGiayTamTruJtf.setBounds(200, 62, 284, 30);
		contentPane.add(maGiayTamTruJtf);
		maGiayTamTruJtf.setColumns(10);
		
		soDienThoaiJtf = new SuggestionUtility(false) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		soDienThoaiJtf.setBounds(200, 103, 284, 30);
		contentPane.add(soDienThoaiJtf);
		
		soCmtJtf = new SuggestionUtility(false) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				List<String> list = peopleService.searchByCid(textContent);
				return list;
			}
		};
		soCmtJtf.setBounds(200, 11, 284, 30);
		contentPane.add(soCmtJtf);
		
		checkBtn = new JButton("Check");
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		checkBtn.setBounds(520, 11, 65, 30);
		contentPane.add(checkBtn);
		
		CancelBtn = new JButton("Hủy");
		CancelBtn.setBounds(367, 394, 89, 30);
		contentPane.add(CancelBtn);
		
		acceptBtn = new JButton("Xác nhận");
		acceptBtn.setBounds(481, 394, 89, 30);
		contentPane.add(acceptBtn);
		
		JLabel lblNewLabel_1 = new JLabel("(*)");
		lblNewLabel_1.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		lblNewLabel_1.setBounds(490, 19, 20, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("(*)");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setBounds(494, 70, 20, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("(*)");
		lblNewLabel_1_2.setForeground(Color.RED);
		lblNewLabel_1_2.setBounds(494, 111, 20, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("(*)");
		lblNewLabel_1_3.setForeground(Color.RED);
		lblNewLabel_1_3.setBounds(494, 152, 20, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("(*)");
		lblNewLabel_1_4.setForeground(Color.RED);
		lblNewLabel_1_4.setBounds(494, 193, 20, 14);
		contentPane.add(lblNewLabel_1_4);
		availableIcon = new javax.swing.JLabel();
		availableIcon.setSize(40, 30);
		availableIcon.setLocation(591, 11);
		availableIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/checked.png"))); // NOI18N
        availableIcon.setEnabled(false);
        contentPane.add(availableIcon);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(200, 234, 284, 143);
        contentPane.add(scrollPane);
        
        lyDoTar = new JTextArea();
        scrollPane.setViewportView(lyDoTar);
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cancelBtnActionPerformed(evt);
            }
        });
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });
        this.soCmtJtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // neu keycode == 10 ~ enter
                if (e.getKeyCode() == 10) {
                    checkCMT(soCmtJtf.getText());
                }
            }
        });
	}
	private boolean checkCMT(String cmt) {
        if (cmt.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số CMT", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            try {
                long temp = Long.parseLong(cmt);
                if (cmt.trim().length() != 9 && cmt.trim().length() != 12) {
                    throw new Exception("Sai dinh dang");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số CMT!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        return true;
    }
	
	 private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
	        if (checkCMT(soCmtJtf.getText())) {
	            int idNhanKhau = this.controller.checkCMT(soCmtJtf.getText());
	            if (idNhanKhau > 0) {
	                this.tamTruModel.setIdNhanKhau(idNhanKhau);
	                soCmtJtf.setEnabled(false);
	                checkBtn.setEnabled(false);
	                availableIcon.setEnabled(true);
	                maGiayTamTruJtf.setEnabled(true);
	                soDienThoaiJtf.setEnabled(true);
	                tuNgayDc.setEnabled(true);
	                denNgayDc.setEnabled(true);
	                lyDoTar.setEnabled(true);
	            } else {
	                if (JOptionPane.showConfirmDialog(null, "Không tìm thấy người có số CMT: " + soCmtJtf.getText() + ". Thêm mới?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
	                    AddNewPeopleJFrame addNewPeopleJFrame = new AddNewPeopleJFrame(this);
	                    addNewPeopleJFrame.setLocationRelativeTo(null);
	                    addNewPeopleJFrame.setResizable(false);
	                    addNewPeopleJFrame.setVisible(true);
	                }
	            }
	        }
	    }//GEN-LAST:event_checkBtnActionPerformed
	private boolean validateForm() {
        return !(maGiayTamTruJtf.getText().trim().isEmpty() 
                || soDienThoaiJtf.getText().trim().isEmpty()
                || lyDoTar.getText().trim().isEmpty());
    }
	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        close();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        if (validateForm()) {
            this.tamTruModel.setMaGiayTamTru(maGiayTamTruJtf.getText().trim());
            this.tamTruModel.setSoDienThoaiNguoiDangKy(soDienThoaiJtf.getText().trim());
            this.tamTruModel.setTuNgay(tuNgayDc.getDate());
            this.tamTruModel.setDenNgay(denNgayDc.getDate());
            this.tamTruModel.setLyDo(lyDoTar.getText().trim());
            if (this.controller.addNew(this.tamTruModel)) {
                this.parentFrame.setEnabled(true);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_acceptBtnActionPerformed

}
