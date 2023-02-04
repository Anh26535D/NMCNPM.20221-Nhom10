package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bean.HoKhauBean;
import bean.PhiUngHoBean;
import models.DonationsModel;
import models.HoKhauModel;

public class DonationsService {

	public List<PhiUngHoBean> allDonations() {
		List<PhiUngHoBean> list = new ArrayList<>();
		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = "SELECT TOP 100 ID, ten_khoan_thu, ngay_tao FROM phi_ung_ho ORDER BY phi_ung_ho.ID";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PhiUngHoBean donationBean = new PhiUngHoBean();
				DonationsModel donation = donationBean.getDonationModel();
				donation.setID(rs.getInt("ID"));
				donation.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
				donation.setNgay_tao(rs.getDate("ngay_Tao"));
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
			String query = "SELECT ID, ten_khoan_thu, ngay_tao FROM phi_ung_ho " + "WHERE ID LIKE('%" + keyword
					+ "%');";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PhiUngHoBean donationBean = new PhiUngHoBean();
				DonationsModel donation = donationBean.getDonationModel();
				donation.setID(rs.getInt("ID"));
				donation.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
				donation.setNgay_tao(rs.getDate("ngay_Tao"));
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
		DonationsModel donation = phiUngHoBean.getDonationModel();
		Connection connection = SQLConnection.getDbConnection();

		String query = "INSERT INTO phi_ung_ho ( ten_khoan_thu, ngay_tao, idNguoiTao)" + " values (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, donation.getTen_khoan_thu());
        preparedStatement.setDate(2, new Date(app.Main.calendar.getTime().getTime()));
        preparedStatement.setInt(3, LoginService.currentUser.getID());

		preparedStatement.executeUpdate();
		ResultSet rs = preparedStatement.getGeneratedKeys();
		connection.close();
		if (rs.next()) {
			return true;
		}
		return false;
	}
	public boolean editDonation(PhiUngHoBean phiUngHoBean, int idDonation){
		DonationsModel donation = phiUngHoBean.getDonationModel();
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			String query = 
					"UPDATE phi_ung_ho "
					+ " SET"
					+ " ten_khoan_thu = ?"
					+ " WHERE ID = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, donation.getTen_khoan_thu());
			preparedStatement.setInt(2, idDonation);

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
	public Integer getNeed(HoKhauBean householdBean, DonationsModel DonationsModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			HoKhauModel household = householdBean.getHoKhauModel();
			String maHoKhau = household.getMaHoKhau();
			int idPhiThu = DonationsModel.getID();
			String query_get_num_of_people_in_household = "SELECT COUNT(*) AS so_luong_nk_trong_hk FROM nhan_khau"
					+ " JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID"
					+ " JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau" + " WHERE ho_khau.maHoKhau = '"
					+ maHoKhau + "';";
			String query_get_basic_Donation = "SELECT so_tien FROM phi_bat_buoc"
					+ " WHERE ID = " + idPhiThu + ";";
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query_get_num_of_people_in_household);
				rs.next();
				int num_of_people_in_household = rs.getInt("so_luong_nk_trong_hk");

				rs = st.executeQuery(query_get_basic_Donation);
				rs.next();
				int basic_Donation = rs.getInt("so_tien");

				connection.close();
				
				return basic_Donation*num_of_people_in_household;
			
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
	
	public Integer getPaid(HoKhauBean householdBean, DonationsModel donationModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			HoKhauModel household = householdBean.getHoKhauModel();
			String maHoKhau = household.getMaHoKhau();
			int idKhoanThu = donationModel.getID();
			String paid = 
					"SELECT SUM(so_tien) AS tong_tien FROM ung_ho"
					+ " JOIN nhan_khau ON nhan_khau.ID = ung_ho.idNhanKhau"
					+ " JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID"
					+ " JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau"
					+ " WHERE ho_khau.maHoKhau = '" + maHoKhau + "' AND ung_ho.idKhoanThu = " + idKhoanThu  + ";";
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

	
	public Integer getPaidDonation(DonationsModel donationModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			int idKhoanThu = donationModel.getID();
			String paid = 
					"SELECT SUM(so_tien) AS tong_tien FROM ung_ho"
					+ " WHERE ung_ho.idKhoanThu = " + idKhoanThu  + ";";
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
