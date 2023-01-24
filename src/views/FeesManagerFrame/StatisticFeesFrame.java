package views.FeesManagerFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.PhiBatBuocBean;
import models.FeesModel;

public class StatisticFeesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JFrame parentFrame;
	private PhiBatBuocBean selectedFee;
	private FeesModel feesModel;

	public StatisticFeesFrame(JFrame parentFrame, PhiBatBuocBean selectedFee) {
		this.parentFrame = parentFrame;
		this.selectedFee = selectedFee;
		this.feesModel = selectedFee.getFeesModel();
		this.setTitle(this.feesModel.getTen_khoan_thu());
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		parentFrame.setEnabled(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                	parentFrame.setEnabled(true);
                    dispose();
                }
            }
        });
        
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

}
