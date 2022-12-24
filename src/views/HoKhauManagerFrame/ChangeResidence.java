package views.HoKhauManagerFrame;

import controllers.HoKhauManagerController.ChuyenDiNoiKhacController;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bean.HoKhauBean;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChangeResidence extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChuyenDiNoiKhacController controller;
    private HoKhauBean hoKhauBean;
    private JFrame parentJFrame;
    
    /**
     * Creates new form ChuyenDiNoiKhac
     */
    public ChangeResidence(JFrame parentJFrame) {
        initComponents();
        this.hoKhauBean = new HoKhauBean();
        this.parentJFrame = parentJFrame;
        this.parentJFrame.setEnabled(false);
        controller = new ChuyenDiNoiKhacController(hoKhauBean, searchJtf, tableJpn);
        controller.setDataJtf(maHoKhauJtf, tenChuHoJtf, maKhuVucJtf, diaChiHienTaiJtf);
        jPanel1.setLayout(null);
        jPanel1.add(jPanel2);
        jPanel2.setLayout(null);
        jPanel2.add(tableJpn);
        tableJpn.setLayout(null);
        jPanel2.add(jLabel13);
        jPanel2.add(jLabel11);
        jPanel2.add(jLabel9);
        jPanel2.add(jLabel16);
        jPanel2.add(jLabel18);
        jPanel2.add(jLabel4);
        jPanel2.add(maHoKhauJtf);
        jPanel2.add(jLabel6);
        jPanel2.add(tenChuHoJtf);
        jPanel2.add(jLabel10);
        jPanel2.add(maKhuVucJtf);
        jPanel2.add(jLabel12);
        jPanel2.add(diaChiHienTaiJtf);
        jPanel2.add(jLabel14);
        jPanel2.add(cancelBtn);
        jPanel2.add(confirmBtn);
        jPanel2.add(jScrollPane2);
        
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        jScrollPane2.setViewportView(textArea);
        jPanel2.add(diaChiChuyenDenJtf);
        jPanel2.add(jLabel15);
        jPanel2.add(jLabel17);
        jPanel2.add(jLabel1);
        lyDoJta = new javax.swing.JTextArea();
        lyDoJta.setBounds(881, 278, 224, 209);
        jPanel2.add(lyDoJta);
        
                lyDoJta.setColumns(20);
                lyDoJta.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
                lyDoJta.setRows(5);
        jPanel1.add(searchJtf);
        
                //
                JPanel panel3 = new JPanel();
                panel3.setBounds(26, 13, 161, 30);
                jPanel1.add(panel3);
                panel3.setToolTipText("");
                panel3.setBackground(new Color(240, 248, 255));
                panel3.setLayout(null);
                jLabel2 = new javax.swing.JLabel();
                jLabel2.setBounds(10, 0, 151, 30);
                panel3.add(jLabel2);
                jLabel2.setBackground(new Color(255, 255, 255));
                
                  
                        jLabel2.setText("Nhập mã hộ khẩu");
                        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
                        jLabel2.setForeground(new Color(0, 0, 0));
                        jLabel2.setBackground(Color.lightGray);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parentJFrame.setEnabled(true);
                close();
            }
            
        });
    }
    
    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchJtf = new javax.swing.JTextField("Search");
        searchJtf.setBounds(253, 13, 236, 31);
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBounds(10, 54, 1257, 535);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(236, 0, 134, 30);
        tableJpn = new javax.swing.JPanel();
        tableJpn.setBounds(35, 36, 527, 433);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(630, 36, 88, 30);
        maHoKhauJtf = new javax.swing.JTextField();
        maHoKhauJtf.setBounds(801, 37, 411, 30);
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setBounds(1216, 36, 31, 30);
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setBounds(630, 85, 88, 30);
        tenChuHoJtf = new javax.swing.JTextField();
        tenChuHoJtf.setBounds(801, 86, 411, 30);
        jLabel10 = new javax.swing.JLabel();
        jLabel10.setBounds(1216, 85, 31, 30);
        jLabel11 = new javax.swing.JLabel();
        jLabel11.setBounds(630, 134, 102, 30);
        maKhuVucJtf = new javax.swing.JTextField();
        maKhuVucJtf.setBounds(801, 135, 411, 30);
        jLabel12 = new javax.swing.JLabel();
        jLabel12.setBounds(1216, 134, 31, 30);
        diaChiHienTaiJtf = new javax.swing.JTextField();
        diaChiHienTaiJtf.setBounds(801, 184, 411, 30);
        jLabel13 = new javax.swing.JLabel();
        jLabel13.setBounds(630, 183, 123, 30);
        jLabel14 = new javax.swing.JLabel();
        jLabel14.setBounds(1216, 183, 31, 30);
        jLabel15 = new javax.swing.JLabel();
        jLabel15.setBounds(1216, 232, 31, 30);
        jLabel16 = new javax.swing.JLabel();
        jLabel16.setBounds(630, 232, 145, 30);
        diaChiChuyenDenJtf = new javax.swing.JTextField();
        diaChiChuyenDenJtf.setBounds(801, 233, 411, 30);
        jLabel17 = new javax.swing.JLabel();
        jLabel17.setBounds(1216, 273, 31, 30);
        jLabel18 = new javax.swing.JLabel();
        jLabel18.setBounds(630, 273, 134, 30);
        cancelBtn = new javax.swing.JButton();
        cancelBtn.setBounds(994, 502, 100, 25);
        confirmBtn = new javax.swing.JButton();
        confirmBtn.setBounds(1112, 502, 100, 25);
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane2.setBounds(801, 278, 411, 202);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new Color(230,230,250));
       
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
		//searchJtf.setBounds(247, 12, 200, 50);
		//jPanel1.add(searchJtf);
		searchJtf.setColumns(10);


        jPanel2.setBackground(new Color(240, 248, 255));

        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 16)); // NOI18N
        jLabel1.setText("Chọn hộ khẩu");

        tableJpn.setBackground(new Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15)); // NOI18N
        jLabel4.setText("Mã hộ khẩu");

        maHoKhauJtf.setBackground(new Color(255, 255, 255));
        maHoKhauJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("(*)");

        jLabel9.setFont(new Font("Tahoma", Font.BOLD, 15)); // NOI18N
        jLabel9.setText("Tên chủ hộ");

        tenChuHoJtf.setBackground(new Color(255, 255, 255));
        tenChuHoJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("(*)");

        jLabel11.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15)); // NOI18N
        jLabel11.setText("Mã khu vực");

        maKhuVucJtf.setBackground(new Color(255, 255, 255));
        maKhuVucJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("(*)");

        diaChiHienTaiJtf.setBackground(new Color(255, 255, 255));
        diaChiHienTaiJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15)); // NOI18N
        jLabel13.setText("Địa chỉ hiên tại");

        jLabel14.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("(*)");

        jLabel15.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("(*)");

        jLabel16.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15)); // NOI18N
        jLabel16.setText("Địa chỉ chuyển đến");

        diaChiChuyenDenJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("(*)");

        jLabel18.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15)); // NOI18N
        jLabel18.setText("Lý do chuyển đi");

        cancelBtn.setText("Hủy");
        cancelBtn.setBorderPainted(false);
        cancelBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancelBtn.setForeground(new Color(255, 255, 255));
        cancelBtn.setBackground(new Color(147, 112, 219));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        confirmBtn.setText("Xác nhận");
        confirmBtn.setBorderPainted(false);
        confirmBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        confirmBtn.setForeground(new Color(255, 255, 255));
        confirmBtn.setBackground(new Color(147, 112, 219));
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        close();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        if (this.diaChiChuyenDenJtf.getText().trim().isEmpty() || this.lyDoJta.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!!", "Warning!", JOptionPane.NO_OPTION);
        } else {
            this.controller.getHoKhauService().chuyenDi(this.hoKhauBean.getHoKhauModel().getID(), diaChiChuyenDenJtf.getText().trim(), lyDoJta.getText().trim());
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }//GEN-LAST:event_confirmBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField diaChiChuyenDenJtf;
    private javax.swing.JTextField diaChiHienTaiJtf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea lyDoJta;
    private javax.swing.JTextField maHoKhauJtf;
    private javax.swing.JTextField maKhuVucJtf;
    private javax.swing.JTextField searchJtf;
    private javax.swing.JPanel tableJpn;
    private javax.swing.JTextField tenChuHoJtf;
}
