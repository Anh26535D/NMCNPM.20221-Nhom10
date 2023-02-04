package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.HomeController;

public class HomePageService {
	
	private HomeController homeController;
	
	public HomePageService(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public int getTongNhanKhau() {
		int result = 0;
		try {
			Connection connection = SQLConnection.getDbConnection();
	        String query = "SELECT COUNT(*) AS tong FROM nhan_khau";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()){
	        	result = rs.getInt("tong");
	        }
	        preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return result;
	}
	
	public int getTongHoKhau() {
		int result = 0;
		try {
			Connection connection = SQLConnection.getDbConnection();
	        String query = "SELECT COUNT(*) AS tong FROM ho_khau";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()){
	        	result = rs.getInt("tong");
	        }
	        preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return result;
	}
	
	public int getTongTamTru() {
		int result = 0;
		try {
			Connection connection = SQLConnection.getDbConnection();
	        String query = "SELECT COUNT(*) AS tong FROM tam_tru WHERE denNgay < GETDATE()";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()){
	        	result = rs.getInt("tong");
	        }
	        preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return result;
	}
	
	public int getTongTamVang() {
		int result = 0;
		try {
			Connection connection = SQLConnection.getDbConnection();
	        String query = "SELECT COUNT(*) AS tong FROM tam_vang WHERE denNgay < GETDATE()";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()){
	        	result = rs.getInt("tong");
	        }
	        preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return result;
	}
	
	
	public int getTongHoKhauConThieu() {
		int result = 0;
		try {
			Connection connection = SQLConnection.getDbConnection();
	        String query = "SELECT COUNT(*) AS tong FROM tam_vang WHERE denNgay < GETDATE()";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()){
	        	result = rs.getInt("tong");
	        }
	        preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return result;
	}
}
