package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AddressService {

	public List<String> getWards() {
		List<String> list = new ArrayList<>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT DISTINCT name FROM wards;";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String ward = rs.getString("name");
				list.add(ward);
			}
			connection.close();
		} catch (Exception e) {
			handleException();
		}
		return list;
	}

	public List<String> searchByWard(String key) {
		List<String> list = new ArrayList<>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT DISTINCT TOP 10 name FROM wards " + "WHERE CONTAINS(name, '\"*" + key + "*\"');";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String ward = rs.getString("name");
				list.add(ward);
			}
			connection.close();
		} catch (Exception e) {
			handleException();
		}
		return list;
	}

	public List<String> searchByDistrict(String key) {
		List<String> list = new ArrayList<>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT DISTINCT TOP 10 name FROM districts " + "WHERE CONTAINS(name, '\"*" + key + "*\"');";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String ward = rs.getString("name");
				list.add(ward);
			}
			connection.close();
		} catch (Exception e) {
			handleException();
		}
		return list;
	}

	public List<String> searchByProvince(String key) {
		List<String> list = new ArrayList<>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT DISTINCT TOP 10 name FROM provinces " + "WHERE CONTAINS(name, '\"*" + key + "*\"');";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String ward = rs.getString("name");
				list.add(ward);
			}
			connection.close();
		} catch (Exception e) {
			handleException();
		}
		return list;
	}

	private void handleException() {
		JOptionPane.showMessageDialog(null, "Có lỗi xảy ra, thử kiểm tra lại cơ sở dữ liệu", "Warning",
				JOptionPane.ERROR_MESSAGE);
	}

}
