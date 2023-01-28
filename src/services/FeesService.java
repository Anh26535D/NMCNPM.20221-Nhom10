package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;

import bean.HoKhauBean;
import bean.PhiBatBuocBean;
import models.FeesModel;
import models.HoKhauModel;

public class FeesService {

	public List<PhiBatBuocBean> allFees() {
		List<PhiBatBuocBean> list = new ArrayList<>();
		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = "SELECT TOP 100 ID, ten_khoan_thu,so_tien,dot_thu FROM phi_bat_buoc ORDER BY phi_bat_buoc.ID";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
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
			exceptionHandle(e.getMessage());
		}
		return list;
	}

	public List<PhiBatBuocBean> searchFeeByID(String keyword) {
		List<PhiBatBuocBean> list = new ArrayList<>();
		if (keyword.trim().isEmpty()) {
			return this.allFees();
		}

		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = "SELECT ID, ten_khoan_thu,so_tien,dot_thu FROM phi_bat_buoc " + "WHERE ID LIKE('%" + keyword
					+ "%');";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
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
			exceptionHandle(e.getMessage());
		}
		return list;
	}

	public boolean newFee(PhiBatBuocBean phiBatBuocBean){
		FeesModel fee = phiBatBuocBean.getFeesModel();
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			String query = "INSERT INTO phi_bat_buoc ( ten_khoan_thu, so_tien, dot_thu, ngay_tao, idNguoiTao)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, fee.getTen_khoan_thu());
			preparedStatement.setInt(2, fee.getSo_tien());
			preparedStatement.setString(3, fee.getDot_thu());
	        preparedStatement.setDate(4, new Date(app.Main.calendar.getTime().getTime()));
	        preparedStatement.setInt(5, LoginService.currentUser.getID());

			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				return true;
			}
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Integer getNeed(HoKhauBean householdBean, FeesModel feesModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			HoKhauModel household = householdBean.getHoKhauModel();
			String maHoKhau = household.getMaHoKhau();
			int idPhiThu = feesModel.getID();
			String query_get_num_of_people_in_household = "SELECT COUNT(*) AS so_luong_nk_trong_hk FROM nhan_khau"
					+ " JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID"
					+ " JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau" + " WHERE ho_khau.maHoKhau = '"
					+ maHoKhau + "';";
			String query_get_basic_fee = "SELECT so_tien FROM phi_bat_buoc"
					+ " WHERE ID = " + idPhiThu + ";";
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query_get_num_of_people_in_household);
				rs.next();
				int num_of_people_in_household = rs.getInt("so_luong_nk_trong_hk");

				rs = st.executeQuery(query_get_basic_fee);
				rs.next();
				int basic_fee = rs.getInt("so_tien");

				connection.close();
				
				return basic_fee*num_of_people_in_household;
			
			} catch (SQLException e) {
				exceptionHandle(e.getMessage());
			}
		} catch (ClassNotFoundException e1) {
			exceptionHandle(e1.getMessage());
		} catch (SQLException e1) {
			exceptionHandle(e1.getMessage());
		}
		return -1;
	}
	
	public Integer getPaid(HoKhauBean householdBean, FeesModel feesModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			HoKhauModel household = householdBean.getHoKhauModel();
			String maHoKhau = household.getMaHoKhau();
			int idPhiThu = feesModel.getID();
			String paid = 
					"SELECT SUM(so_tien) AS tong_tien FROM nop_phi"
					+ " JOIN nhan_khau ON nhan_khau.ID = nop_phi.idNhanKhau"
					+ " JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID"
					+ " JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau"
					+ " WHERE ho_khau.maHoKhau = '" + maHoKhau + "' AND nop_phi.idPhiThu = " + idPhiThu  + ";";
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(paid);
				rs.next();
				int tong_tien = rs.getInt("tong_tien");
				connection.close();
				return tong_tien;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return -1;
	}
	
	public Integer getPaidFee(FeesModel feesModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			int idPhiThu = feesModel.getID();
			String paid = 
					"SELECT SUM(so_tien) AS tong_tien FROM nop_phi"
					+ " WHERE nop_phi.idPhiThu = " + idPhiThu  + ";";
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(paid);
				rs.next();
				int tong_tien = rs.getInt("tong_tien");
				connection.close();
				return tong_tien;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return -1;
	}

	private void exceptionHandle(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
	}

}
