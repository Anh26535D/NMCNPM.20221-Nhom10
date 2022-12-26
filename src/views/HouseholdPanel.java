package views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controllers.HouseholdPanelController;

import views.HoKhauManagerFrame.ChangeResidence;
import views.HoKhauManagerFrame.NewHouseholdFrame;
import views.HoKhauManagerFrame.HouseholdSeper;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class HouseholdPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JFrame parentFrame;
    private HouseholdPanelController controller;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton chuyenDiBtn;
    private JTextField jtfSearch;
    private JPanel tableJpn;
    private JButton tachHoKhauBtn;
    private JButton themMoiBtn;
    // End of variables declaration//GEN-END:variables

	public HouseholdPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
        init();
        controller = new HouseholdPanelController(jtfSearch, tableJpn);
        controller.setParentJFrame(parentFrame);
	}
	
	private void init() {
		setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 806, 593);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(147, 112, 219), 2, true));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(10, 63, 786, 146);
		add(panel_1);
		panel_1.setLayout(null);
		
		themMoiBtn = new JButton("Mới");
        themMoiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMoiBtnActionPerformed(evt);
            }
        });
		themMoiBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		themMoiBtn.setForeground(new Color(255, 255, 255));
		themMoiBtn.setBackground(new Color(102, 102, 255));
		themMoiBtn.setBorderPainted(false);
		themMoiBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		themMoiBtn.setBounds(10, 20, 130, 40);
		panel_1.add(themMoiBtn);
		
		tachHoKhauBtn = new JButton("Tách hộ khẩu");
        tachHoKhauBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tachHoKhauBtnActionPerformed(evt);
            }
        });
		tachHoKhauBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		tachHoKhauBtn.setBackground(new Color(102, 102, 255));
		tachHoKhauBtn.setForeground(new Color(255, 255, 255));
		tachHoKhauBtn.setBorderPainted(false);
		tachHoKhauBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		tachHoKhauBtn.setBounds(506, 20, 130, 40);
		panel_1.add(tachHoKhauBtn);
		
		chuyenDiBtn = new JButton("Chuyển nơi ở");
        chuyenDiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuyenDiBtnActionPerformed(evt);
            }
        });
		chuyenDiBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		chuyenDiBtn.setBackground(new Color(102, 102, 255));
		chuyenDiBtn.setForeground(new Color(255, 255, 255));
		chuyenDiBtn.setBorderPainted(false);;
		chuyenDiBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		chuyenDiBtn.setBounds(646, 20, 130, 40);
		panel_1.add(chuyenDiBtn);
		
		jtfSearch = new JTextField("Search");
        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });

		jtfSearch.setForeground(Color.GRAY);
		jtfSearch.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (jtfSearch.getText().equals("Search")) {
		        	jtfSearch.setText("");
		        	jtfSearch.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (jtfSearch.getText().isEmpty()) {
		        	jtfSearch.setForeground(Color.GRAY);
		        	jtfSearch.setText("Search");
		        }
		    }
		    });
		jtfSearch.setSelectionColor(new Color(204, 153, 255));
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfSearch.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 102, 255), null, null, null), new EmptyBorder(0, 10, 0, 0)));
		jtfSearch.setBounds(10, 93, 766, 43);
		panel_1.add(jtfSearch);
		jtfSearch.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(153, 102, 255), 2));
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBounds(10, 10, 786, 43);
		add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 255), null, null, null));
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(10, 219, 786, 364);
		add(panel);
		panel.setLayout(null);
		
		tableJpn = new JPanel();
		tableJpn.setBounds(10, 10, 766, 344);
		tableJpn.setBackground(new Color(255, 255, 255));
		tableJpn.setLayout(null);
		panel.add(tableJpn);
	}
	
    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void chuyenDiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuyenDiBtnActionPerformed
        ChangeResidence chuyenDiNoiKhac = new ChangeResidence(this.parentFrame);
        chuyenDiNoiKhac.setLocationRelativeTo(null);
        chuyenDiNoiKhac.setResizable(false);
        chuyenDiNoiKhac.setVisible(true);
    }//GEN-LAST:event_chuyenDiBtnActionPerformed

    private void themMoiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMoiBtnActionPerformed
        NewHouseholdFrame themMoiHoKhau = new NewHouseholdFrame(this.parentFrame);
        themMoiHoKhau.setLocationRelativeTo(null);
        themMoiHoKhau.setResizable(false);
        themMoiHoKhau.setVisible(true);
    }//GEN-LAST:event_themMoiBtnActionPerformed

    private void tachHoKhauBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tachHoKhauBtnActionPerformed
        HouseholdSeper tachHoKhau = new HouseholdSeper(this.parentFrame);
        tachHoKhau.setLocationRelativeTo(null);
        tachHoKhau.setResizable(false);
        tachHoKhau.setVisible(true);
    }//GEN-LAST:event_tachHoKhauBtnActionPerformed
}
