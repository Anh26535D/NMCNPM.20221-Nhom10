package views.PeopleManagerFrame;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import controllers.NhanKhauManagerController.DangKyTamVangController;
import models.TamVangModel;
import utility.SuggestionUtility;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;

public class TempAbsenceDFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame parentFrame;
	private DangKyTamVangController controller = null;
	private TamVangModel tamVangModel = new TamVangModel();
	private JPanel contentPane;
	private JTextField maGiayTamVangJtf;
	private SuggestionUtility noiTamTruJtf;
	private JLabel availableIcon;
    private JDateChooser denNgayJdc;
    private JTextArea lyDoJta;
    private SuggestionUtility soCMTjtf;
    private JDateChooser tuNgayJdc;
    private JButton CancelBtn;
    private JButton acceptBtn;
    private JButton checkBtn;

	public TempAbsenceDFrame(JFrame parentJFrame) {
		init();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.parentFrame = parentJFrame;
		parentJFrame.setEnabled(false);
		controller = new DangKyTamVangController();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                  close();
            }
        });
	}
	
	private void init() {
		setTitle("Khai báo tạm vắng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số CMT / CCCD");
		lblNewLabel.setBounds(55, 11, 96, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblMGiyTm = new JLabel("Mã giấy tạm vắng");
		lblMGiyTm.setBounds(81, 62, 96, 30);
		contentPane.add(lblMGiyTm);
		
		JLabel lblNiTmTr = new JLabel("Nơi tạm trú");
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
		
		denNgayJdc = new JDateChooser();
		denNgayJdc.setBounds(200, 185, 284, 30);
		contentPane.add(denNgayJdc);
		
		tuNgayJdc = new JDateChooser();
		tuNgayJdc.setBounds(200, 144, 284, 30);
		contentPane.add(tuNgayJdc);
		
		maGiayTamVangJtf = new JTextField();
		maGiayTamVangJtf.setBounds(200, 62, 284, 30);
		contentPane.add(maGiayTamVangJtf);
		maGiayTamVangJtf.setColumns(10);
		
		noiTamTruJtf = new SuggestionUtility(false) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		noiTamTruJtf.setBounds(200, 103, 284, 30);
		contentPane.add(noiTamTruJtf);
		
		soCMTjtf = new SuggestionUtility(false) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		soCMTjtf.setBounds(200, 11, 284, 30);
		contentPane.add(soCMTjtf);
		
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
        
        lyDoJta = new JTextArea();
        scrollPane.setViewportView(lyDoJta);
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });
        this.soCMTjtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // neu keycode == 10 ~ enter
                if (e.getKeyCode() == 10) {
                    checkCMT();
                }
            }
        });
	}
	
	void close() {
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Warning!!", JOptionPane.YES_NO_OPTION)) {
            this.parentFrame.setEnabled(true);
            dispose();
        }
    }
	
	private boolean validateForm() {
        return !(maGiayTamVangJtf.getText().trim().isEmpty()
                || noiTamTruJtf.getText().trim().isEmpty()
                || lyDoJta.getText().trim().isEmpty());
    }
    
    private void checkCMT() {
        String tempCMT = this.soCMTjtf.getText().trim() ;
        if (tempCMT.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập So CMT", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            try {
                long cmt = Long.parseLong(tempCMT);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập So CMT đúng định dạng!", "Warning!!", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        int tempID = controller.checkCMT(this.soCMTjtf.getText());
        if( tempID != -1){
            this.soCMTjtf.setEditable(false);
            this.availableIcon.setEnabled(true);
            this.maGiayTamVangJtf.setEnabled(true);
            this.noiTamTruJtf.setEnabled(true);
            this.tuNgayJdc.setEnabled(true);
            this.denNgayJdc.setEnabled(true);
            this.lyDoJta.setEnabled(true);
            
            this.tamVangModel.setIdNhanKhau(tempID);
            this.availableIcon.setEnabled(true);
            JOptionPane.showMessageDialog(this, "OK!!");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân khẩu trong hệ thống!! Thử lại?", "Warning!!", JOptionPane.OK_CANCEL_OPTION) != 0) {
                close();
            }
        }
    }
    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        if (!validateForm()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!", "Warning!!", JOptionPane.WARNING_MESSAGE);
        } else {
            this.tamVangModel.setMaGiayTamVang(this.maGiayTamVangJtf.getText().trim());
            this.tamVangModel.setNoiTamTru(this.noiTamTruJtf.getText().trim());
            this.tamVangModel.setTuNgay(this.tuNgayJdc.getDate());
            this.tamVangModel.setDenNgay(this.denNgayJdc.getDate());
            this.tamVangModel.setLyDo(this.lyDoJta.getText().trim());
            if (this.controller.addNew(this.tamVangModel)) {
                JOptionPane.showMessageDialog(null, "Thêm thành công.");
            }
            close();
        }
    }//GEN-LAST:event_acceptBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Warning", JOptionPane.OK_CANCEL_OPTION) == 0) {
            close();
        }
    }//GEN-LAST:event_CancelBtnActionPerformed

    // kiem tra su ton tai cua nhan khau trong he thong
    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        this.checkCMT();
    }//GEN-LAST:event_checkBtnActionPerformed
}
