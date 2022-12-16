package services;

import java.sql.*;

public class SQLConnection {
	public static String serverName = "DESKTOP-04NMIDF\\SQLEXPRESS";
	public static String databaseName = "quan_ly_nhan_khau";
	public static String userName = "sa";
	public static String password = "123456";
	
    public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException {

    	String serverName = "127.0.0.1";
    	String url = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=quan_ly_nhan_khau"  + ";encrypt=true;trustServerCertificate=true;";
        String userName = "sa";
        String password = "12345678*A";
        return DriverManager.getConnection(url, userName, password);
    }
    
    public static Connection getMysqlConnection(String serverName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException{
        String url = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=" + dbName  + ";encrypt=true;trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }
}
