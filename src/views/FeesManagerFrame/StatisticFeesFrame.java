package views.FeesManagerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bean.PhiBatBuocBean;
import controllers.PeoplePanelController;
import controllers.FeesManagerController.StatisticFeesController;
import models.FeesModel;

public class StatisticFeesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private StatisticFeesController controller;
	private JFrame parentFrame;
	private PhiBatBuocBean selectedFee;
	private FeesModel feesModel;

	private JPanel tablePanel;
	private JTextField jtfSearch;

	public StatisticFeesFrame(JFrame parentFrame, PhiBatBuocBean selectedFee) {
		this.parentFrame = parentFrame;
		this.selectedFee = selectedFee;
		this.feesModel = selectedFee.getFeesModel();

		init();

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		parentFrame.setEnabled(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Confirm",
						JOptionPane.YES_NO_OPTION) == 0) {
					parentFrame.setEnabled(true);
					dispose();
				}
			}
		});

		controller = new StatisticFeesController(tablePanel, jtfSearch, selectedFee);
		controller.setParentJFrame(parentFrame);
		controller.setData();
	}

	private void init() {
		this.setTitle(this.feesModel.getTen_khoan_thu());
		setBounds(100, 100, 909, 531);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBounds(5, 5, 1100, 1100);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(240, 248, 255));
		jPanel1.setBounds(10, 10, 875, 474);
		jPanel1.setLayout(null);
		contentPane.add(jPanel1);

		jtfSearch = new JTextField("Search");
		jtfSearch.setSelectionColor(new Color(204, 153, 255));
		jtfSearch.setForeground(Color.GRAY);
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfSearch.setColumns(10);
		jtfSearch.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 102, 255), null, null, null),
						new EmptyBorder(0, 10, 0, 0)));
		jtfSearch.setBounds(10, 67, 855, 43);
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
		jPanel1.add(jtfSearch);

		tablePanel = new JPanel();
		tablePanel.setBounds(10, 120, 855, 344);
		tablePanel.setBackground(new Color(255, 255, 255));
		tablePanel.setLayout(null);
		jPanel1.add(tablePanel);
	}

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
    }//GEN-LAST:event_jtfSearchActionPerformed
}
