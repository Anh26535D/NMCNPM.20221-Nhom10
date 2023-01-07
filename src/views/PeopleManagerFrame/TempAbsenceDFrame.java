package views.PeopleManagerFrame;

import controllers.NhanKhauManagerController.DangKyTamVangController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.TamVangModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Color;
import java.awt.Font;


public class TempAbsenceDFrame extends javax.swing.JFrame {

    private  JFrame parentJFrame = null;
    private DangKyTamVangController controller = null;
    private TamVangModel tamVangModel = new TamVangModel();

    public TempAbsenceDFrame(JFrame parentJFrame) {
    	getContentPane().setBackground(new Color(255, 255, 255));
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controller = new DangKyTamVangController();
        this.parentJFrame = parentJFrame;
        parentJFrame.setEnabled(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
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
        this.parentJFrame.setEnabled(true);
            dispose();
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
            // khong cho phep sua lai gia tri
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
     

    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(240, 248, 255));
        acceptBtn = new javax.swing.JButton();
        acceptBtn.setBounds(477, 422, 101, 30);
        CancelBtn = new javax.swing.JButton();
        CancelBtn.setBounds(334, 422, 100, 30);
        soCMTjtf = new javax.swing.JTextField();
        soCMTjtf.setBounds(163, 12, 279, 30);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(32, 11, 121, 30);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(452, 11, 15, 30);
        checkBtn = new javax.swing.JButton();
        checkBtn.setBounds(477, 11, 81, 30);
        availableIcon = new javax.swing.JLabel();
        availableIcon.setBounds(568, 9, 32, 32);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(54, 93, 136, 30);
        maGiayTamVangJtf = new javax.swing.JTextField();
        maGiayTamVangJtf.setBounds(200, 94, 333, 30);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(543, 93, 15, 30);
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setBounds(54, 142, 136, 30);
        noiTamTruJtf = new javax.swing.JTextField();
        noiTamTruJtf.setBounds(200, 143, 333, 30);
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setBounds(543, 142, 15, 30);
        tuNgayJdc = new com.toedter.calendar.JDateChooser();
        tuNgayJdc.setBounds(200, 191, 333, 30);
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setBounds(543, 191, 15, 30);
        jLabel8 = new javax.swing.JLabel();
        jLabel8.setBounds(54, 191, 136, 30);
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setBounds(54, 239, 127, 30);
        denNgayJdc = new com.toedter.calendar.JDateChooser();
        denNgayJdc.setBounds(200, 239, 333, 30);
        jLabel10 = new javax.swing.JLabel();
        jLabel10.setBounds(543, 239, 15, 30);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(200, 287, 319, 99);
        jLabel11 = new javax.swing.JLabel();
        jLabel11.setBounds(54, 287, 136, 17);
        jLabel12 = new javax.swing.JLabel();
        jLabel12.setBounds(543, 280, 15, 30);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        acceptBtn.setText("Xác nhận");
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	acceptBtnActionPerformed(evt);
            }
        });
        acceptBtn.setBackground(new Color(147, 112, 219));
        acceptBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        acceptBtn.setForeground(new Color(255, 255, 255));
        acceptBtn.setBorderPainted(false);

        
        CancelBtn.setText("Hủy");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	CancelBtnActionPerformed(evt);
            }
        });
        CancelBtn.setBackground(new Color(147, 112, 219));
        CancelBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		CancelBtn.setForeground(new Color(255, 255, 255));
		CancelBtn.setBorderPainted(false);

        soCMTjtf.setFont(new java.awt.Font("Tohama", 0, 14));  
        soCMTjtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soCMTjtfActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tohama", 1, 14));  
        jLabel1.setText("Số CMT/ CCCD:");

        jLabel2.setFont(new java.awt.Font("Tohama", 0, 14));  
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("(*)");

        checkBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));  
        checkBtn.setText("Check");
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        checkBtn.setBackground(new Color(147, 112, 219));
        checkBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        checkBtn.setForeground(new Color(255, 255, 255));
        checkBtn.setBorderPainted(false);

        availableIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/checked.png")));  
        availableIcon.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tohama", 1, 14));  
        jLabel3.setText("Mã giấy tạm vắng:");

        maGiayTamVangJtf.setFont(new java.awt.Font("Tohama", 0, 14));  
        maGiayTamVangJtf.setEnabled(false);
        maGiayTamVangJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maGiayTamVangJtfActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tohama", 0, 14));  
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("(*)");

        jLabel5.setFont(new java.awt.Font("Tohama", 1, 14));  
        jLabel5.setText("Nơi tạm trú:");

        noiTamTruJtf.setFont(new java.awt.Font("Tohama", 0, 14));  
        noiTamTruJtf.setEnabled(false);
        noiTamTruJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noiTamTruJtfActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tohama", 0, 14));  
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("(*)");

        tuNgayJdc.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tohama", 0, 14));  
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("(*)");

        jLabel8.setFont(new java.awt.Font("Tohama", 1, 14));  
        jLabel8.setText("Từ ngày:");

        jLabel9.setFont(new java.awt.Font("Tohama", 1, 14));  
        jLabel9.setText("Đến ngày:");

        denNgayJdc.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tohama", 0, 14));  
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("(*)");

        jLabel11.setFont(new java.awt.Font("Tohama", 1, 14));  
        jLabel11.setText("Lý do:");

        jLabel12.setFont(new java.awt.Font("Tohama", 0, 14));  
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("(*)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1.setLayout(null);
        jPanel1.add(jLabel1);
        jPanel1.add(soCMTjtf);
        jPanel1.add(jLabel2);
        jPanel1.add(checkBtn);
        jPanel1.add(availableIcon);
        jPanel1.add(jLabel3);
        jPanel1.add(maGiayTamVangJtf);
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel5);
        jPanel1.add(jLabel8);
        jPanel1.add(jLabel9);
        jPanel1.add(jLabel11);
        jPanel1.add(jScrollPane1);
        lyDoJta = new javax.swing.JTextArea();
        jScrollPane1.setViewportView(lyDoJta);
        
                lyDoJta.setColumns(20);
                lyDoJta.setFont(new java.awt.Font("Tohama", 0, 14));  
                lyDoJta.setRows(5);
                lyDoJta.setEnabled(false);
        jPanel1.add(tuNgayJdc);
        jPanel1.add(noiTamTruJtf);
        jPanel1.add(denNgayJdc);
        jPanel1.add(jLabel6);
        jPanel1.add(jLabel7);
        jPanel1.add(jLabel10);
        jPanel1.add(jLabel12);
        jPanel1.add(CancelBtn);
        jPanel1.add(acceptBtn);
        getContentPane().setLayout(layout);

        pack();
    } 

    private void soCMTjtfActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }//GEN-LAST:event_soCMTjtfActionPerformed

    private void maGiayTamVangJtfActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }//GEN-LAST:event_maGiayTamVangJtfActionPerformed
    private void noiTamTruJtfActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }//GEN-LAST:event_noiTamTruJtfActionPerformed

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton acceptBtn;
    private javax.swing.JLabel availableIcon;
    private javax.swing.JButton checkBtn;
    private com.toedter.calendar.JDateChooser denNgayJdc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lyDoJta;
    private javax.swing.JTextField maGiayTamVangJtf;
    private javax.swing.JTextField noiTamTruJtf;
    private javax.swing.JTextField soCMTjtf;
    private com.toedter.calendar.JDateChooser tuNgayJdc;
    // End of variables declaration//GEN-END:variables
}