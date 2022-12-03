package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbservice.DatabaseConnector;

public class LocationService {
	public ArrayList<String> getAllProvince(){
		ArrayList<String> result = new ArrayList<String>();
		try {
			String sql = "SELECT name from provinces";
			PreparedStatement st = DatabaseConnector.connect.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				result.add(res.getString(1));
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<String> getAllDistrictsOfProvince(String province_name){
		ArrayList<String> result = new ArrayList<String>();
		try {
			String sql = "SELECT districts.name FROM districts JOIN provinces ON districts.province_code = provinces.code WHERE provinces.name=?";
			PreparedStatement st = DatabaseConnector.connect.prepareStatement(sql);
			st.setString(1, province_name);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				result.add(res.getString(1));
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<String> getAllWardsOfDistricts(String district_name,String province_name){
		ArrayList<String> result = new ArrayList<String>();
		try {
			String sql = "SELECT wards.name FROM wards "
					+ "JOIN districts ON wards.district_code = districts.code"
					+ "JOIN provinces ON districts.province_code = provinces.code"
					+ "WHERE provinces.name=? AND districts.name =?";
			PreparedStatement st = DatabaseConnector.connect.prepareStatement(sql);
			st.setString(1, province_name);
			st.setString(2, district_name);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				result.add(res.getString(1));
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
