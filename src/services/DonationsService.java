package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bean.HoKhauBean;
import bean.PhiUngHoBean;
import models.DonationModel;
import models.HoKhauModel;

public class DonationsService {

	public List<PhiUngHoBean> allDonations() {
		List<PhiUngHoBean> list = new ArrayList<>();
		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = "SELECT TOP 100 ID, ten_khoan_thu,so_tien FROM khoan_thu_tu_nguyen ORDER BY khoan_thu_tu_nguyen.ID";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PhiUngHoBean donationBean = new PhiUngHoBean();
				DonationModel donation = donationBean.getDonationModel();
				donation.setID(rs.getInt("ID"));
				donation.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
				donation.setSo_tien(rs.getInt("so_tien"));
				list.add(donationBean);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			exceptionHandle(e.getMessage());
		}
		return list;
	}

	public List<PhiUngHoBean> searchDonationByID(String keyword) {
		List<PhiUngHoBean> list = new ArrayList<>();
		if (keyword.trim().isEmpty()) {
			return this.allDonations();
		}

		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = "SELECT ID, ten_khoan_thu,so_tien FROM khoan_thu_tu_nguyen " + "WHERE ID LIKE('%" + keyword
					+ "%');";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PhiUngHoBean donationBean = new PhiUngHoBean();
				DonationModel donation = donationBean.getDonationModel();
				donation.setID(rs.getInt("ID"));
				donation.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
				donation.setSo_tien(rs.getInt("so_tien"));
				list.add(donationBean);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			exceptionHandle(e.getMessage());
		}
		return list;
	}

	public boolean newDonation(PhiUngHoBean phiUngHoBean) throws SQLException, ClassNotFoundException {
		DonationModel donation = phiUngHoBean.getDonationModel();
		Connection connection = SQLConnection.getDbConnection();

		String query = "INSERT INTO khoan_thu_tu_nguyen ( ten_khoan_thu, so_tien)" + " values (?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, donation.getTen_khoan_thu());
		preparedStatement.setInt(2, donation.getSo_tien());

		preparedStatement.executeUpdate();
		ResultSet rs = preparedStatement.getGeneratedKeys();
		connection.close();
		if (rs.next()) {
			return true;
		}
		return false;
	}
	
	public Integer getNeed(HoKhauBean householdBean, DonationModel donationModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			HoKhauModel household = householdBean.getHoKhauModel();
			String maHoKhau = household.getMaHoKhau();
			int idKhoanThu = donationModel.getID();
			String query_get_num_of_people_in_household = "SELECT COUNT(*) AS so_luong_nk_trong_hk FROM nhan_khau"
					+ " JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID"
					+ " JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau" + " WHERE ho_khau.maHoKhau = '"
					+ maHoKhau + "';";
			String query_get_basic_donation = "SELECT so_tien FROM khoan_thu_tu_nguyen"
					+ " WHERE ID = " + idKhoanThu + ";";
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query_get_num_of_people_in_household);
				rs.next();
				int num_of_people_in_household = rs.getInt("so_luong_nk_trong_hk");

				rs = st.executeQuery(query_get_basic_donation);
				rs.next();
				int basic_donation = rs.getInt("so_tien");

				connection.close();
				
				return basic_donation*num_of_people_in_household;
			
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
	
	public Integer getPaid(HoKhauBean householdBean, DonationModel donationModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			HoKhauModel household = householdBean.getHoKhauModel();
			String maHoKhau = household.getMaHoKhau();
			int idKhoanThu = donationModel.getID();
			String paid = 
					"SELECT SUM(so_tien) AS tong_tien FROM nop_tien"
					+ " JOIN nhan_khau ON nhan_khau.ID = nop_tien.idNhanKhau"
					+ " JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID"
					+ " JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau"
					+ " WHERE ho_khau.maHoKhau = '" + maHoKhau + "' AND nop_tien.idKhoanThu = " + idKhoanThu  + ";";
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
	
	public Integer getPaidDonation(DonationModel donationModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			int idKhoanThu = donationModel.getID();
			String paid = 
					"SELECT SUM(so_tien) AS tong_tien FROM nop_tien"
					+ " WHERE nop_tien.idKhoanThu = " + idKhoanThu  + ";";
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
