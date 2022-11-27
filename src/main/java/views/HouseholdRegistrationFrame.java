package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.HouseholdRegistrationModel;
import service.HouseholdRegistrationService;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HouseholdRegistrationFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableHousehold;
	private HouseholdRegistrationService householdRegistrationService;
	private DefaultTableModel defaultTableModel;

	public HouseholdRegistrationFrame() {	
		this.setResizable(false);
		this.setTitle("Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 200, 900, 550);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 151, 493);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(171, 10, 705, 68);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnRefreshTable = new JButton("Refersh");
		btnRefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		btnRefreshTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRefreshTable.setBounds(610, 37, 85, 21);
		panel_1.add(btnRefreshTable);
		
		JButton btnAddNew = new JButton("Add more");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateNewHouseholdRegistrationFrame().setVisible(true);
			}
		});
		btnAddNew.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddNew.setBounds(10, 37, 98, 21);
		panel_1.add(btnAddNew);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(171, 88, 705, 415);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		this.householdRegistrationService = new HouseholdRegistrationService();
		
		defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		defaultTableModel.addColumn("Số hộ khẩu");
		defaultTableModel.addColumn("Chủ hộ");
		defaultTableModel.addColumn("Số nhà");
		defaultTableModel.addColumn("Thôn");
		defaultTableModel.addColumn("Xã/Huyện");
		defaultTableModel.addColumn("Tỉnh");
		getDataDB(this.householdRegistrationService.all());
		
		tableHousehold = new JTable();
		tableHousehold.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableHousehold.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableHousehold.setBounds(24, 23, 658, 371);
		tableHousehold.setModel(defaultTableModel);
		tableHousehold.getTableHeader().setResizingAllowed(false);
		tableHousehold.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(tableHousehold);
		scrollPane.setBounds(10, 10, 685, 395);
		panel_2.add(scrollPane);			
	}
	
	private void getDataDB(List<HouseholdRegistrationModel> books){
		for(HouseholdRegistrationModel book : books) {
			defaultTableModel.addRow(new Object[] {
					book.getHousehold_file_no(),
					book.getHouseholder_name(),
					book.getHouse_no(),
					book.getStreet_hamlet(),
					book.getWard_commune_town(),
					book.getDistrict_township()
			});
		}		
	}

	private void refreshTable() {
		defaultTableModel.setRowCount(0);
		getDataDB(this.householdRegistrationService.all());
	}
}


