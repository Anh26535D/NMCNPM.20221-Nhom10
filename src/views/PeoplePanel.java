package views;

import controllers.PeoplePanelController;
import views.PeopleManagerFrame.NewPeopleFrame;
import views.PeopleManagerFrame.DeathCertiFrame;
import views.PeopleManagerFrame.TempAbsenceDFrame;
import views.PeopleManagerFrame.TempResidenceDFrame;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PeoplePanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    
    private PeoplePanelController controller;
    private JFrame parentJFrame;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewBtn;
    private javax.swing.JButton khaiTuBtn;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton tamTruBtn;
    private javax.swing.JButton tamVangBtn;
    private JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
    
    public PeoplePanel(JFrame parentFrame) {
    	this.parentJFrame = parentFrame;
	    init();
	    controller = new PeoplePanelController(tablePanel, jtfSearch);
        controller.setParentJFrame(parentJFrame);
        controller.setData();
    }

    private void init() {
		setBorder(new LineBorder(new Color(204, 153, 255), 2, true));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 806, 593);
		setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(153, 102, 255), 2));
        panel_2.setBackground(new Color(224, 255, 255));
        panel_2.setBounds(10, 10, 786, 43);
        add(panel_2);
                        
	    JPanel panel = new JPanel();
	    panel.setBorder(new LineBorder(new Color(147, 112, 219), 2, true));
	    panel.setBackground(new Color(230, 230, 250));
	    panel.setBounds(10, 63, 786, 146);
	    add(panel);
	    panel.setLayout(null);
	    
	    
        addNewBtn = new JButton("Thêm mới");
		addNewBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		addNewBtn.setForeground(new Color(255, 255, 255));
		addNewBtn.setBackground(new Color(102, 102, 255));
		addNewBtn.setBorderPainted(false);
        addNewBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        addNewBtn.setBounds(10, 20, 130, 40);
        addNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBtnActionPerformed(evt);
            }
        });
        panel.add(addNewBtn);
	            
        tamVangBtn = new JButton("ĐK tạm vắng");
        tamVangBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
        tamVangBtn.setForeground(new Color(255, 255, 255));
        tamVangBtn.setBackground(new Color(102, 102, 255));
        tamVangBtn.setBorderPainted(false);
        tamVangBtn.setBounds(366, 20, 130, 40);
        tamVangBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        tamVangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamVangBtnActionPerformed(evt);
            }
        });
        panel.add(tamVangBtn);
        
        tamTruBtn = new JButton("ĐK tạm trú");
        tamTruBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
        tamTruBtn.setForeground(new Color(255, 255, 255));
        tamTruBtn.setBackground(new Color(102, 102, 255));
        tamTruBtn.setBorderPainted(false);
        tamTruBtn.setBounds(506, 20, 130, 40);                                                
        tamTruBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
	    tamTruBtn.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            tamTruBtnActionPerformed(evt);
	        }
	    });
        panel.add(tamTruBtn);
        
        khaiTuBtn = new JButton("Khai Tử");
        khaiTuBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
        khaiTuBtn.setForeground(new Color(255, 255, 255));
        khaiTuBtn.setBackground(new Color(102, 102, 255));
        khaiTuBtn.setBorderPainted(false);
        khaiTuBtn.setBounds(646, 20, 130, 40);                                      
        khaiTuBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        khaiTuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khaiTuBtnActionPerformed(evt);
            }
        });
        panel.add(khaiTuBtn);
                    
        jtfSearch = new JTextField("Search");
        jtfSearch.setSelectionColor(new Color(204, 153, 255));
        jtfSearch.setForeground(Color.GRAY);
        jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jtfSearch.setColumns(10);
        jtfSearch.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 102, 255), null, null, null), new EmptyBorder(0, 10, 0, 0)));
        jtfSearch.setBounds(10, 93, 766, 43);
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
        panel.add(jtfSearch);
        
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(204, 102, 255), null, null, null));
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(10, 219, 786, 364);
		add(panel_1);
		panel_1.setLayout(null);
		
		tablePanel = new JPanel();
		tablePanel.setBounds(10, 10, 766, 344);
		tablePanel.setBackground(new Color(255, 255, 255));
		tablePanel.setLayout(null);
		panel_1.add(tablePanel);

    }// </editor-fold>//GEN-END:initComponents

    private void addNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
    	NewPeopleFrame addNewPeopleFrame = new NewPeopleFrame(this.controller, this.parentJFrame);
        addNewPeopleFrame.setLocationRelativeTo(null);
        addNewPeopleFrame.setResizable(false);
        addNewPeopleFrame.setVisible(true);
    }//GEN-LAST:event_addNewBtnActionPerformed

    private void tamVangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamVangBtnActionPerformed
        TempAbsenceDFrame tempAbsenceDFrame = new TempAbsenceDFrame(this.parentJFrame);
        tempAbsenceDFrame.setLocationRelativeTo(null);
        tempAbsenceDFrame.setResizable(false);
        tempAbsenceDFrame.setVisible(true);
    }//GEN-LAST:event_tamVangBtnActionPerformed

    private void tamTruBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamTruBtnActionPerformed
        TempResidenceDFrame tempResidenceDFrame = new TempResidenceDFrame(this.parentJFrame);
        tempResidenceDFrame.setLocationRelativeTo(null);
        tempResidenceDFrame.setResizable(false);
        tempResidenceDFrame.setVisible(true);
    }//GEN-LAST:event_tamTruBtnActionPerformed

    private void khaiTuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khaiTuBtnActionPerformed
        DeathCertiFrame deathCertiFrame = new DeathCertiFrame(this.parentJFrame);
        deathCertiFrame.setLocationRelativeTo(null);
        deathCertiFrame.setResizable(false);
        deathCertiFrame.setVisible(true);
    }//GEN-LAST:event_khaiTuBtnActionPerformed
    
    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
    }//GEN-LAST:event_jtfSearchActionPerformed
}
