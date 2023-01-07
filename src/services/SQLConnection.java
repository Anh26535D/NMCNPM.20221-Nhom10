package services;

import java.sql.*;

public class SQLConnection {
//	Anh Dam
	public static String serverName = "DESKTOP-04NMIDF\\\\SQLEXPRESS"; 
//	Quan
//	public static String serverName = "DESKTOP-2M64U04\\\\SQLEXPRESS";
	public static String databaseName = "quan_ly_nhan_khau";
	public static String userName = "sa";
	public static String password = "123456";
	
    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://" + SQLConnection.serverName + ":1433;DatabaseName=" + SQLConnection.databaseName + ";encrypt=true;trustServerCertificate=true;";
        return DriverManager.getConnection(url, SQLConnection.userName, SQLConnection.password);
    }

    public static Connection getDbConnection(String dbName) throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }
}