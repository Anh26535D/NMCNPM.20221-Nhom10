package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.FeesController;
import controllers.PeoplePanelController;
import views.FeesManagerFrame.EditFeeFrame;
import views.FeesManagerFrame.NewFeeFrame;
import views.PeopleManagerFrame.NewPeopleFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FeesPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private FeesController controller;

    private JFrame parentFrame;

    private JPanel tablePanel;
    private JTextField jtfSearch;
    private JButton addNewBtn;
    private JButton editBtn;

    public FeesPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        init();
        controller = new FeesController(tablePanel, jtfSearch);
        controller.setParentFrame(parentFrame);
        controller.setData();
    }

    private void init() {
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setBackground(new Color(249, 250, 254));
        setBounds(0, 0, 806, 593);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(147, 112, 219), 2, true));
        panel.setBackground(new Color(230, 230, 250));
        panel.setBounds(10, 10, 786, 80);
        add(panel);
        panel.setLayout(null);


        addNewBtn = new JButton("Mới");
        addNewBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
        addNewBtn.setForeground(new Color(255, 255, 255));
        addNewBtn.setBackground(new Color(102, 102, 255));
        addNewBtn.setBorderPainted(false);
        addNewBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        addNewBtn.setBounds(10, 20, 85, 40);
        addNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBtnActionPerformed(evt);
            }
        });
        panel.add(addNewBtn);

        editBtn = new JButton("Sửa");
        editBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
        editBtn.setForeground(new Color(255, 255, 255));
        editBtn.setBackground(new Color(102, 102, 255));
        editBtn.setBorderPainted(false);
        editBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        editBtn.setBounds(105, 20, 85, 40);
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        panel.add(editBtn);

        jtfSearch = new JTextField("Search");

        jtfSearch.setSelectionColor(new Color(204, 153, 255));
        jtfSearch.setForeground(Color.GRAY);
        jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jtfSearch.setColumns(10);
        jtfSearch.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 102, 255), null, null, null), new EmptyBorder(0, 10, 0, 0)));
        jtfSearch.setBounds(200, 19, 576, 43);
        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });

        jtfSearch.setForeground(Color.GRAY);
        jtfSearch.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jtfSearch.getText().trim().equals("Search")) {
                    jtfSearch.setForeground(Color.black);
                    jtfSearch.setText("");
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
        panel_1.setBounds(10, 100, 786, 483);
        add(panel_1);
        panel_1.setLayout(null);

        tablePanel = new JPanel();
        tablePanel.setBounds(10, 10, 766, 463);
        tablePanel.setBackground(new Color(255, 255, 255));
        tablePanel.setLayout(null);
        panel_1.add(tablePanel);
    }

    private void addNewBtnActionPerformed(java.awt.event.ActionEvent evt) {
        NewFeeFrame addNewFeeFrame = new NewFeeFrame(this.controller, this.parentFrame);
        addNewFeeFrame.setLocationRelativeTo(null);
        addNewFeeFrame.setResizable(false);
        addNewFeeFrame.setVisible(true);
    }

    private void editBtnActionPerformed(ActionEvent evt) {
        EditFeeFrame editFeeFrame = new EditFeeFrame(this.controller, this.parentFrame);
        editFeeFrame.setLocationRelativeTo(null);
        editFeeFrame.setResizable(false);
        editFeeFrame.setVisible(true);
    }


    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {
    }
}
