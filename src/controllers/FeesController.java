package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;


import bean.PhiBatBuocBean;
import models.FeesModel;
import services.FeesService;
import utility.ClassTableModel;
import views.FeesManagerFrame.StatisticFeesFrame;

public class FeesController {

    private JPanel jpnView;
    private JTextField jtfSearch;
    private FeesService feesService;
    private List<PhiBatBuocBean> listPhiBatBuocBeans;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"ID", "Tên khoản thu", "Số tiền", "Đợt thu"};
    private JFrame parentFrame;

    public FeesController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        classTableModel = new ClassTableModel();
        this.feesService = new FeesService();
        this.listPhiBatBuocBeans = this.feesService.allFees();
        initAction();
    }

    public FeesController() {
    }
    
    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }
    
    public void initAction(){
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listPhiBatBuocBeans = feesService.searchFeeByID(key.trim());
                setData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listPhiBatBuocBeans = feesService.searchFeeByID(key.trim());
                setData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listPhiBatBuocBeans = feesService.searchFeeByID(key.trim());
                setData();
            }
        });
    }
    
    public void setData() {
        List<FeesModel> listItem = new ArrayList<>();
        this.listPhiBatBuocBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getFeesModel());
        });
        
        DefaultTableModel model = classTableModel.setTableFees(listItem, COLUMNS);
        JTable table = new JTable(model) {
            private static final long serialVersionUID = 1L;

			@Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
			
            @Override
	        public Component prepareRenderer(TableCellRenderer renderer,int row,int column){
	            Component comp=super.prepareRenderer(renderer,row, column);
	           int modelRow=convertRowIndexToModel(row);
	           if(!isRowSelected(modelRow))
	               comp.setBackground(Color.WHITE);
	           else
	               comp.setBackground(new Color(102, 102, 255));
	           return comp;
	        }
            
        };
       
        //Set style for table header
        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);
        header.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        header.setOpaque(false);
        header.setBackground(new Color(230, 230, 255));
        header.setForeground(Color.black);
        
        header.setPreferredSize(new Dimension(100, 50));
        
        //Set style for table content
        table.setRowHeight(30);
        table.validate();
        table.repaint();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                	PhiBatBuocBean selectedFee = listPhiBatBuocBeans.get(table.getSelectedRow());
                    StatisticFeesFrame detail = new StatisticFeesFrame(parentFrame, selectedFee);
                    detail.setLocationRelativeTo(null);
                    detail.setVisible(true);
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().setBackground(Color.white);
        scroll.getViewport().add(table);
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
    
    public void refreshData() {
        this.listPhiBatBuocBeans = this.feesService.allFees();
        setData();
    }
}