package views.HouseholdManagerFrame;

import controllers.HoKhauManagerController.TachHoKhauController;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HouseholdSeper extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TachHoKhauController controller;
    private JFrame parentJFrame;
    private JPanel contentPane;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField chuHoHienTaiJtf;
    private javax.swing.JTextField chuHoMoiJtf;
    private javax.swing.JTextField diaChiJtf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField maHoKhauMoiJtf;
    private javax.swing.JTextField maKhuVucJtf;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTextField searchJtf;
    private javax.swing.JPanel tableBotJpn;
    private javax.swing.JPanel tableRigthJtf;
    private javax.swing.JPanel tableTopJpn;
    // End of variables declaration//GEN-END:variables

    public JFrame getParentJFrame() {
        return parentJFrame;
    }
    public HouseholdSeper(JFrame parentJFrame) {
    	this.parentJFrame = parentJFrame;
    	init();
    	controller = new TachHoKhauController(this);
    	controller.setAcceptBtn(acceptBtn);
        controller.setAddBtn(addBtn);
        controller.setCancelBtn(cancelBtn);
        controller.setChuHoHienTaiJtf(chuHoHienTaiJtf);
        controller.setChuHoMoiJtf(chuHoMoiJtf);
        controller.setDiaChiJtf(diaChiJtf);
        controller.setMaHoKhauMoiJtf(maHoKhauMoiJtf);
        controller.setMaKhuVucJtf(maKhuVucJtf);
        controller.setRemoveBtn(removeBtn);
        controller.setSearchJtf(searchJtf);
        controller.setTableBotJpn(tableBotJpn);
        controller.setTableRightJpn(tableRigthJtf);
        controller.setTableTopJpn(tableTopJpn);
        controller.init();
    }
    
    private void init() {
    	this.setResizable(false);
		this.setTitle("Tách hộ khẩu");
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(350, 200, 1000, 670);
		this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
            
        });
    	contentPane = new JPanel();
    	contentPane.setBackground(new Color(255, 255, 255));
    	setContentPane(contentPane);
    	
    	jPanel2 = new javax.swing.JPanel();
    	jPanel2.setBounds(10, 10, 966, 615);
        tableTopJpn = new javax.swing.JPanel();
        tableTopJpn.setBounds(10, 85, 355, 205);
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBounds(394, 85, 562, 205);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(10, 10, 116, 33);
        chuHoHienTaiJtf = new javax.swing.JTextField();
        chuHoHienTaiJtf.setBounds(136, 10, 382, 32);
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setBounds(10, 161, 116, 33);
        chuHoMoiJtf = new javax.swing.JTextField();
        chuHoMoiJtf.setBounds(136, 164, 382, 32);
        chuHoMoiJtf.setBackground(new Color(255, 255, 255));
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setBounds(528, 9, 19, 30);
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setBounds(528, 157, 19, 30);
        jLabel12 = new javax.swing.JLabel();
        jLabel12.setBounds(528, 46, 19, 30);
        jLabel13 = new javax.swing.JLabel();
        jLabel13.setBounds(10, 50, 116, 33);
        maKhuVucJtf = new javax.swing.JTextField();
        maKhuVucJtf.setBounds(136, 49, 382, 32);
        jLabel14 = new javax.swing.JLabel();
        jLabel14.setBounds(10, 87, 116, 33);
        diaChiJtf = new javax.swing.JTextField();
        diaChiJtf.setBounds(136, 88, 382, 32);
        jLabel15 = new javax.swing.JLabel();
        jLabel15.setBounds(528, 83, 19, 30);
        jLabel16 = new javax.swing.JLabel();
        jLabel16.setBounds(10, 123, 116, 33);
        maHoKhauMoiJtf = new javax.swing.JTextField();
        maHoKhauMoiJtf.setBounds(136, 126, 382, 32);
        jLabel17 = new javax.swing.JLabel();
        jLabel17.setBounds(528, 120, 19, 30);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(10, 55, 170, 30);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(10, 13, 170, 30);
        searchJtf = new javax.swing.JTextField();
        tableBotJpn = new javax.swing.JPanel();
        tableBotJpn.setBounds(10, 346, 355, 205);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(10, 310, 225, 30);
        tableRigthJtf = new javax.swing.JPanel();
        tableRigthJtf.setBounds(480, 342, 476, 205);
        jLabel18 = new javax.swing.JLabel();
        jLabel18.setBounds(457, 310, 225, 30);
        addBtn = new javax.swing.JButton();
        addBtn.setBounds(394, 346, 60, 30);
        removeBtn = new javax.swing.JButton();
        removeBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        removeBtn.setBounds(394, 400, 60, 30);
        acceptBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();



        jPanel2.setBackground(new java.awt.Color(230, 230, 250));


        tableTopJpn.setBackground(new Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(240, 248, 255));

        jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel4.setText("Chủ hộ hiện tại");

        chuHoHienTaiJtf.setBackground(new Color(255, 255, 255));
        chuHoHienTaiJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel5.setText("Chủ hộ mới");

        chuHoMoiJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

        jLabel6.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("(*)");

        jLabel7.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("(*)");

        jLabel12.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("(*)");

        jLabel13.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel13.setText("Mã khu vực");

        maKhuVucJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel14.setText("Địa chỉ");

        diaChiJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("(*)");

        jLabel16.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel16.setText("Mã hộ khẩu mới");

        maHoKhauMoiJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("(*)");

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jLabel1.setText("Chọn hộ cần tách");

        jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jLabel2.setText("Nhập mã hộ khẩu");

       
        searchJtf.setForeground(Color.GRAY);
		searchJtf.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (searchJtf.getText().equals("Search")) {
		        	searchJtf.setText("");
		        	searchJtf.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (searchJtf.getText().isEmpty()) {
		        	searchJtf.setForeground(Color.GRAY);
		        	searchJtf.setText("Search");
		        }
		    }
		    });
		searchJtf.setSelectionColor(new Color(204, 153, 255));
		searchJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchJtf.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 102, 255), null, null, null), new EmptyBorder(0, 10, 0, 0)));
		searchJtf.setBounds(190, 15, 766, 30);
		jPanel2.add(searchJtf);
		searchJtf.setColumns(10);


        tableBotJpn.setBackground(new Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jLabel3.setText("Chọn người sang hộ mới");

        tableRigthJtf.setBackground(new Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jLabel18.setText("Những người ở hộ mới");

        addBtn.setText(">>");
        addBtn.setBorderPainted(false);
       // addBtn.setBounds(531, 438, 60, 21);
        addBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        addBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        addBtn.setForeground(new Color(255, 255, 255));
        addBtn.setBackground(new Color(147, 112, 219));

        removeBtn.setText("<<");
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        removeBtn.setBorderPainted(false);
        removeBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        removeBtn.setBackground(new Color(147, 112, 219));

        acceptBtn.setText("Xác nhận");
        acceptBtn.setBorderPainted(false);
        acceptBtn.setBounds(845, 572, 100, 30);
        acceptBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        acceptBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        acceptBtn.setForeground(new Color(255, 255, 255));
        acceptBtn.setBackground(new Color(147, 112, 219));
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Hủy");
        cancelBtn.setBorderPainted(false);
        cancelBtn.setBounds(694, 572, 100, 30);
        cancelBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancelBtn.setForeground(new Color(255, 255, 255));
        cancelBtn.setBackground(new Color(147, 112, 219));
        

        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        tableTopJpn.getAccessibleContext().setAccessibleName("");
        
        contentPane.setLayout(null);
        
        jPanel2.setLayout(null);
        jPanel2.add(searchJtf);
        jPanel2.add(jLabel1);
        jPanel2.add(tableTopJpn);
        tableTopJpn.setLayout(null);
        jPanel2.add(tableBotJpn);
        tableBotJpn.setLayout(null);
        jPanel2.add(jLabel3);
        jPanel2.add(cancelBtn);
        jPanel2.add(acceptBtn);
        jPanel2.add(removeBtn);
        jPanel2.add(addBtn);
        jPanel2.add(jLabel18);
        jPanel2.add(tableRigthJtf);
        tableRigthJtf.setLayout(null);
        jPanel2.add(jPanel1);
        jPanel1.setLayout(null);
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel5);
        jPanel1.add(jLabel13);
        jPanel1.add(jLabel14);
        jPanel1.add(jLabel16);
        jPanel1.add(chuHoHienTaiJtf);
        jPanel1.add(chuHoMoiJtf);
        jPanel1.add(maKhuVucJtf);
        jPanel1.add(diaChiJtf);
        jPanel1.add(maHoKhauMoiJtf);
        jPanel1.add(jLabel6);
        jPanel1.add(jLabel7);
        jPanel1.add(jLabel12);
        jPanel1.add(jLabel15);
        jPanel1.add(jLabel17);
        jPanel2.add(jLabel2);
        contentPane.add(jPanel2);

    }

    public void close() {
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Warning!!", JOptionPane.YES_NO_OPTION)) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }


    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        close();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acceptBtnActionPerformed




}