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
import services.NhanKhauService;
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
import java.awt.Font;

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
	
	private NhanKhauService peopleService;

	public TempAbsenceDFrame(JFrame parentJFrame) {
		peopleService = new NhanKhauService();
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
		setBounds(100, 100, 651, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 10, 617, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Số CMT/CCCD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 10, 130, 20);
		panel.add(lblNewLabel);

		soCMTjtf = new SuggestionUtility(false) {
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				List<String> list = peopleService.searchByCid(textContent);
				return list;
			}
		};
		soCMTjtf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					checkCMT();
				}
			}
		});
		soCMTjtf.setBounds(150, 10, 284, 20);
		panel.add(soCMTjtf);

		JLabel lblNewLabel_1 = new JLabel("(*)");
		lblNewLabel_1.setBounds(440, 10, 20, 30);
		lblNewLabel_1.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		panel.add(lblNewLabel_1);
		
		checkBtn = new JButton("Check");
		checkBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkBtnActionPerformed(evt);
			}
		});
		checkBtn.setBounds(470, 10, 87, 20);
		panel.add(checkBtn);

		availableIcon = new javax.swing.JLabel();
		availableIcon.setBounds(567, 5, 32, 30);
		availableIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/checked.png"))); // NOI18N
		availableIcon.setEnabled(false);
		panel.add(availableIcon);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 60, 617, 40);
		contentPane.add(panel_1);

		JLabel lblMGiyTm = new JLabel("Mã giấy tạm vắng");
		lblMGiyTm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMGiyTm.setBounds(10, 10, 130, 20);
		panel_1.add(lblMGiyTm);

		maGiayTamVangJtf = new JTextField();
		maGiayTamVangJtf.setBounds(150, 10, 284, 20);
		maGiayTamVangJtf.setColumns(10);
		panel_1.add(maGiayTamVangJtf);

		JLabel lblNewLabel_1_1 = new JLabel("(*)");
		lblNewLabel_1_1.setBounds(440, 10, 20, 20);
		lblNewLabel_1_1.setForeground(Color.RED);
		panel_1.add(lblNewLabel_1_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(240, 248, 255));
		panel_1_1.setBounds(10, 110, 617, 40);
		contentPane.add(panel_1_1);

		JLabel lblNiTmTr = new JLabel("Nơi tạm trú");
		lblNiTmTr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNiTmTr.setBounds(10, 10, 130, 20);
		panel_1_1.add(lblNiTmTr);

		noiTamTruJtf = new SuggestionUtility(false) {
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		noiTamTruJtf.setBounds(150, 10, 284, 20);
		panel_1_1.add(noiTamTruJtf);

		JLabel lblNewLabel_1_2 = new JLabel("(*)");
		lblNewLabel_1_2.setBounds(440, 10, 20, 20);
		panel_1_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(Color.RED);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(240, 248, 255));
		panel_1_1_1.setBounds(10, 160, 617, 40);
		contentPane.add(panel_1_1_1);

		JLabel lblTNgy = new JLabel("Từ ngày");
		lblTNgy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTNgy.setBounds(10, 10, 130, 20);
		panel_1_1_1.add(lblTNgy);

		tuNgayJdc = new JDateChooser();
		tuNgayJdc.setBounds(150, 10, 284, 20);
		panel_1_1_1.add(tuNgayJdc);

		JLabel lblNewLabel_1_3 = new JLabel("(*)");
		lblNewLabel_1_3.setBounds(440, 10, 20, 20);
		panel_1_1_1.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setForeground(Color.RED);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(new Color(240, 248, 255));
		panel_1_1_1_1.setBounds(10, 210, 617, 40);
		contentPane.add(panel_1_1_1_1);

		JLabel lblnNgy = new JLabel("Đến ngày");
		lblnNgy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblnNgy.setBounds(10, 10, 130, 20);
		panel_1_1_1_1.add(lblnNgy);

		denNgayJdc = new JDateChooser();
		denNgayJdc.setBounds(150, 10, 284, 20);
		panel_1_1_1_1.add(denNgayJdc);

		JLabel lblNewLabel_1_4 = new JLabel("(*)");
		lblNewLabel_1_4.setBounds(440, 10, 20, 20);
		panel_1_1_1_1.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setForeground(Color.RED);

		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBackground(new Color(240, 248, 255));
		panel_1_1_1_1_1.setBounds(10, 260, 617, 160);
		contentPane.add(panel_1_1_1_1_1);

		JLabel lblLDo = new JLabel("Lí do");
		lblLDo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLDo.setBounds(10, 10, 130, 20);
		panel_1_1_1_1_1.add(lblLDo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 10, 459, 140);
		panel_1_1_1_1_1.add(scrollPane);

		lyDoJta = new JTextArea();
		scrollPane.setViewportView(lyDoJta);
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		CancelBtn = new JButton("Hủy");
		CancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CancelBtnActionPerformed(evt);
			}
		});
		CancelBtn.setBounds(439, 432, 89, 30);
		contentPane.add(CancelBtn);

		acceptBtn = new JButton("Xác nhận");
		acceptBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				acceptBtnActionPerformed(evt);
			}
		});
		acceptBtn.setBounds(538, 432, 89, 30);
		contentPane.add(acceptBtn);
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
