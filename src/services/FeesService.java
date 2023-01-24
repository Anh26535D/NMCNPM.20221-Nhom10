package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bean.PhiBatBuocBean;
import models.FeesModel;

public class FeesService {

	public List<PhiBatBuocBean> allFees() {
        List<PhiBatBuocBean> list = new ArrayList<>();
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT TOP 100 ID, ten_khoan_thu,so_tien,dot_thu FROM phi_bat_buoc ORDER BY phi_bat_buoc.ID";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
            	PhiBatBuocBean feeBean = new PhiBatBuocBean();
                FeesModel fee = feeBean.getFeesModel();
                fee.setID(rs.getInt("ID"));
                fee.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
                fee.setSo_tien(rs.getInt("so_tien"));
                fee.setDot_thu(rs.getString("dot_thu"));
                list.add(feeBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
	
    public List<PhiBatBuocBean> searchFeeByID(String keyword) {
        List<PhiBatBuocBean> list = new  ArrayList<>();
        if (keyword.trim().isEmpty()) {
            return this.allFees();
        }
        
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT ID, ten_khoan_thu,so_tien,dot_thu FROM phi_bat_buoc "
            	      + "WHERE ID LIKE('%" 
            	      + keyword
            	      + "%');";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
            	PhiBatBuocBean feeBean = new PhiBatBuocBean();
                FeesModel fee = feeBean.getFeesModel();
                fee.setID(rs.getInt("ID"));
                fee.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
                fee.setSo_tien(rs.getInt("so_tien"));
                fee.setDot_thu(rs.getString("dot_thu"));
                list.add(feeBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    public boolean newFee(PhiBatBuocBean phiBatBuocBean) throws SQLException, ClassNotFoundException{
        FeesModel fee = phiBatBuocBean.getFeesModel();
        Connection connection = SQLConnection.getDbConnection();

        String query = "INSERT INTO phi_bat_buoc ( ten_khoan_thu, so_tien, dot_thu)" 
                        + " values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, fee.getTen_khoan_thu());
        preparedStatement.setInt(2, fee.getSo_tien());
        preparedStatement.setString(3, fee.getDot_thu());
        
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
        	return true;
        }
        connection.close();
        return false;
    }
    
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
