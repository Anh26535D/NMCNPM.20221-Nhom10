package views.PeopleManagerFrame;

import controllers.LoginController;
import controllers.NhanKhauManagerController.AddNewController;
import controllers.PeoplePanelController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bean.NhanKhauBean;
import models.ChungMinhThuModel;
import models.NhanKhauModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;


public class NewPeopleJFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PeoplePanelController parentController;
    private JFrame parentFrame;
    private NhanKhauBean nhanKhauBean;
    private AddNewController controller;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton CreateBtn;
    private JButton CreateBtn_1;
    private javax.swing.JTextField bietDanhTxb;
    private javax.swing.JTextField bietTiengDanTocTxb;
    private javax.swing.JTextField danTocTxb;
    private javax.swing.JTextField diaChiHienNayTxb;
    private javax.swing.JComboBox<String> gioiTinhCbb;
    private javax.swing.JTextField hoTenTxb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser namSinhDateC;
    private javax.swing.JTextField ngheNghiepTxb;
    private javax.swing.JTextField nguyenQuanTxb;
    private javax.swing.JTextField noiLamViecTxb;
    private javax.swing.JTextField noiThuongTruTxb;
    private javax.swing.JTextField quocTichTxb;
    private javax.swing.JTextField soCMTTxb;
    private javax.swing.JTextField soHoChieuTxb;
    private javax.swing.JTextField tonGiaoTxb;
    private javax.swing.JTextField trinhDoChuyenMonTxb;
    private javax.swing.JTextField trinhDoHocVanTxb;
    private javax.swing.JTextField trinhDoNgoaiNguTxb;
    // End of variables declaration//GEN-END:variables


    public NewPeopleJFrame() {
    	getContentPane().setEnabled(false);
    	getContentPane().setBackground(new Color(255, 255, 255));
        initComponents();
        setTitle("Thêm mới nhân khẩu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        controller = new AddNewController();
    }

    public NewPeopleJFrame(PeoplePanelController parentController, JFrame parentJFrame) {
        this.parentController = parentController;
        this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.nhanKhauBean = new NhanKhauBean();
        initComponents();
        setTitle("Thêm mới nhân khẩu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controller = new AddNewController();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
            
        });
    }
    
    public NewPeopleJFrame(JFrame parentJFrame) {
        this.parentController = new PeoplePanelController(){
            @Override
            public void refreshData() {
                // do nothing
            }

            @Override
            public void initAction() {
                // do nothing
            }
            
            
        };
        this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.nhanKhauBean = new NhanKhauBean();
        initComponents();
        setTitle("Thêm mới nhân khẩu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controller = new AddNewController();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
            
        });
    }
    
    void close() {
        this.parentFrame.setEnabled(true);
        dispose();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        hoTenTxb = new javax.swing.JTextField();
        hoTenTxb.setBounds(194, 38, 318, 30);
        CreateBtn = new javax.swing.JButton();
        CreateBtn_1 = new javax.swing.JButton();
        CreateBtn_1.setSize(100, 30);
        CreateBtn_1.setLocation(920, 490);
        CreateBtn_1.setBackground(new Color(147, 112, 219));
        CreateBtn_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        CreateBtn_1.setForeground(new Color(255, 255, 255));
        CreateBtn_1.setBorderPainted(false);
        CreateBtn_1.setText("Create");
        CreateBtn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
		
        CancelBtn = new javax.swing.JButton();
        CancelBtn.setBounds(783, 490, 100, 30);
        CancelBtn.setBackground(new Color(147, 112, 219));
        CancelBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        CancelBtn.setForeground(new Color(255, 255, 255));
        CancelBtn.setBorderPainted(false);
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
		
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(13, 37, 119, 30);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(516, 37, 15, 30);
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setBounds(572, 37, 108, 30);
        bietDanhTxb = new javax.swing.JTextField();
        bietDanhTxb.setBounds(747, 38, 318, 30);
        nguyenQuanTxb = new javax.swing.JTextField();
        nguyenQuanTxb.setBounds(194, 136, 318, 30);
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setBounds(10, 135, 122, 30);
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setBounds(516, 135, 15, 30);
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setBounds(516, 86, 15, 30);
        jLabel8 = new javax.swing.JLabel();
        jLabel8.setBounds(10, 86, 174, 30);
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setBounds(516, 233, 15, 30);
        danTocTxb = new javax.swing.JTextField();
        danTocTxb.setBounds(194, 185, 318, 30);
        soCMTTxb = new javax.swing.JTextField();
        soCMTTxb.setBounds(194, 234, 318, 30);
        jLabel10 = new javax.swing.JLabel();
        jLabel10.setBounds(10, 233, 122, 30);
        jLabel11 = new javax.swing.JLabel();
        jLabel11.setBounds(516, 184, 15, 30);
        jLabel12 = new javax.swing.JLabel();
        jLabel12.setBounds(10, 184, 110, 30);
        namSinhDateC = new com.toedter.calendar.JDateChooser();
        namSinhDateC.getCalendarButton().setBackground(new Color(255, 255, 255));
        namSinhDateC.setEnabled(false);
        namSinhDateC.setBounds(194, 86, 318, 30);
        gioiTinhCbb = new javax.swing.JComboBox<>();
        gioiTinhCbb.setBounds(747, 86, 85, 30);
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setBounds(572, 86, 88, 30);
        jLabel13 = new javax.swing.JLabel();
        jLabel13.setBounds(572, 135, 88, 30);
        tonGiaoTxb = new javax.swing.JTextField();
        tonGiaoTxb.setBounds(744, 136, 318, 30);
        jLabel14 = new javax.swing.JLabel();
        jLabel14.setBounds(1066, 135, 15, 30);
        quocTichTxb = new javax.swing.JTextField();
        quocTichTxb.setBounds(744, 185, 318, 30);
        jLabel15 = new javax.swing.JLabel();
        jLabel15.setBounds(572, 184, 88, 30);
        jLabel16 = new javax.swing.JLabel();
        jLabel16.setBounds(1066, 184, 15, 30);
        soHoChieuTxb = new javax.swing.JTextField();
        soHoChieuTxb.setBounds(744, 234, 318, 30);
        jLabel17 = new javax.swing.JLabel();
        jLabel17.setBounds(572, 233, 128, 30);
        jLabel19 = new javax.swing.JLabel();
        jLabel19.setBounds(572, 282, 128, 30);
        jLabel20 = new javax.swing.JLabel();
        jLabel20.setBounds(10, 282, 138, 30);
        noiThuongTruTxb = new javax.swing.JTextField();
        noiThuongTruTxb.setBounds(194, 283, 318, 30);
        jLabel21 = new javax.swing.JLabel();
        jLabel21.setBounds(516, 282, 15, 30);
        diaChiHienNayTxb = new javax.swing.JTextField();
        diaChiHienNayTxb.setBounds(744, 283, 318, 30);
        jLabel22 = new javax.swing.JLabel();
        jLabel22.setBounds(1066, 282, 15, 30);
        trinhDoHocVanTxb = new javax.swing.JTextField();
        trinhDoHocVanTxb.setBounds(194, 332, 318, 30);
        jLabel23 = new javax.swing.JLabel();
        jLabel23.setBounds(516, 331, 15, 30);
        jLabel24 = new javax.swing.JLabel();
        jLabel24.setBounds(572, 331, 174, 30);
        trinhDoChuyenMonTxb = new javax.swing.JTextField();
        trinhDoChuyenMonTxb.setBounds(744, 332, 318, 30);
        jLabel25 = new javax.swing.JLabel();
        jLabel25.setBounds(1066, 331, 15, 30);
        jLabel26 = new javax.swing.JLabel();
        jLabel26.setBounds(10, 331, 138, 30);
        jLabel27 = new javax.swing.JLabel();
        jLabel27.setBounds(10, 381, 159, 30);
        trinhDoNgoaiNguTxb = new javax.swing.JTextField();
        trinhDoNgoaiNguTxb.setBounds(194, 381, 318, 30);
        jLabel28 = new javax.swing.JLabel();
        jLabel28.setBounds(516, 380, 15, 30);
        jLabel29 = new javax.swing.JLabel();
        jLabel29.setBounds(572, 380, 162, 30);
        bietTiengDanTocTxb = new javax.swing.JTextField();
        bietTiengDanTocTxb.setBounds(744, 381, 318, 30);
        jLabel30 = new javax.swing.JLabel();
        jLabel30.setBounds(1066, 380, 15, 30);
        jLabel31 = new javax.swing.JLabel();
        jLabel31.setBounds(10, 429, 138, 30);
        ngheNghiepTxb = new javax.swing.JTextField();
        ngheNghiepTxb.setBounds(194, 430, 318, 30);
        jLabel32 = new javax.swing.JLabel();
        jLabel32.setBounds(516, 429, 15, 30);
        jLabel33 = new javax.swing.JLabel();
        jLabel33.setBounds(572, 429, 128, 30);
        noiLamViecTxb = new javax.swing.JTextField();
        noiLamViecTxb.setBounds(744, 430, 318, 30);
        jLabel34 = new javax.swing.JLabel();
        jLabel34.setBounds(1066, 429, 15, 30);
        jButton1 = new javax.swing.JButton();
        jButton1.setBounds(194, 478, 153, 30);
        jButton1.setBackground(new Color(147, 112, 219));
        jButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setBorderPainted(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(240, 248, 255));

        hoTenTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        hoTenTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoTenTxbActionPerformed(evt);
            }
        });





        jLabel1.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel1.setText("Họ và tên:");

        jLabel2.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("(*)");

        jLabel3.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel3.setText("Biệt danh:");

        bietDanhTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        bietDanhTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bietDanhTxbActionPerformed(evt);
            }
        });

        nguyenQuanTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        nguyenQuanTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nguyenQuanTxbActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel5.setText("Nguyên quán:");

        jLabel6.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("(*)");

        jLabel7.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("(*)");

        jLabel8.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel8.setText("Ngày tháng năm sinh:");

        jLabel9.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("(*)");

        danTocTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        danTocTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danTocTxbActionPerformed(evt);
            }
        });

        soCMTTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        soCMTTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soCMTTxbActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel10.setText("Số CMT/CCCD");

        jLabel11.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("(*)");

        jLabel12.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel12.setText("Dân tộc:");

        gioiTinhCbb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        gioiTinhCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        gioiTinhCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gioiTinhCbbActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel4.setText("Giới tính:");

        jLabel13.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel13.setText("Tôn giáo:");

        tonGiaoTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        tonGiaoTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tonGiaoTxbActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("(*)");

        quocTichTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        quocTichTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quocTichTxbActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel15.setText("Quốc tịch:");

        jLabel16.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("(*)");

        soHoChieuTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        soHoChieuTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soHoChieuTxbActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel17.setText("Hộ chiếu số:");

        jLabel19.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel19.setText("Địa chỉ hiện tại:");

        jLabel20.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel20.setText("Nơi thường trú:");

        noiThuongTruTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        noiThuongTruTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noiThuongTruTxbActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("(*)");

        diaChiHienNayTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        diaChiHienNayTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaChiHienNayTxbActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("(*)");

        trinhDoHocVanTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        trinhDoHocVanTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trinhDoHocVanTxbActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("(*)");

        jLabel24.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel24.setText("Trình độ chuyên môn:");

        trinhDoChuyenMonTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        trinhDoChuyenMonTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trinhDoChuyenMonTxbActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("(*)");

        jLabel26.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel26.setText("Trình độ học vấn:");

        jLabel27.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel27.setText("Trình độ ngoại ngữ:");

        trinhDoNgoaiNguTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        trinhDoNgoaiNguTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trinhDoNgoaiNguTxbActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("(*)");

        jLabel29.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel29.setText("Biết tiếng dân tộc:");

        bietTiengDanTocTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        bietTiengDanTocTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bietTiengDanTocTxbActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("(*)");

        jLabel31.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel31.setText("Nghề nghiệp:");

        ngheNghiepTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        ngheNghiepTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngheNghiepTxbActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("(*)");

        jLabel33.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel33.setText("Nơi làm việc:");

        noiLamViecTxb.setFont(new java.awt.Font("Tohoma", 1, 15));  
        noiLamViecTxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noiLamViecTxbActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setText("(*)");

        jButton1.setFont(new java.awt.Font("Tohoma", 1, 15));  
        jButton1.setText("Khác...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1091, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);
        jPanel1.setLayout(null);
        jPanel1.add(CancelBtn);
        jPanel1.add(CreateBtn_1);
        jPanel1.add(jLabel1);
        jPanel1.add(hoTenTxb);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel10);
        jPanel1.add(soCMTTxb);
        jPanel1.add(jLabel9);
        jPanel1.add(jLabel12);
        jPanel1.add(danTocTxb);
        jPanel1.add(jLabel11);
        jPanel1.add(jLabel8);
        jPanel1.add(jLabel5);
        jPanel1.add(nguyenQuanTxb);
        jPanel1.add(jLabel6);
        jPanel1.add(namSinhDateC);
        jPanel1.add(jLabel7);
        jPanel1.add(jLabel20);
        jPanel1.add(noiThuongTruTxb);
        jPanel1.add(jLabel21);
        jPanel1.add(jLabel26);
        jPanel1.add(trinhDoHocVanTxb);
        jPanel1.add(jLabel23);
        jPanel1.add(jLabel27);
        jPanel1.add(trinhDoNgoaiNguTxb);
        jPanel1.add(jLabel28);
        jPanel1.add(jLabel31);
        jPanel1.add(jButton1);
        jPanel1.add(ngheNghiepTxb);
        jPanel1.add(jLabel32);
        jPanel1.add(jLabel19);
        jPanel1.add(jLabel17);
        jPanel1.add(jLabel15);
        jPanel1.add(trinhDoChuyenMonTxb);
        jPanel1.add(jLabel25);
        jPanel1.add(soHoChieuTxb);
        jPanel1.add(diaChiHienNayTxb);
        jPanel1.add(jLabel22);
        jPanel1.add(tonGiaoTxb);
        jPanel1.add(jLabel14);
        jPanel1.add(quocTichTxb);
        jPanel1.add(jLabel16);
        jPanel1.add(bietTiengDanTocTxb);
        jPanel1.add(jLabel30);
        jPanel1.add(noiLamViecTxb);
        jPanel1.add(jLabel34);
        jPanel1.add(jLabel13);
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel24);
        jPanel1.add(jLabel29);
        jPanel1.add(jLabel33);
        jPanel1.add(bietDanhTxb);
        jPanel1.add(gioiTinhCbb);

        pack();
    }

    
    // su ly su kien nhan nut create
    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (validateValueInForm()) {
            // tao moi 1 doi tuong nhan khau
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
    }
    
    
    // check cac gia tri duoc nhap vao form
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
    
    private void hoTenTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoTenTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hoTenTxbActionPerformed

    private void bietDanhTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bietDanhTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bietDanhTxbActionPerformed

    private void nguyenQuanTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nguyenQuanTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nguyenQuanTxbActionPerformed

    private void danTocTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danTocTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_danTocTxbActionPerformed

    private void soCMTTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soCMTTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soCMTTxbActionPerformed
    
    // su kien nhan nut cancel
    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure to close this??","Confirm",JOptionPane.YES_NO_OPTION) == 0) {
            close();
        }
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void gioiTinhCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gioiTinhCbbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gioiTinhCbbActionPerformed

    private void tonGiaoTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tonGiaoTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tonGiaoTxbActionPerformed

    private void quocTichTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quocTichTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quocTichTxbActionPerformed

    private void soHoChieuTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soHoChieuTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soHoChieuTxbActionPerformed

    private void noiThuongTruTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noiThuongTruTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noiThuongTruTxbActionPerformed

    private void diaChiHienNayTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaChiHienNayTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaChiHienNayTxbActionPerformed

    private void trinhDoHocVanTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trinhDoHocVanTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trinhDoHocVanTxbActionPerformed

    private void trinhDoChuyenMonTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trinhDoChuyenMonTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trinhDoChuyenMonTxbActionPerformed

    private void trinhDoNgoaiNguTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trinhDoNgoaiNguTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trinhDoNgoaiNguTxbActionPerformed

    private void bietTiengDanTocTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bietTiengDanTocTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bietTiengDanTocTxbActionPerformed

    private void ngheNghiepTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngheNghiepTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngheNghiepTxbActionPerformed

    private void noiLamViecTxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noiLamViecTxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noiLamViecTxbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	ProfileJFrame tieuSuJFrame = new ProfileJFrame(this, this.nhanKhauBean);
        tieuSuJFrame.setLocationRelativeTo(null);
        tieuSuJFrame.setResizable(false);
        tieuSuJFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed



}